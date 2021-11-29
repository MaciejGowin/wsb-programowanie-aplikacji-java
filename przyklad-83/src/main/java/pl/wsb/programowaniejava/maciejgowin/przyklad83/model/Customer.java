package pl.wsb.programowaniejava.maciejgowin.przyklad83.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {

    private final int id;
    private final String firstName;
    private final String lastName;
}
