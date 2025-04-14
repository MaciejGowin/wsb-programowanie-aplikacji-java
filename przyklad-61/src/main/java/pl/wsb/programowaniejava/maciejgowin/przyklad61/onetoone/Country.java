package pl.wsb.programowaniejava.maciejgowin.przyklad61.onetoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @OneToOne
    // @OneToOne(optional = false)
    private City capital;

    public Country() {
    }

    public Country(String code, String name, City capital) {
        this.code = code;
        this.name = name;
        this.capital = capital;
    }

    public String toString() {
        return String.format("{%s, %s, %s}", code, name, capital);
    }
}
