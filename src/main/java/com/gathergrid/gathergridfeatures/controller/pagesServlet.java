package com.gathergrid.gathergridfeatures.controller;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.gathergrid.gathergridfeatures.domain.Reservation;
import com.gathergrid.gathergridfeatures.domain.Ticket;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.service.ReservationService;
import com.gathergrid.gathergridfeatures.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/myBooking", "/event", "/profile", "/Dashboard","/reservation"})
public class pagesServlet extends HttpServlet {

    TicketService ticketService = new TicketService();
    ReservationService reservationService = new ReservationService();
    public void init() {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        String path = request.getServletPath();
        switch (path) {
            case "/myBooking":
                request.setAttribute("url","/myBooking");
                this.getServletContext().getRequestDispatcher("/WEB-INF/booked.jsp").forward(request, response);
                break;
            case "/event":
                this.getServletContext().getRequestDispatcher("/WEB-INF/events.jsp").forward(request, response);
                request.setAttribute("url","/events");
                break;
            case "/profile":
                this.getServletContext().getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
                request.setAttribute("url","/profile");
                break;
            case "/Dashboard":
                request.setAttribute("url","/Dashboard");
                this.getServletContext().getRequestDispatcher("/WEB-INF/homeUser.jsp").forward(request, response);
                break;
            case "/reservation":
                ValidationReservation(request, response);
                break;
            default:
                response.sendError(response.SC_NOT_FOUND);
                break;
        }
    }

    public void destroy() {
    }
    public static void checkSessionNotEmpty(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            request.getServletContext().getRequestDispatcher("signin");
        }
    }
    public void ValidationReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vipParam = request.getParameter("vip");
        String standardParam = request.getParameter("Standard");
//        String id = request.getParameter("idEvent");

        int numVip = parseAndValidate(vipParam);
        int numStandard = parseAndValidate(standardParam);
//        int idEvent = parseAndValidate(id);

        List<Ticket> tickets = ticketService.findAllEventTickets(1);

        Ticket ticketVip ;
        Ticket ticketStandard ;
        if(tickets.get(0).getType().name().equals("VIP")){
            ticketVip = tickets.get(0);
            ticketStandard = tickets.get(1);
        }
        else {
            ticketVip = tickets.get(1);
            ticketStandard = tickets.get(0);
        }
        checkAvailablityOfTypeTicket(ticketVip, ticketStandard, numStandard, numVip, request, response);

        checkTicketTypeAndSave(numStandard, numVip, ticketVip, ticketStandard , request, response);


    }

    private void checkAvailablityOfTypeTicket(Ticket Vip, Ticket Standard,int numStandard,int numVip, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Vip.getType().name().isEmpty()&&numVip>0){
            request.setAttribute("message","This Event Has Not this Vip Type !!");
            this.getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
        }
        if(Standard.getType().name().isEmpty()&&numStandard>0){
            request.setAttribute("message","This Event Has Not this Standard Type !!");
            this.getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
        }
    }

    private void checkTicketTypeAndSave(int numStandard,int numVip,Ticket Vip, Ticket Standard , HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //check date
        if(!Vip.getEvent().getDate().isAfter(LocalDateTime.now())|| !Standard.getEvent().getDate().isAfter(LocalDateTime.now())){
            request.setAttribute("message","This Event is Expired !!");
            this.getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
        }else if(Standard.getQuantityAvailable()<numStandard ){
            request.setAttribute("message","Tickets is not Available !!");
            this.getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
        }
        else if(Vip.getQuantityAvailable()<numVip ){
            request.setAttribute("message","Tickets is not Available !!");
            this.getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
        }
        else {
            Reservation reservation = new Reservation(LocalDateTime.now(),user,Vip);
            Reservation reservation2 = new Reservation(LocalDateTime.now(),user,Standard);
            Vip.setQuantityAvailable(Vip.getQuantityAvailable()-numVip);
            Standard.setQuantityAvailable(Standard.getQuantityAvailable()-numStandard);
            reservationService.save(reservation);
            ticketService.updateTicket(Vip);
            reservationService.save(reservation2);
            ticketService.updateTicket(Standard);
            request.setAttribute("message", "Reservation has been Successfully !!");

        }

        this.getServletContext().getRequestDispatcher("/test.jsp").forward(request,response);
    }
    private int parseAndValidate(String param) {
        if (param == null || param.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(param);
    }
}