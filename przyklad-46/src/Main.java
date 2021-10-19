import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {

    public static void main(String[] args) {
        LocalDateTime value = LocalDateTime.parse("2021-07-01T01:21:31");

        System.out.println("toString: " + value.toString());
        System.out.println("ISO_DATE_TIME: " + value.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("ISO_LOCAL_DATE_TIME: " + value.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("ISO_LOCAL_DATE: " + value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("LocalizedDateTime MEDIUM: " + value.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println("LocalizedDate FULL: " + value.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println("custom: " + value.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        System.out.println("custom: " + value.format(DateTimeFormatter.ofPattern("yy/M/d H:m:s")));
        System.out.println("custom: " + value.format(DateTimeFormatter.ofPattern("yy/M/d H:m:s")));
    }
}
