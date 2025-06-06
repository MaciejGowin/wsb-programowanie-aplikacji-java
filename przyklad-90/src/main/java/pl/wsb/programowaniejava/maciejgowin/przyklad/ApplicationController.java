package pl.wsb.programowaniejava.maciejgowin.przyklad;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.programowaniejava.maciejgowin.przyklad.exception.ResourceNotFoundException;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Customer;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.CustomerDto;
import pl.wsb.programowaniejava.maciejgowin.przyklad.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ApplicationController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return customerService.getCustomers(sortBy).stream().map(this::asDto).collect(Collectors.toList());
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomer(@PathVariable("id") Integer id) {
        return customerService.getCustomer(id).map(this::asDto).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping("/customers")
    public CustomerDto addCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return asDto(customerService.addCustomer(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getDateOfBirth()));
    }

    @PutMapping("/customers/{id}")
    public CustomerDto updateCustomer(@PathVariable("id") Integer id,
                                      @Valid @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(id, customerDto.getFirstName(), customerDto.getLastName(), customerDto.getDateOfBirth())
                .map(this::asDto)
                .orElseThrow(ResourceNotFoundException::new);
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
                .dateOfBirth(customer.getDateOfBirth())
                .build();
    }
}
