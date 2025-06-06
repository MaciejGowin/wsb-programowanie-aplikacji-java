package pl.wsb.programowaniejava.maciejgowin.przyklad.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wsb.programowaniejava.maciejgowin.przyklad.dto.FlightDto;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Flight;
import pl.wsb.programowaniejava.maciejgowin.przyklad.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<FlightDto> findAll() {
        return flightService.findAllFlights().stream()
                .map(this::asDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{flightId}")
    public FlightDto findFlightById(@PathVariable("flightId") long flightId) {
        return asDto(flightService.findById(flightId));
    }

    @PostMapping("/{airlineCode}/{flightNumber}")
    public FlightDto scheduleNewFlight(@PathVariable("airlineCode") String airlineCode,
                                       @PathVariable("flightNumber") int flightNumber,
                                    @RequestParam(required = false, name = "noOfAdults") Integer noOfAdults,
                                    @RequestParam(required = false, name = "noOfChildren") Integer noOfChildren) {
        return asDto(flightService.scheduleNewFlight(airlineCode, flightNumber, noOfAdults, noOfChildren));
    }

    private FlightDto asDto(Flight flight) {
        return FlightDto.builder()
                .id(flight.getId())
                .flightNo(flight.getFlightNo())
                .noOfPassengers(flight.getNoOfPassengers())
                .build();
    }
}
