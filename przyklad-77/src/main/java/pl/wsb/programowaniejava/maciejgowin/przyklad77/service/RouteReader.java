package pl.wsb.programowaniejava.maciejgowin.przyklad77.service;

import pl.wsb.programowaniejava.maciejgowin.przyklad77.model.Route;

import java.util.List;

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
