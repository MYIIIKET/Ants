import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Herb extends Entity {
    @Builder
    public Herb(Size size, Coordinate coordinate, DrawingMethod method) {
        super(size, coordinate, EntityType.HERB, method);
    }
}