package pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.model.Flight;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<Flight> findAll() {
        return flightService.findAllFlights();
    }

    @GetMapping("{flightId}")
    public Flight findFlightById(@PathVariable("flightId") long flightId) {
        return flightService.findById(flightId);
    }

    @PostMapping("{airlineCode}/{flightNumber}")
    public Flight scheduleNewFlight(@PathVariable("airlineCode") String airlineCode,
                                    @PathVariable("flightNumber") int flightNumber,
                                    @RequestParam(required = false, name = "noOfAdults") Integer noOfAdults,
                                    @RequestParam(required = false, name = "noOfChildren") Integer noOfChildren) {
        return flightService.scheduleNewFlight(airlineCode, flightNumber, noOfAdults, noOfChildren);
    }
}
