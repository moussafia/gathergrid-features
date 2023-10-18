package com.gathergrid.gathergridfeatures.service;

import com.gathergrid.gathergridfeatures.repository.TicketRepository;

public class TicketService {
    private final TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
}
