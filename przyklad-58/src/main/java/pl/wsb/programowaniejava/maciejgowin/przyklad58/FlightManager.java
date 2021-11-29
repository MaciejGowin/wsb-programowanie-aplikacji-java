package pl.wsb.programowaniejava.maciejgowin.przyklad58;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class FlightManager {

    private final SessionFactory sessionFactory;

    public FlightManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Flight> getFlights() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Flight> customers = session.createQuery("FROM Flight", Flight.class).list();
            session.getTransaction().commit();
            return customers;
        }
    }

    public Optional<Integer> addFlight(String departureAirportCode, String arrivalAirportCode,
                                       LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(
                    new Flight(departureAirportCode, arrivalAirportCode, departureDateTime, arrivalDateTime));
            session.getTransaction().commit();
            return Optional.ofNullable(id);
        }
    }


    public void deleteFlights() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createQuery("DELETE FROM Flight").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
