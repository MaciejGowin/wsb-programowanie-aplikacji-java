package pl.gowin.invoice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .buildSessionFactory()) {

            City city = new City(null, "Warszawa");
            Country country = new Country("pl", "Poland", city);
            try (Session session = sessionFactory.openSession()) {
                session.getTransaction().begin();
                session.save(country);
                session.getTransaction().commit();
            }
        }
    }

    public static void addOrder(final double value, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(new Order(value, "test"));
            session.getTransaction().commit();
        }
    }

}
