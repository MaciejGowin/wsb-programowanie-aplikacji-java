package pl.gowin.invoice;

import javax.persistence.CascadeType;
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
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private City capital;

    public Country() {
    }

    public Country(String code, String name, City capital) {
        this.code = code;
        this.name = name;
        this.capital = capital;
    }
}
