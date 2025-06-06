package pl.wsb.programowaniejava.maciejgowin.przyklad.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.programowaniejava.maciejgowin.przyklad.dto.AirportNameDto;
import pl.wsb.programowaniejava.maciejgowin.przyklad.service.AirportService;

@RestController
@RequestMapping("/airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("/{iataCode}/name")
    public AirportNameDto getFullNameFromIataCode(@PathVariable("iataCode") String iataCode) {
        return AirportNameDto.builder()
                .name(airportService.getAirportsName(iataCode))
                .build();
    }
}
