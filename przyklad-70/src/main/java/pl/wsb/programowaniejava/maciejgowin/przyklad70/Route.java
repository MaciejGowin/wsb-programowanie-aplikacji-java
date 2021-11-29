package pl.wsb.programowaniejava.maciejgowin.przyklad70;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Route {

    private final String departure;
    private final String arrival;
}
