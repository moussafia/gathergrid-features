package com.gathergrid.gathergridfeatures.controller;

import java.io.*;
import java.util.List;

import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.service.CategoryService;
import com.gathergrid.gathergridfeatures.service.EventService;
import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;
import com.gathergrid.gathergridfeatures.service.CategoryService;
import com.gathergrid.gathergridfeatures.service.EventService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = {"/myBooking", "/event", "/profile", "/Dashboard"})
public class pagesServlet extends HttpServlet {

    public void init() {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServletException {
        String path = request.getServletPath();
        EventService eventService = new EventService();
        CategoryService categoryService = new CategoryService();
//        HttpSession session = request.getSession(false);
        switch (path) {
            case "/myBooking":
                request.setAttribute("url","/myBooking");
                this.getServletContext().getRequestDispatcher("/WEB-INF/booked.jsp").forward(request, response);
                break;
            case "/event":
                request.setAttribute("url","/events");
                List<Category> categories = categoryService.getAllCategories();
                List<Event> events = getFiltredEvents(request, response);
//                List<Event> events = eventService.getAll();
                request.setAttribute("events", events);
                request.setAttribute("categories", categories);
                this.getServletContext().getRequestDispatcher("/WEB-INF/events.jsp").forward(request, response);
                break;
            case "/profile":
                this.getServletContext().getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
                request.setAttribute("url","/profile");
                break;
            case "/Dashboard":
                request.setAttribute("url","/Dashboard");
//                User user = (User) session.getAttribute("user");
                List<Event> listEvent = eventService.fetchAllEventOfUser(1L);
                request.setAttribute("listEvent",listEvent);
                List<Category> listCategory = categoryService.getAllCategories();
                request.setAttribute("listCategory",listCategory);
                this.getServletContext().getRequestDispatcher("/WEB-INF/homeUser.jsp").forward(request, response);
                break;
            default:
                response.sendError(response.SC_NOT_FOUND);
                break;
        }
    }

    private List<Event> getFiltredEvents(HttpServletRequest request, HttpServletResponse response) {
        EventService eventService = new EventService();
        String search = request.getParameter("search");
        if (search == null) {
            return eventService.filterEvents("", "", "", "");
        }
        String fromDate = (String) request.getParameter("fromdate");
        String toDate = (String) request.getParameter("todate");
        String text = (String) request.getParameter("text");
        String categoryId = (String) request.getParameter("category");

        return eventService.filterEvents(fromDate, toDate, text, categoryId);
    }

    public static void checkSessionNotEmpty(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session==null){
            request.getServletContext().getRequestDispatcher("signin");
        }
    }
}