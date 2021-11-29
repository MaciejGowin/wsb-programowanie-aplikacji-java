package pl.wsb.programowaniejava.maciejgowin.przyklad55;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             AirportManager airportManager = new AirportManager(factory)) {

            // List airports
            System.out.printf("Check (1): %s%n", airportManager.getAirports());

            // Delete airports
            airportManager.deleteAirports();

            // List airports
            System.out.printf("Check (2): %s%n", airportManager.getAirports());

            // Add airports
            airportManager.addAirport(new Airport("WRO", "Wroclaw", 1.1, 11.11));
            airportManager.addAirport(new Airport("DUB", "Dublin", 2.2, 22.22));
            airportManager.addAirport(new Airport("PRG", "Prague", 3.3, 33.33));

            // List airports
            System.out.printf("Check (3): %s%n", airportManager.getAirports());

            // Get airport by code
            System.out.printf("Check (4): %s%n", airportManager.getAirport("WRO"));
            System.out.printf("Check (5): %s%n", airportManager.getAirport("BCN"));

            // Update airport
            airportManager.updateAirport(new Airport("WRO", "Wroclaw Miasto Spotkan", 1.1, 11.11));

            // List airports
            System.out.printf("Check (6): %s%n", airportManager.getAirports());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
