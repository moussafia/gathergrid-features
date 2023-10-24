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

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
 private  long numbreTickect;
    public Reservation() {}

    public Reservation(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public long getId() {
        return id;
    }

    public Reservation(LocalDateTime reservationDate, User user, Ticket ticket) {
        this.reservationDate = reservationDate;
        this.user = user;
        this.ticket = ticket;
    }
}
