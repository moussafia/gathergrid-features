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
public class CreateTicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer price = Integer.valueOf(req.getParameter("ticketPrice"));
        Integer quantity = Integer.valueOf(req.getParameter("ticketQuantity"));
        String type = req.getParameter("ticketType");
        Integer eventId = 1;

        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        TicketRepository ticketRepository = new TicketRepository(entityManager);
        TicketService ticketService = new TicketService(ticketRepository);

        Ticket ticket = new Ticket(price, quantity, TicketType.VIP);




    }
}
