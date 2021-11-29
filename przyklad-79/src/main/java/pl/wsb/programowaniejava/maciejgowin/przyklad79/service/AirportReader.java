package pl.wsb.programowaniejava.maciejgowin.przyklad79.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AirportReader {

    public Map<String, String> getAirportNames() {
        return Map.of(
                "KRK", "Krakow",
                "DUB", "Dublin",
                "WRO", "Wroclaw",
                "BCN", "Barcelona",
                "MAD", "Madrid"
        );
    }
}
