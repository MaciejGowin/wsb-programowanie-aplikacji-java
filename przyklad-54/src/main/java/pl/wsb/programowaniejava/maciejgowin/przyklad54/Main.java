package pl.wsb.programowaniejava.maciejgowin.przyklad54;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Optional;

import static pl.wsb.programowaniejava.maciejgowin.przyklad54.Configuration.createSchema;
import static pl.wsb.programowaniejava.maciejgowin.przyklad54.Configuration.getConnection;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {

            createSchema(connection);

            CustomerManager customerManager = new CustomerManager(connection);

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
