package pl.wsb.programowaniejava.maciejgowin.przyklad79.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wsb.programowaniejava.maciejgowin.przyklad79.model.Airport;
import pl.wsb.programowaniejava.maciejgowin.przyklad79.model.Route;

import java.util.List;

@Component
public class RouteReader {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Route> getRoutes() {
        try (Session session = sessionFactory.openSession()) {
            Query<Route> query = session.createQuery("FROM Route", Route.class);
            return query.list();
        }
    }
}
