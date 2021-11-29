package pl.wsb.programowaniejava.maciejgowin.przyklad57;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory()) {

            CustomerManager customerManager = new CustomerManager(factory);

            // Delete customers
            customerManager.deleteCustomers();

            // List customers
            System.out.printf("Check (1): %s%n", customerManager.getCustomers());

            // Add customer
            Optional<Integer> newId = customerManager.addCustomer("Maciej", "Gowin", LocalDate.parse("1986-11-21"));

            System.out.printf("Check (2): %s%n", newId);

            // List customers
            System.out.printf("Check (3): %s%n", customerManager.getCustomers());
        } catch(Exception e) {
            System.out.printf("Failed: %s%n", e.getMessage());
        }
    }
}
