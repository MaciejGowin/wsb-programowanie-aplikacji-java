package pl.wsb.programowaniejava.maciejgowin.przyklad75.service;

import java.util.Map;

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
