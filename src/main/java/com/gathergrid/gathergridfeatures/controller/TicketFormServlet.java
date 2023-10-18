package com.gathergrid.gathergridfeatures.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ticket-form")
public class TicketFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspFile = "ticket-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspFile);
        dispatcher.forward(request, response);

    }
}
