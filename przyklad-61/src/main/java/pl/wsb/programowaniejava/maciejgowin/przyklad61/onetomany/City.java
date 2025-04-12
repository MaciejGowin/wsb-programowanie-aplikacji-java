package pl.wsb.programowaniejava.maciejgowin.przyklad61.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
