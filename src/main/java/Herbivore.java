import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Herbivore extends Animal {
    @Builder
    public Herbivore(Size size, Coordinate coordinate, DrawingMethod method) {
        super(size, coordinate, EntityType.HERBIVORE, method);
    }
}
