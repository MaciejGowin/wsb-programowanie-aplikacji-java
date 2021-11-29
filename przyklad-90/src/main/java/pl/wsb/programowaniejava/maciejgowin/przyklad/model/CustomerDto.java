package pl.wsb.programowaniejava.maciejgowin.przyklad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.wsb.programowaniejava.maciejgowin.przyklad.validation.Adult;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerDto {

    private int id;

    @NotEmpty(message = "First name must be not empty")
    private String firstName;

    @NotBlank(message = "Last name must be not blank")
    private String lastName;

    @Adult(message = "Data of birth must be an adult")
    private LocalDate dateOfBirth;
}
