package pl.wsb.programowaniejava.maciejgowin.przyklad79.service;

import org.springframework.stereotype.Component;
import pl.wsb.programowaniejava.maciejgowin.przyklad79.model.Route;

import java.util.List;

@Component
public class RouteReader {

    public List<Route> getRoutes() {
        return List.of(
                Route.builder().departureCode("KRK").arrivalCode("DUB").build(),
                Route.builder().departureCode("WRO").arrivalCode("DUB").build(),
                Route.builder().departureCode("DUB").arrivalCode("BCN").build(),
                Route.builder().departureCode("DUB").arrivalCode("MAD").build()
        );
    }
}
