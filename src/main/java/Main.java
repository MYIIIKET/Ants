import engine.GeneticEngine;
import example.LetterGene;

import java.util.Random;

public class Main {

    private static final int PAUSE = 100;
    public static final Window WINDOW = new Window();
    public static final Field FIELD = new Field();

    public static void main(String[] args) {

        WINDOW.add(FIELD);
        int size = 100;
        Random r = new Random();
        int random;
        for (int i = 0; i < size; i++) {
            random = r.nextInt((3 - 1) + 1) + 1;
            switch (random) {
                case 1:
                    FIELD.getDrawables().add(Herbivore.builder().build());
                    break;
                case 2:
                    FIELD.getDrawables().add(Predator.builder().build());
                    break;
                case 3:
                    FIELD.getDrawables().add(Herb.builder().build());
                    break;
            }
        }
        FIELD.repaint();
    }
}
