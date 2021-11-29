package pl.wsb.programowaniejava.maciejgowin.przyklad61.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(City.class)
                .buildSessionFactory()) {


            City warsaw = new City("Warsaw");
            City berlin = new City("Berlin");
            Country pl = new Country("pl", "Poland", warsaw);
            Country de = new Country("de", "Germany", berlin);
            Country cz = new Country("cz", "Czech", null);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(warsaw);
            session.save(berlin);
            session.save(pl);
            session.save(de);
            session.save(cz);
            session.getTransaction().commit();

            System.out.println("Countries: " + session.createQuery("FROM Country").list());
            System.out.println("Cities: " + session.createQuery("FROM City").list());
        }
    }
}
