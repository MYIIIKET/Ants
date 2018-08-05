import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class Animal extends Entity implements Movable {
    private double health;
    private double healthDelta;
    private double step;
    private Coordinate target = Coordinate.getRandom();

    public Animal(Size size, Coordinate coordinate, EntityType type, DrawingMethod method) {
        super(size, coordinate, type, method);
        this.health = super.getType().getHealth();
        this.healthDelta = super.getType().getHealthDelta();
    }

    public Coordinate findTarget() {
        return Util.getBestOpportunity(this);
    }

    public void moveTo(Coordinate coordinate) {
        double distance = Util.getDistance(getCoordinate(), coordinate);
        if (step < distance) {
            Util.updatePosition(this, 0, 0);
        } else {
            getCoordinate().setX(coordinate.getX());
            getCoordinate().setY(coordinate.getY());
        }
    }

    public void moveToTarget() {
        this.moveTo(getTarget());
    }

    public void moveUp() {
        Util.updatePosition(this, 0, -step);
    }

    public void moveUpRight() {
        Util.updatePosition(this, step, -step);
    }

    public void moveRight() {
        Util.updatePosition(this, step, 0);
    }

    public void moveDownRight() {
        Util.updatePosition(this, step, step);
    }

    public void moveDown() {
        Util.updatePosition(this, 0, step);
    }

    public void moveDownLeft() {
        Util.updatePosition(this, -step, step);
    }

    public void moveLeft() {
        Util.updatePosition(this, -step, 0);
    }

    public void moveUpLeft() {
        Util.updatePosition(this, -step, -step);
    }
}
