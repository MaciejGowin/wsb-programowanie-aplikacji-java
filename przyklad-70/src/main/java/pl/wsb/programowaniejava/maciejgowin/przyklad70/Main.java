package pl.wsb.programowaniejava.maciejgowin.przyklad70;

public class Main {

    public static void main(String[] args) {
        Airport airport1 = new Airport();
        airport1.setCode("WRO");
        Airport airport2 = new Airport("KRK", "Krakow");

        System.out.println("Check (1): " + airport1);
        System.out.println("Check (2): " + airport2);
        System.out.println("Check (3): " + airport1.equals(new Airport("WRO", null)));
        System.out.println("Check (4): " + airport1.equals(new Airport("WMI", null)));

        Route route = Route.builder().departure("DUB").arrival("STN").build();
        System.out.println("Check (5): " + route);
    }
}
