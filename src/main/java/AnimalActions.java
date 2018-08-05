import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AnimalActions implements Action {
    FIND_TARGET(Animal::findTarget),
    MOVE_TO_TARGET(Animal::moveToTarget),
    MOVE_UP(Animal::moveUp),
    MOVE_UP_RIGHT(Animal::moveUpRight),
    MOVE_RIGHT(Animal::moveRight),
    MOVE_DOWN_RIGHT(Animal::moveDownRight),
    MOVE_DOWN(Animal::moveDown),
    MOVE_DOWN_LEFT(Animal::moveDownLeft),
    MOVE_LEFT(Animal::moveLeft),
    MOVE_UP_LEFT(Animal::moveUpLeft);

    public final Action action;

    @Override
    public void apply(Animal animal) {
        action.apply(animal);
    }
}
