package pl.wsb.programowaniejava.maciejgowin.przyklad79.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wsb.programowaniejava.maciejgowin.przyklad79.model.RouteNamed;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RouteService {

    @Autowired
    private RouteReader routeReader;
    @Autowired
    private AirportReader airportReader;


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
