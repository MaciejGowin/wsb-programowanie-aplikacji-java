package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    // State should not be stored as a field of a bean. This imitates access to the database.
    private final List<Customer> customers = new ArrayList<>();

    public Customer addCustomer(String firstName, String lastName, LocalDate dateOfBirth, String countryCode) {
        Customer customer = Customer.builder()
                .id(nextId())
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .countryCode(countryCode)
                .build();
        customers.add(customer);
        return customer;
    }

    public List<Customer> getCustomers(String sortBy) {
        if ("id".equals(sortBy)) {
            return customers.stream().sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
        } else if ("firstName".equals(sortBy)) {
            return customers.stream().sorted(Comparator.comparing(Customer::getFirstName)).collect(Collectors.toList());
        } else if ("lastName".equals(sortBy)) {
            return customers.stream().sorted(Comparator.comparing(Customer::getLastName)).collect(Collectors.toList());
        } else {
            return customers;
        }
    }

    public Optional<Customer> getCustomer(int id) {
        return customers.stream().filter(customer -> customer.getId() == id).findFirst();
    }

    public Optional<Customer> updateCustomer(int id, String firstName, String lastName, LocalDate dateOfBirth,
                                             String countryCode) {
        return getCustomer(id)
                .map(customer -> {
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);
                    customer.setDateOfBirth(dateOfBirth);
                    customer.setCountryCode(countryCode);
                    return customer;
                });
    }

    public void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
    }

    public int nextId() {
        // Find next id by getting highest existing and incrementing
        int maxId = customers.stream().mapToInt(Customer::getId).max().orElse(0);
        return maxId + 1;
    }
}
