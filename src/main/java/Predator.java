import lombok.Builder;
import lombok.Data;

import java.awt.*;

@Data
public class Predator extends Animal {
    @Builder
    public Predator(Size size, Coordinate coordinate, DrawingMethod method) {
        super(size, coordinate, EntityType.PREDATOR, method);
    }
}
