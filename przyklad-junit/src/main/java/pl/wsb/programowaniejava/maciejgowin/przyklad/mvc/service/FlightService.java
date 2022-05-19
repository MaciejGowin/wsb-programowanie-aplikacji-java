package pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.exception.FlightNotFoundException;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.model.Flight;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.repository.FlightRepository;

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
        Flight flight = new Flight();
        flight.setFlightNo(airlineCode + " " + flightNumber);
        flight.setNoOfPassengers(
                ofNullable(noOfAdults).orElse(0) + ofNullable(noOfChildren).orElse(0)
        );

        return flightRepository.save(flight);
    }
}
