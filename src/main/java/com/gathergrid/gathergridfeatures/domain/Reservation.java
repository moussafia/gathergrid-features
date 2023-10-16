package com.gathergrid.gathergridfeatures.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime reservationDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket ticket;

    public Reservation() {}

    public long getId() {
        return id;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
