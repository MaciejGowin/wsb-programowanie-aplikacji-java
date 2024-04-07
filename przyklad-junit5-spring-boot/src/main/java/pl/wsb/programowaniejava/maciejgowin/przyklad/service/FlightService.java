package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad.exception.FlightNotFoundException;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Flight;
import pl.wsb.programowaniejava.maciejgowin.przyklad.repository.FlightRepository;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findById(long flightId) {
        return flightRepository.findById(flightId)
                .orElseThrow(FlightNotFoundException::new);
    }

    public Flight scheduleNewFlight(String airlineCode, int flightNumber, Integer noOfAdults, Integer noOfChildren) {
        Flight flight = Flight.builder()
                .flightNo(airlineCode + " " + flightNumber)
                .noOfPassengers(ofNullable(noOfAdults).orElse(0) + ofNullable(noOfChildren).orElse(0))
                .build();
        return flightRepository.save(flight);
    }
}
