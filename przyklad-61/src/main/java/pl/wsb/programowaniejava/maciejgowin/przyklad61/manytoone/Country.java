package pl.wsb.programowaniejava.maciejgowin.przyklad61.manytoone;

import pl.wsb.programowaniejava.maciejgowin.przyklad61.onetoone.City;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Country() {
    }

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return String.format("{%s, %s}", code, name);
    }
}
