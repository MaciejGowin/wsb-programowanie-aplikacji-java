package pl.wsb.programowaniejava.maciejgowin.przyklad83;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.programowaniejava.maciejgowin.przyklad83.model.Customer;
import pl.wsb.programowaniejava.maciejgowin.przyklad83.model.CustomerForm;
import pl.wsb.programowaniejava.maciejgowin.przyklad83.service.CustomerService;

import java.util.Map;

@Controller
public class ApplicationController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/**")
    public ModelAndView customers(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return new ModelAndView(
                "customers",
                Map.of("customers", customerService.getCustomers(sortBy)));
    }

    @RequestMapping(value = "/customers/{id}")
    public ModelAndView customer(@PathVariable("id") Integer id) {
        Customer customer = customerService.getCustomer(id).orElseThrow(RuntimeException::new);
        return new ModelAndView(
                "customer",
                Map.of("customer", customer));
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public ModelAndView addCustomer(@ModelAttribute("customerForm") CustomerForm customerForm) {
        Customer customer = customerService.addCustomer(customerForm.getFirstName(), customerForm.getLastName());
        return new ModelAndView(
                "customer",
                Map.of("customer", customer));
    }

    @RequestMapping(value = "/newCustomer")
    public ModelAndView newCustomer(ModelMap model) {
        return new ModelAndView(
                "newCustomer",
                Map.of("customerForm", new CustomerForm()));
    }
}
