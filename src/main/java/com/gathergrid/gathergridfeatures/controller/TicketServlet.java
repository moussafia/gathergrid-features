package com.gathergrid.gathergridfeatures.controller;

import com.gathergrid.gathergridfeatures.domain.Ticket;
import com.gathergrid.gathergridfeatures.domain.enums.TicketType;
import com.gathergrid.gathergridfeatures.repository.TicketRepository;
import com.gathergrid.gathergridfeatures.service.TicketService;
import com.gathergrid.gathergridfeatures.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/create-ticket")
public class TicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int price = Integer.parseInt(req.getParameter("ticketPrice"));
        int quantity = Integer.parseInt(req.getParameter("ticketQuantity"));
        String type = req.getParameter("ticketType");

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService = new TicketService();


        Ticket ticket = new Ticket(price, quantity, TicketType.VIP);
        ticketService.createTicket(ticket);

//        ticketService.deleteTicket(1);

//        List<Ticket> ticketList = ticketService.findAllTickets();
//        resp.setContentType("text/html");
//        resp.getWriter().println("<h1>List all tickets :</h1>");
//        resp.getWriter().println("<ul>");
//        for(Ticket t : ticketList){
//            resp.getWriter().println("<li>Price: " + t.getPrice()+ ", Quantity: " + t.getQuantityAvailable() + ", Type: " + t.getType() + "</li>");
//        }
//        resp.getWriter().println("</ul>");



    }
}
