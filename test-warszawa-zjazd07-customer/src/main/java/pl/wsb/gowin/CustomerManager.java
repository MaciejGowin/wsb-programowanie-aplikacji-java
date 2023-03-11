package pl.wsb.gowin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.wsb.gowin.entity.Customer;
import pl.wsb.gowin.entity.LastNameOccurrence;

import java.util.List;

public class CustomerManager {

    private SessionFactory sessionFactory;

    public CustomerManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCustomer(String firstName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(customer);
            session.getTransaction().commit();
        }
    }

    public List<Customer> getCustomers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT new Customer(lastName) FROM Customer", Customer.class).list();
        }
    }

    public List<Customer> getLastCustomers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Customer ORDER BY id DESC", Customer.class).setMaxResults(3).list();
        }
    }

    public List getLastNameOccurrence() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT new pl.wsb.gowin.entity.LastNameOccurrence(c.lastName, count(c.lastName)) FROM Customer c GROUP BY c.lastName", LastNameOccurrence.class).list();
        }
    }

    public List<Customer> getCustomers(final String lastName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery( "FROM Customer WHERE lastName = :lname", Customer.class)
                    .setParameter("lname", lastName)
                    .list();
        }
    }
}
