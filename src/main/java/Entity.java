import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class Entity implements Drawable {
    private UUID id;
    private Color color;
    private Size size;
    private Coordinate coordinate;
    private EntityType type;
    private DrawingMethod drawingMethod;

    public Entity(Size size, Coordinate coordinate, EntityType type, DrawingMethod drawingMethod) {
        this.id = UUID.randomUUID();
        this.type = type == null ? EntityType.EMPTY : type;
        this.color = type.getColor();
        this.size = size == null ? Size.builder().width(5).height(5).build() : size;
        this.coordinate = coordinate == null ? Coordinate.getRandom() : coordinate;
        this.drawingMethod = drawingMethod == null ? graphics -> {
            graphics.setColor(getColor());
            graphics.fill(
                    new Ellipse2D.Double(
                            getCoordinate().getX(),
                            getCoordinate().getY(),
                            getSize().getWidth(),
                            getSize().getHeight()));
        } : drawingMethod;
    }

    @Override
    public void draw(Graphics2D graphics) {
        drawingMethod.apply(graphics);
    }
}

