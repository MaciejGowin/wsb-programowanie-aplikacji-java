package pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.dto.AirportCodeName;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.dto.AirportName;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final RestTemplate restTemplate;

    public AirportName getAirportsName(String iataCode) {
        AirportCodeName result = restTemplate.getForObject("https://www.ryanair.com/api/locate/v5/airports/" + iataCode, AirportCodeName.class);

        return new AirportName(result.getName().toLowerCase());
    }
}
