package pl.wsb.programowaniejava.maciejgowin.przyklad77;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.wsb.programowaniejava.maciejgowin.przyklad77.service.AirportReader;
import pl.wsb.programowaniejava.maciejgowin.przyklad77.service.RouteReader;
import pl.wsb.programowaniejava.maciejgowin.przyklad77.service.RouteService;

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
        RouteReader r1 = routeReader();
        RouteReader r2 = routeReader();
        System.out.println(r1);
        System.out.println(r2);
        return new RouteService(routeReader(), airportReader());
    }
}
