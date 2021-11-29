package pl.wsb.programowaniejava.maciejgowin.przyklad61.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("{%s, %s}", id, name);
    }
}
