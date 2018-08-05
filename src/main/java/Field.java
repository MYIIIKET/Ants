import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Field extends JPanel {

    private List<Entity> entities = new ArrayList<>();

    public Field() {
        setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        entities.forEach(entity -> entity.draw((Graphics2D) g));
    }

    public List<Entity> getDrawables() {
        return entities;
    }
}
