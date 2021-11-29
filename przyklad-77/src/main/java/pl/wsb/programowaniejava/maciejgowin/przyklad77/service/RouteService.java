package pl.wsb.programowaniejava.maciejgowin.przyklad77.service;

import pl.wsb.programowaniejava.maciejgowin.przyklad77.model.RouteNamed;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RouteService {

    private final RouteReader routeReader;
    private final AirportReader airportReader;

    public RouteService(RouteReader routeReader, AirportReader airportReader) {
        this.routeReader = routeReader;
        this.airportReader = airportReader;
    }

    public Set<RouteNamed> getRoutes() {
        Map<String, String> airportNames = airportReader.getAirportNames();
        return routeReader.getRoutes().stream()
                .map(route -> RouteNamed.builder()
                        .departureName(airportNames.getOrDefault(route.getDepartureCode(), route.getDepartureCode()))
                        .arrivalName(airportNames.getOrDefault(route.getArrivalCode(), route.getArrivalCode()))
                        .build()
                )
                .collect(Collectors.toSet());
    }
}
