package pl.wsb.programowaniejava.maciejgowin.przyklad59;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerManager {

    private final SessionFactory sessionFactory;

    public CustomerManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> getCustomers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            List<Customer> customers = query.list();
            session.getTransaction().commit();
            return customers;
        }
    }

    public List<Customer> getCustomersByIterator() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            List<Customer> customers = new ArrayList<>();
            Iterator<Customer> iterator = query.iterate();
            while (iterator.hasNext()) {
                customers.add(iterator.next());
            }
            session.getTransaction().commit();
            return customers;
        }
    }

    public List<Customer> getCustomersByStream() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            List<Customer> customers = query.stream().collect(Collectors.toList());
            session.getTransaction().commit();
            return customers;
        }
    }

    public List<Customer> getCustomersByFirstName(String firstName) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Customer> query = session
                    .createQuery("FROM Customer WHERE firstName = ?0", Customer.class)
                    .setParameter(0, firstName);
            List<Customer> customers = query.list();
            session.getTransaction().commit();
            return customers;
        }
    }

    public List<Customer> getCustomersByFirstNameNamed(String firstName) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Customer> query = session
                    .createQuery("FROM Customer WHERE firstName = :fn", Customer.class)
                    .setParameter("fn", firstName);
            List<Customer> customers = query.list();
            session.getTransaction().commit();
            return customers;
        }
    }

    public Optional<Integer> addCustomer(String firstName, String lastName) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(new Customer(firstName, lastName));
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
