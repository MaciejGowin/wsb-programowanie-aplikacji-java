package pl.wsb.programowaniejava.maciejgowin.przyklad61.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
