package pl.wsb.programowaniejava.maciejgowin.gatling.locate;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

import static pl.wsb.programowaniejava.maciejgowin.gatling.locate.Sleeper.randomSleep;

@RestController
public class ApplicationController {

    private static final List<String> AIRPORT_CODES = List.of("WRO", "STN", "DUB");

    @GetMapping("/5/airports/{lang}/active")
    public List<Airport> airports(final @PathVariable("lang") String lang) {
        randomSleep();
        return AIRPORT_CODES.stream()
                .map(this::airport)
                .toList();
    }

    @GetMapping("/5/airports/{lang}/{code}")
    public Airport airport(final @PathVariable("lang") String lang,
                           final @PathVariable("code") String code) {
        randomSleep();
        return airport(code);
    }

    @GetMapping("/3/routes/{code}")
    public List<Route> routes(final @PathVariable("code") String code) {
        randomSleep();
        return AIRPORT_CODES.stream()
                .filter(currentCode -> !currentCode.equals(code))
                .flatMap(currentCode ->
                        Stream.of(
                                route(currentCode, code),
                                route(code, currentCode)))
                .toList();
    }

    @GetMapping("/3/routes")
    public List<Route> routes() {
        randomSleep();
        return AIRPORT_CODES.stream()
                .flatMap(departure -> AIRPORT_CODES.stream()
                        .filter(arrival -> !departure.equals(arrival))
                        .map(arrival -> route(departure, arrival)))
                .toList();
    }

    private Airport airport(String code) {
        return Airport.builder().code(code).build();
    }

    private Route route(String a, String b) {
        return Route.builder().departure(airport(a)).arrival(airport(b)).build();
    }

    @Getter
    @Builder
    public static class Route {
        private final Airport departure;
        private final Airport arrival;
    }

    @Getter
    @Builder
    public static class Airport {
        private final String code;
    }
}
