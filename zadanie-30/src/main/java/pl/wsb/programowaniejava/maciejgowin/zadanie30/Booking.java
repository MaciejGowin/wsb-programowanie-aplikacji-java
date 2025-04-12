package pl.wsb.programowaniejava.maciejgowin.zadanie30;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Flight flight;

    @Column(name = "price")
    private BigDecimal price;

    public Booking() {
    }

    public Booking(Customer customer, Flight flight, BigDecimal price) {
        this.customer = customer;
        this.flight = flight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", flight=" + flight +
                ", price=" + price +
                '}';
    }
}
