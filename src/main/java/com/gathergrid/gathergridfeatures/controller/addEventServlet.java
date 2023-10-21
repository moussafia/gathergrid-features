package com.gathergrid.gathergridfeatures.controller;

import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.domain.Ticket;
import com.gathergrid.gathergridfeatures.domain.enums.TicketType;
import com.gathergrid.gathergridfeatures.service.EventService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addevent")
public class addEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/addevent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String date = req.getParameter("date");
        String description = req.getParameter("description");
        String category = req.getParameter("category");

        int categoryId = Integer.parseInt(category);

        Writer out = resp.getWriter();
        out.write("name: " + name + "\n" +
                "address: " + address + "\n" +
                "date: " + date + "\n" +
                "description: " + description + "\n" +
                "");

        List<Ticket> tickets = getTicketsFromRequest(req);

        for (Ticket ticket: tickets) {
            out.write(ticket.getType().name() + " " + ticket.getPrice() + " " + ticket.getQuantityAvailable() + "\n");
        }

        if (tickets.isEmpty())
            return;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        out.write("date: " + localDateTime);
        Event event = new Event(name, localDateTime, address, description);
        EventService eventService = new EventService();
        eventService.createEvent(event, 1, tickets, categoryId);
    }

    private List<Ticket> getTicketsFromRequest(HttpServletRequest request) {
        List<Ticket> tickets = new ArrayList<>();
        for (TicketType ticketType: TicketType.values()) {
            String type = ticketType.name().toLowerCase();
            if (request.getParameter(type) == null)
                continue;

            String numberParam = type + "ticketsnumber";
            String priceParam = type + "ticketsprice";
            int number, price;
            try {
                number = Integer.parseInt(request.getParameter(numberParam));
                price = Integer.parseInt(request.getParameter(priceParam));
            } catch (NumberFormatException e) {
                continue;
            }

            Ticket ticket = new Ticket(price, number, ticketType);
            tickets.add(ticket);
        }
        return tickets;
    }
}
