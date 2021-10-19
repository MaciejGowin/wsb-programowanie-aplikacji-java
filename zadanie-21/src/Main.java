enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public static Direction safeValueOf(String value) {
        for(Direction direction: values()) {
            if (direction.name().equals(value)) {
                return direction;
            }
        }
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(Direction.safeValueOf("NORTH"));
        System.out.println(Direction.safeValueOf("UNKNOWN"));
        System.out.println(Direction.safeValueOf(null));
    }
}
