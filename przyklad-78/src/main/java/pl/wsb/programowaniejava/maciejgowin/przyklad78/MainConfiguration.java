package pl.wsb.programowaniejava.maciejgowin.przyklad78;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wsb.programowaniejava.maciejgowin.przyklad78.service.AirportReader;
import pl.wsb.programowaniejava.maciejgowin.przyklad78.service.RouteReader;
import pl.wsb.programowaniejava.maciejgowin.przyklad78.service.RouteService;

@Configuration
public class MainConfiguration {

    @Bean
    public RouteReader routeReader() {
        return new RouteReader();
    }

    @Bean
    public AirportReader airportReader() {
        return new AirportReader();
    }

    @Bean
    public RouteService routeService() {
        return new RouteService();
    }
}
