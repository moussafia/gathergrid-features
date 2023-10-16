package com.gathergrid.gathergridfeatures.domain;

import com.gathergrid.gathergridfeatures.domain.enums.TicketType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float price;
    private int quantityAvailable;
    @Enumerated(EnumType.STRING)
    private TicketType type;

    @ManyToOne
    private Event event;

    @OneToMany(mappedBy = "ticket")
    private List<Reservation> reservations = new ArrayList<>();

    public Ticket() {}

    public Ticket(float price, int quantityAvailable, TicketType type) {
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }
}
