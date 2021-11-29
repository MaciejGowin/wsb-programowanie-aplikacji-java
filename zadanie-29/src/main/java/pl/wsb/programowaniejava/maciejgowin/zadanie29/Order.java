package pl.wsb.programowaniejava.maciejgowin.zadanie29;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
