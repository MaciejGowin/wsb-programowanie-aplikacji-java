package pl.wsb.programowaniejava.maciejgowin.przyklad61.manytoone;

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
                    new City("Cracow", pl),
                    new City("Berlin", de));

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(pl);
            session.save(de);
            cities.forEach(session::save);
            session.getTransaction().commit();

            System.out.println("Countries: " + session.createQuery("FROM Country").list());
            System.out.println("Cities: " + session.createQuery("FROM City").list());
        }
    }
}
