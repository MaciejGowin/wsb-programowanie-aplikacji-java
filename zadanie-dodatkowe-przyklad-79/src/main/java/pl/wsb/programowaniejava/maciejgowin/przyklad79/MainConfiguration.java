package pl.wsb.programowaniejava.maciejgowin.przyklad79;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.wsb.programowaniejava.maciejgowin.przyklad79.model.Airport;
import pl.wsb.programowaniejava.maciejgowin.przyklad79.model.Route;

@Slf4j
@Configuration
@ComponentScan("pl.wsb.programowaniejava.maciejgowin")
public class MainConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        try {
            return new org.hibernate.cfg.Configuration()
                    .addAnnotatedClass(Airport.class)
                    .addAnnotatedClass(Route.class)
                    .buildSessionFactory();
        } catch(Exception e) {
            log.error("Failed: {}", e.getMessage(), e);
            throw e;
        }
    }
}
