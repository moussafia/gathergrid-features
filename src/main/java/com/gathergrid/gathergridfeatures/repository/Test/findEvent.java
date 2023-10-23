package com.gathergrid.gathergridfeatures.repository.Test;

import com.gathergrid.gathergridfeatures.domain.Ticket;
import com.gathergrid.gathergridfeatures.service.TicketService;

import java.util.List;

public class findEvent {
   public static final TicketService ticketService =new TicketService();
    public static void main(String[] args) {
        List<Ticket> tickets = ticketService.findAllEventTickets(1);
        System.out.println("List =>");
        tickets.stream().filter(ticket -> "VIP".equals( ticket.getType().name())).map(ticket -> ticket.getEvent().getDate()).forEach(System.out::println);
    }

}
