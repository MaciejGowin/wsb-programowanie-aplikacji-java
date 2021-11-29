package pl.wsb.programowaniejava.maciejgowin.przyklad.repository;

import org.springframework.stereotype.Repository;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getCustomers() {
        return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }

    public Optional<Customer> getCustomer(int id) {
        return ofNullable(entityManager.find(Customer.class, id));
    }

    @Transactional
    public Customer addCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    public Optional<Customer> updateCustomer(Customer customer) {
        return getCustomer(customer.getId())
                .map(storedCustomer -> {
                    storedCustomer.setFirstName(customer.getFirstName());
                    storedCustomer.setLastName(customer.getLastName());
                    storedCustomer.setDateOfBirth(customer.getDateOfBirth());
                    storedCustomer.setCountryCode(customer.getCountryCode());
                    return storedCustomer;
                });
    }

    @Transactional
    public void deleteCustomer(int id) {
        entityManager.createQuery("DELETE FROM Customer WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
