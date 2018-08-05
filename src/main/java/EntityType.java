import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.Color;

@Getter
@RequiredArgsConstructor
public enum EntityType {
    HERB(Color.GREEN, 0, 0, 1),
    HERBIVORE(Color.BLUE, 100, 1, 3),
    PREDATOR(Color.RED, 100, 1, 3),
    OBSTACLE(Color.GRAY, 0, 0, 0),
    EMPTY(Color.WHITE, 0, 0, 0);

    private final Color color;
    private final double health;
    private final double healthDelta;
    private final double value;
}
