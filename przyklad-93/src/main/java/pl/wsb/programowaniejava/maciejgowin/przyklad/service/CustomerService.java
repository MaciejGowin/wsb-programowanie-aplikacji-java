package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Customer;
import pl.wsb.programowaniejava.maciejgowin.przyklad.repository.CustomerCrudRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    public Customer addCustomer(String firstName, String lastName, LocalDate dateOfBirth, String countryCode) {
        Customer customer = Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .countryCode(countryCode)
                .build();
        return customerCrudRepository.save(customer);
    }

    public List<Customer> getCustomers(String sortBy) {
        if ("id".equals(sortBy)) {
            return customerCrudRepository.findAllOrderById();
        } else if ("firstName".equals(sortBy)) {
            return customerCrudRepository.findAllOrderByFirstName();
        } else if ("lastName".equals(sortBy)) {
            return customerCrudRepository.findAllOrderByLastName();
        } else {
            return customerCrudRepository.findAll();
        }
    }

    public Optional<Customer> getCustomer(int id) {
        return customerCrudRepository.findById(id);
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
        return customerCrudRepository
                .findById(id)
                .map(savedCustomer -> customerCrudRepository.save(customer));
    }

    public void deleteCustomer(int id) {
        customerCrudRepository.deleteById(id);
    }
}
