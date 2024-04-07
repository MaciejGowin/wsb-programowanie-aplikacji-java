package pl.wsb.programowaniejava.maciejgowin.przyklad.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FlightDto {

    private Long id;
    private String flightNo;
    private Integer noOfPassengers;
}
