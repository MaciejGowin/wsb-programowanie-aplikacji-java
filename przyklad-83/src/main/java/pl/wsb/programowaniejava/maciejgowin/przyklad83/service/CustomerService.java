package pl.wsb.programowaniejava.maciejgowin.przyklad83.service;

import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad83.model.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    // State should not be stored as a field of a bean. This imitates access to the database.
    private final List<Customer> customers = new ArrayList<>();

    public Customer addCustomer(String firstName, String lastName) {
        Customer customer = Customer.builder()
                .id(customers.size())
                .firstName(firstName)
                .lastName(lastName)
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
}
