package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.wsb.programowaniejava.maciejgowin.przyklad.dto.AirportCodeNameDto;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class AirportService {

    private static final String GET_AIRPORT_PATH = "https://www.ryanair.com/api/views/locate/5/airports/en/%s";

    private final RestTemplate restTemplate;

    public String getAirportsName(String iataCode) {
        AirportCodeNameDto airport = restTemplate.getForObject(GET_AIRPORT_PATH.formatted(iataCode), AirportCodeNameDto.class);
        return ofNullable(airport).map(AirportCodeNameDto::getName).map(String::toLowerCase).orElse(null);
    }
}
