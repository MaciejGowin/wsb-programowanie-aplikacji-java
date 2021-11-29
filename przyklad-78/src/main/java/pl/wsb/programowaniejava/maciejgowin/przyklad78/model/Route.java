package pl.wsb.programowaniejava.maciejgowin.przyklad78.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Route {
    private final String departureCode;
    private final String arrivalCode;
}
