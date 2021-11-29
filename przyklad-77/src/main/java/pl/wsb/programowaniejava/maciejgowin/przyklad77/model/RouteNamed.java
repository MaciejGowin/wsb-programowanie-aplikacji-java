package pl.wsb.programowaniejava.maciejgowin.przyklad77.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RouteNamed {
    private final String departureName;
    private final String arrivalName;
}
