package pl.wsb.programowaniejava.maciejgowin.przyklad73.simpletype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class City {

    private String name;
    private boolean capital;
    private Integer population;
    private Double area;
    private Country country;
}
