package pl.wsb.programowaniejava.maciejgowin.przyklad58;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static java.time.LocalDateTime.parse;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .addAnnotatedClass(Flight.class)
                .buildSessionFactory()) {

            FlightManager flightManager = new FlightManager(factory);

            flightManager.deleteFlights();

            System.out.printf("Check (1): %s%n", flightManager.getFlights());
            System.out.printf("Check (2): %s%n", flightManager
                    .addFlight("DUB", "WRO", parse("2022-01-14T17:15"), parse("2022-01-14T19:45")));
            System.out.printf("Check (3): %s%n", flightManager
                    .addFlight("DUB", "KRK", parse("2022-01-20T11:30"), parse("2022-01-20T12:55")));
            System.out.printf("Check (4): %s%n", flightManager
                    .addFlight("WRO", "DUB", parse("2022-01-20T08:00"), parse("2022-01-20T09:15")));
            System.out.printf("Check (5): %s%n", flightManager.getFlights());
        } catch(Exception e) {
            System.out.printf("Failed: %s%n", e.getMessage());
        }
    }
}
