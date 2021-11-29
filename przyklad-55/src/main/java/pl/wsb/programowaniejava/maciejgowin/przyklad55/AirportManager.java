package pl.wsb.programowaniejava.maciejgowin.przyklad55;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class AirportManager implements AutoCloseable {

    private final Session session;

    public AirportManager(SessionFactory sessionFactory) {
        this.session = sessionFactory.openSession();
    }

    public List<Airport> getAirports() {
        session.getTransaction().begin();
        List<Airport> value = session.createQuery("FROM Airport", Airport.class).list();
        session.getTransaction().commit();
        return value;
    }

    public Optional<Airport> getAirport(String code) {
       return Optional.ofNullable(session.find(Airport.class, code));
    }

    public void addAirport(Airport airport) {
        session.getTransaction().begin();
        session.save(airport);
        session.getTransaction().commit();
    }

    public void updateAirport(Airport airport) {
        getAirport(airport.getCode()).ifPresent(existingAirport -> {
            session.getTransaction().begin();
            existingAirport.setName(airport.getName());
            existingAirport.setLatitude(airport.getLatitude());
            existingAirport.setLongitude(airport.getLongitude());
            session.update(existingAirport);
            session.getTransaction().commit();
        });
    }

    public void deleteAirports() {
        session.getTransaction().begin();
        session.createQuery("DELETE FROM Airport").executeUpdate();
        session.clear();
        session.getTransaction().commit();
    }

    @Override
    public void close() {
        if (session != null) {
            session.close();
        }
    }
}
