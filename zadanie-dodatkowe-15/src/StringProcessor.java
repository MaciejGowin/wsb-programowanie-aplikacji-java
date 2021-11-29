import java.util.stream.Collectors;

public class StringProcessor {

    public static String upperCase(String value) {
        return value != null ? value.toUpperCase() : null;
    }

    public static String letterSpaceSeparated(String value) {
        if (value != null) {
            return value.chars()
                    .mapToObj(i -> Character.toString((char) i))
                    .collect(Collectors.joining(" "));
        }
        return null;
    }
}
