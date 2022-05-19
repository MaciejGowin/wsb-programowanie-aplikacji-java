package pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.model.Flight;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByFlightNo(String flightNo);

    @Query("SELECT f FROM Flight f WHERE f.noOfPassengers BETWEEN :min AND :max")
    List<Flight> findFlightsWithNoOfPassengersBetween(@Param("min") int min,
                                                      @Param("max") int max);

    @Query(nativeQuery = true, value = "SELECT * FROM flights WHERE id = :id")
    Flight customFindById(@Param("id")Long id);
}
