package pl.wsb.programowaniejava.maciejgowin.przyklad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Customer;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.CustomerDto;
import pl.wsb.programowaniejava.maciejgowin.przyklad.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApplicationController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return customerService.getCustomers(sortBy).stream().map(this::asDto).collect(Collectors.toList());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Integer id) {
        return customerService.getCustomer(id)
                .map(this::asDto)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return asDto(customerService.addCustomer(customerDto.getFirstName(), customerDto.getLastName()));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Integer id,
                                                      @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(id, customerDto.getFirstName(), customerDto.getLastName())
                .map(this::asDto)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
    }

    public CustomerDto asDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
