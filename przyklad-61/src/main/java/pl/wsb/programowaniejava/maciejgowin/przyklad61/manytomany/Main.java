package pl.wsb.programowaniejava.maciejgowin.przyklad61.manytomany;

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

            City warsaw = new City("Warsaw");
            City cracow = new City("Cracow");
            City berlin = new City("Berlin");
            City goerlitz = new City("Goerlitz");

            List<Country> countries = List.of(
                    new Country("pl", "Poland", List.of(warsaw, cracow, goerlitz)),
                    new Country("de", "Germany", List.of(berlin, goerlitz)));

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(warsaw);
            session.save(cracow);
            session.save(berlin);
            session.save(goerlitz);
            countries.forEach(session::save);
            session.getTransaction().commit();

            System.out.println("Countries: " + session.createQuery("FROM Country").list());
            System.out.println("Cities: " + session.createQuery("FROM City").list());
        }
    }
}
