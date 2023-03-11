package pl.wsb.gowin;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.wsb.gowin.entity.Customer;

public class Application {

    public static void main(String[] args) {
        System.out.println("===================");
        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory()) {

            CustomerManager customerManager = new CustomerManager(sessionFactory);
            customerManager.addCustomer("Maciej", "Gowin");
            customerManager.addCustomer("Jan", "Kowalski");
            customerManager.addCustomer("Karolina", "Gowin");
            customerManager.addCustomer("Anna", "Sodkiewicz");
            customerManager.addCustomer("Beata", "Nowak");

            System.out.println(customerManager.getLastNameOccurrence());
        }
    }
}
