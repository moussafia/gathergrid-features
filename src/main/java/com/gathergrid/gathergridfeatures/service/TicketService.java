package com.gathergrid.gathergridfeatures.service;


import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.domain.Ticket;
import com.gathergrid.gathergridfeatures.repository.TicketRepository;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.EventRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketService {
    private final TicketRepository ticketRepository;


    public TicketService(){
        ticketRepository = new TicketRepository();
    }

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public void updateTicket(Ticket ticket){
        ticketRepository.update(ticket);
    }
    public void deleteTicket(long id){
        ticketRepository.delete(id);
    }

    public Ticket findTicket(long id){
        return ticketRepository.find(id);
    }

    public List<Ticket> findAllTickets(){
        return ticketRepository.findAll();
    }
    EventRepositoryImpl eventRepository = new EventRepositoryImpl();
    public List<Ticket> findAllEventTickets(long id){
        Event event = eventRepository.find(id);
        if(event!=null)
            return  ticketRepository.finAllEventTickets(event.getId());
        return new ArrayList<>();
    }

}
