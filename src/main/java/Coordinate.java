import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coordinate {
    private double x;
    private double y;

    public static Coordinate getRandom() {
        return Coordinate.builder()
                .x(Math.random() * Main.WINDOW.getWidth())
                .y(Math.random() * Main.WINDOW.getHeight())
                .build();
    }
}
