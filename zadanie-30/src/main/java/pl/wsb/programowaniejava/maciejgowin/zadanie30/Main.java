package pl.wsb.programowaniejava.maciejgowin.zadanie30;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Zadanie 30: Hibernate dla projektu lotnisk, lotów, klientów oraz rezerwacji");

        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Airport.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Flight.class)
                .addAnnotatedClass(Booking.class)
                .buildSessionFactory()) {

            // Cleanup
            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                session.createQuery("DELETE Booking").executeUpdate();
                session.createQuery("DELETE Flight").executeUpdate();
                session.createQuery("DELETE Customer").executeUpdate();
                session.createQuery("DELETE Airport ").executeUpdate();
                session.getTransaction().commit();
            }

            // Storage
            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                Customer customer = new Customer("Jan", "Nowak", LocalDate.of(1999, 12, 11));
                session.save(customer);

                Airport airportWro = new Airport("WRO", "Wroclaw", 1.1, 2.2);
                session.save(airportWro);

                Airport airportDub = new Airport("DUB", "Wroclaw", 11.11, 22.22);
                session.save(airportDub);

                Flight flight = new Flight(airportWro, airportDub, LocalDateTime.now(), LocalDateTime.now());
                session.save(flight);

                Booking booking = new Booking(customer, flight, new BigDecimal("10.11"));
                session.save(booking);

                session.getTransaction().commit();
            }

            // Retrieve
            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                List<Booking> bookings = session.createQuery("FROM Booking", Booking.class).list();
                System.out.println(bookings);
                session.getTransaction().commit();
            }
        }
    }
}
