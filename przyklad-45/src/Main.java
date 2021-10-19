import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) {
        System.out.printf("##### Local%n");

        // Winter
        LocalDateTime winterLocal = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        // Summer
        LocalDateTime summerLocal = LocalDateTime.parse("2021-07-01T00:00:00");

        System.out.println("Winter Local: " + winterLocal);
        System.out.println("Summer Local: " + summerLocal);

        System.out.printf("%n##### Same instant%n");

        // Zones
        ZoneId warsawZone = ZoneId.of("Europe/Warsaw");
        ZoneId dublinZone = ZoneId.of("Europe/Dublin");

        ZonedDateTime winterWarsawZone = ZonedDateTime.of(winterLocal, warsawZone);
        ZonedDateTime summerWarsawZone = ZonedDateTime.of(summerLocal, warsawZone);

        System.out.println("Winter Warsaw Zoned: " + winterWarsawZone);
        System.out.println("Summer Warsaw Zoned: " + summerWarsawZone);

        System.out.println("Winter Warsaw Offset: " + winterWarsawZone.toOffsetDateTime());
        System.out.println("Summer Warsaw Offset: " + summerWarsawZone.toOffsetDateTime());

        System.out.println("Winter Dublin Zoned: " + winterWarsawZone.withZoneSameInstant(dublinZone));
        System.out.println("Summer Dublin Zoned: " + summerWarsawZone.withZoneSameInstant(dublinZone));

        System.out.println("Winter Dublin Offset: " + winterWarsawZone.withZoneSameInstant(dublinZone).toOffsetDateTime());
        System.out.println("Summer Dublin Offset: " + summerWarsawZone.withZoneSameInstant(dublinZone).toOffsetDateTime());

        System.out.printf("%n##### Same local%n");

        System.out.println("Winter Warsaw Zoned: " + winterWarsawZone);
        System.out.println("Summer Warsaw Zoned: " + summerWarsawZone);

        System.out.println("Winter Dublin Zoned (same local): " + winterWarsawZone.withZoneSameLocal(dublinZone));
        System.out.println("Summer Dublin Zoned (same local): " + summerWarsawZone.withZoneSameLocal(dublinZone));
    }
}
