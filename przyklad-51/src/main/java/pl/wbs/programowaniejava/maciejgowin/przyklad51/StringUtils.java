package pl.wbs.programowaniejava.maciejgowin.przyklad51;

public class StringUtils {

    public static final String COMMA = ",";
    public static final String SPACE = " ";
    public static final String EMPTY = " ";

    public static int compare(String first, String second) {
        return emptyOnNull(first).compareTo(emptyOnNull(second));
    }

    public static String emptyOnNull(String value) {
        return value != null ? value : EMPTY;
    }
}
