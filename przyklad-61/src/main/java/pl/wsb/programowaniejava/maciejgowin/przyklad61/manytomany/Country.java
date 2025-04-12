package pl.wsb.programowaniejava.maciejgowin.przyklad61.manytomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

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
