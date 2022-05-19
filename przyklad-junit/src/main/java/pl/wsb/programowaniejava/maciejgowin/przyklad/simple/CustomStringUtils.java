package pl.wsb.programowaniejava.maciejgowin.przyklad.simple;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomStringUtils {

    public static String concat(String part1, String part2) {
        return part1 + part2;
    }

    public static boolean contains(String text, String search) {
        return text.contains(search);
    }

    public static int mapToNumber(String text) {
        if (text == null) {
            return 1;
        }
        if (text.length() > 5 && text.length() < 12) {
            return 2;
        }

        return 3;
    }
}
