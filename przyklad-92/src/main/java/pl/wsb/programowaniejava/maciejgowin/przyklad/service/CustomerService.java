package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Customer;
import pl.wsb.programowaniejava.maciejgowin.przyklad.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer addCustomer(String firstName, String lastName, LocalDate dateOfBirth, String countryCode) {
        Customer customer = Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .countryCode(countryCode)
                .build();
        return customerRepository.addCustomer(customer);
    }

    public List<Customer> getCustomers(String sortBy) {
        if ("id".equals(sortBy)) {
            return customerRepository.getCustomers().stream().sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
        } else if ("firstName".equals(sortBy)) {
            return customerRepository.getCustomers().stream().sorted(Comparator.comparing(Customer::getFirstName)).collect(Collectors.toList());
        } else if ("lastName".equals(sortBy)) {
            return customerRepository.getCustomers().stream().sorted(Comparator.comparing(Customer::getLastName)).collect(Collectors.toList());
        } else {
            return customerRepository.getCustomers();
        }
    }

    public Optional<Customer> getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

    public Optional<Customer> updateCustomer(int id, String firstName, String lastName, LocalDate dateOfBirth,
                                             String countryCode) {
        Customer customer = Customer.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .countryCode(countryCode)
                .build();
        return customerRepository.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }
}
