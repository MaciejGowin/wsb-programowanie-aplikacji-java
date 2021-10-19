import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.printf("Is digit: %s: %s%n", 0, isDigit(0));
        System.out.printf("Is digit: %s: %s%n", 9, isDigit(9));
        System.out.printf("Is digit: %s: %s%n", 10, isDigit(10));
        System.out.printf("Is digit: %s: %s%n", -1, isDigit(-1));
        System.out.printf("Is digit: %s: %s%n", null, isDigit(null));
    }

    public static boolean isDigit(Integer value) {
        return Optional.ofNullable(value)
                .filter(v -> v >= 0)
                .filter(v -> v <= 9)
                .isPresent();
    }

    public static boolean isDigitWithoutOptional(Integer value) {
        boolean isDigit = false;
        if (value != null && value >= 0 && value <= 9) {
            isDigit = true;
        }
        return isDigit;
    }
}
