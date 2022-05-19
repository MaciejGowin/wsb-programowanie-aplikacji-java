package pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.dto.AirportName;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.service.AirportService;

@RestController
@RequestMapping("airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("{iataCode}/name")
    public AirportName getFullNameFromIataCode(@PathVariable("iataCode")String iataCode) {
        return airportService.getAirportsName(iataCode);
    }
}
