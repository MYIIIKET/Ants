import java.awt.Graphics2D;

@FunctionalInterface
public interface DrawingMethod {
    void apply(Graphics2D graphics);
}
