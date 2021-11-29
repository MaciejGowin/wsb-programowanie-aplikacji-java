package pl.wsb.programowaniejava.maciejgowin.przyklad62;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(City.class)
                .buildSessionFactory()) {

            Country pl = new Country("pl", "Poland");
            Country de = new Country("de", "Germany");

            List<City> cities = List.of(
                    new City("Warsaw", pl),
                    new City("Berlin", de),
                    new City("Unknown", null));

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(pl);
            session.save(de);
            cities.forEach(session::save);
            session.getTransaction().commit();

            System.out.println("Cities: " + session.createQuery("FROM City", City.class).list());
            System.out.println("Cities (JOIN): " + session.createQuery("SELECT c FROM City c JOIN c.country", City.class).list());
        }
    }
}
