package pl.wsb.programowaniejava.maciejgowin.przyklad61.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<City> cities;

    public Country() {
    }

    public Country(String code, String name, List<City> cities) {
        this.code = code;
        this.name = name;
        this.cities = cities;
    }

    public String toString() {
        return String.format("{%s, %s, %s}", code, name, cities);
    }
}
