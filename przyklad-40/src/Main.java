import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        System.out.printf("First character: %s: %s%n", "bit", firstCharacter("bit").orElse('-'));
        System.out.printf("First character: %s: %s%n", "9bit", firstCharacter("9bit").orElse('-'));
        System.out.printf("First character: %s: %s%n", "", firstCharacter("").orElse('-'));
        System.out.printf("First character: %s: %s%n", null, firstCharacter(null).orElse('-'));

        System.out.printf("Starts with digit: %s: %s%n", "bit", startsWithDigit("bit"));
        System.out.printf("Starts with digit: %s: %s%n", "9bit", startsWithDigit("9bit"));
        System.out.printf("Starts with digit: %s: %s%n", "", startsWithDigit(""));
        System.out.printf("Starts with digit: %s: %s%n", null, startsWithDigit(null));
    }

    public static Optional<Character> firstCharacter(String value) {
        return Optional.ofNullable(value)
                .filter(v -> v.length() > 0)
                .map(v -> v.charAt(0));
    }

    public static boolean startsWithDigit(String value) {
        return firstCharacter(value).filter(c -> Character.isDigit(c)).isPresent();
    }
}
