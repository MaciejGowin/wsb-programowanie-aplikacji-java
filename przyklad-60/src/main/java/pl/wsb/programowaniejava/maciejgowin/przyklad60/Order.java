package pl.wsb.programowaniejava.maciejgowin.przyklad60;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product")
    private String product;

    @Column(name = "value")
    private double value;

    public Order() {
    }

    public Order(String product, double value) {
        this.product = product;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("{%s, %s, %f}", id, product, value);
    }
}
