package pl.wsb.programowaniejava.maciejgowin.przyklad79.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wsb.programowaniejava.maciejgowin.przyklad79.model.Airport;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AirportReader {

    @Autowired
    private SessionFactory sessionFactory;

    public Map<String, String> getAirportNames() {
        return getAirports().stream()
                .collect(Collectors.toMap(Airport::getCode, Airport::getName));
    }

    public List<Airport> getAirports() {
        try (Session session = sessionFactory.openSession()) {
            Query<Airport> query = session.createQuery("FROM Airport", Airport.class);
            return query.list();
        }
    }
}
