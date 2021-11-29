package pl.wsb.programowaniejava.maciejgowin.przyklad.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
