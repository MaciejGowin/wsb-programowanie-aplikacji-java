package pl.wsb.programowaniejava.maciejgowin.przyklad56;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CustomerManager {

    private final SessionFactory sessionFactory;

    public CustomerManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> getCustomers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("FROM Customer", Customer.class).list();
            session.getTransaction().commit();
            return customers;
        }
    }

    public Optional<Integer> addCustomer(String firstName, String lastName, LocalDate dateOfBirth) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(new Customer(firstName, lastName, Date.valueOf(dateOfBirth)));
            session.getTransaction().commit();
            return Optional.ofNullable(id);
        }
    }

    public void deleteCustomers() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createQuery("DELETE FROM Customer").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
