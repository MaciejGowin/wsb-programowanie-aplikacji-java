package pl.wsb.programowaniejava.maciejgowin.zadanie28;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Country.class)
                .buildSessionFactory()) {
            cleanup(sessionFactory);

            testSave(sessionFactory);
            testSaveDuplicate(sessionFactory);

            testPersist(sessionFactory);
            testPersistDuplicate(sessionFactory);

            testGetExisting(sessionFactory);
            testGetMissing(sessionFactory);

            testLoadExisting(sessionFactory);
            testLoadMissing(sessionFactory);

            testUpdateExisting(sessionFactory);
            testUpdateMissing(sessionFactory);
        }
    }

    public static void testSave(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country = new Country("pl", "Poland");
            session.save(country);
            session.getTransaction().commit();
        }
    }

    public static void testSaveDuplicate(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country = new Country("pl", "Poland");
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Failed: " + ex.getMessage());
        }
    }

    public static void testPersist(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country = new Country("de", "Germany");
            session.persist(country);
            session.getTransaction().commit();
        }
    }

    public static void testPersistDuplicate(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Country country = new Country("de", "Germany");
            session.persist(country);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Failed: " + ex.getMessage());
        }
    }

    public static void testGetExisting(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Country country = session.get(Country.class, "de");
            System.out.printf("testGetExisting: %s%n", country);
        }
    }

    public static void testGetMissing(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Country country = session.get(Country.class, "xx");
            System.out.printf("testGetMissing: %s%n", country);
        }
    }

    public static void testLoadExisting(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Country country = session.load(Country.class, "de");
            System.out.printf("testLoadExisting: %s%n", country);
        }
    }

    public static void testLoadMissing(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Country country = session.load(Country.class, "xx");
            System.out.printf("testLoadMissing: %s%n", country);
        } catch (Exception ex) {
            System.out.println("Failed: " + ex.getMessage());
        }
    }

    public static void testUpdateExisting(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            Country country = new Country("pl", "Polska");
            session.update(country);
            session.getTransaction().commit();
        }
    }

    public static void testUpdateMissing(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            Country country = new Country("xx", "Foo");
            session.update(country);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Failed: " + ex.getMessage());
        }
    }

    public static void cleanup(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createQuery("DELETE FROM Country").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
