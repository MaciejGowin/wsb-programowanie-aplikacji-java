package pl.wsb.programowaniejava.maciejgowin.przyklad59;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory()) {

            CustomerManager customerManager = new CustomerManager(sessionFactory);
            customerManager.deleteCustomers();
            customerManager.addCustomer("Maciej", "Gowin");
            customerManager.addCustomer("Maciej", "Nowak");
            customerManager.addCustomer("Jan", "Kowalski");

            System.out.printf("Check (1): %s%n", customerManager.getCustomers());
            System.out.printf("Check (2): %s%n", customerManager.getCustomersByIterator());
            System.out.printf("Check (3): %s%n", customerManager.getCustomersByStream());

            System.out.printf("Check (4): %s%n", customerManager.getCustomersByFirstName("Maciej"));
            System.out.printf("Check (5): %s%n", customerManager.getCustomersByFirstNameNamed("Maciej"));

        } catch(Exception e) {
            System.out.printf("Failed: %s%n", e.getMessage());
        }
    }
}
