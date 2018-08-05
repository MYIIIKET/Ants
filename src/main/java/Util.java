import lombok.experimental.var;

public class Util {

    public static double getDistance(Coordinate a, Coordinate b) {
        return getDistance((int) (b.getX() - a.getX()), (int) (b.getY() - a.getY()));
    }

    private static double getDistance(int dx, int dy) {
        int min;
        int max;
        if (dx < 0) dx = -dx;
        if (dy < 0) dy = -dy;
        if (dx < dy) {
            min = dx;
            max = dy;
        } else {
            min = dy;
            max = dx;
        }
        return (((max << 8) + (max << 3) - (max << 4) - (max << 1) +
                (min << 7) - (min << 5) + (min << 3) - (min << 1)) >> 8);
    }

    public static Double compute(Animal animal, Entity entity) {
        final double formula = computeFormula(animal, entity);
        final double value;
        EntityType animalType = animal.getType();
        EntityType entityType = entity.getType();
        if (EntityType.PREDATOR.equals(animalType) && EntityType.HERBIVORE.equals(entityType)) {
            value = formula;
        } else if (EntityType.HERBIVORE.equals(animalType) && EntityType.PREDATOR.equals(entityType)) {
            value = -formula;
        } else if (EntityType.HERBIVORE.equals(animalType) && EntityType.HERB.equals(entityType)) {
            value = formula;
        } else {
            value = 0;
        }
        return value;
    }

    private static double computeFormula(Animal animal, Entity entity) {
        final double healthValue = 1 / animal.getHealth();
        final double distanceValue = 1 / Util.getDistance(animal.getCoordinate(), entity.getCoordinate());
        final double coefficient = healthValue * distanceValue;
        final double entityValue = entity.getType().getValue();
        return entityValue * coefficient;
    }

    public static void updatePosition(Animal animal, double dX, double dY) {
        Coordinate coordinate = animal.getCoordinate();
        double tX = coordinate.getX() + dX;
        double tY = coordinate.getY() + dY;
        double step = animal.getStep();
        double dirX;
        double dirY;
        double dir;
        dirX = (tX - coordinate.getX());
        dirY = (tY - coordinate.getY());
        dir = Math.atan2(dirY, dirX);

        coordinate.setX(coordinate.getX() + Math.cos(dir) * step);
        coordinate.setY(coordinate.getY() + Math.sin(dir) * step);
    }

    public static Coordinate getBestOpportunity(Animal animal) {
        return null;
    }
}
