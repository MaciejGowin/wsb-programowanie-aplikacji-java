package pl.wsb.programowaniejava.maciejgowin.przyklad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
}
