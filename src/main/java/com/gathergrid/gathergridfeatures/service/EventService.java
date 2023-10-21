package com.gathergrid.gathergridfeatures.service;

import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.domain.Ticket;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.EventRepositoryImpl;
import com.gathergrid.gathergridfeatures.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventService() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        eventRepository = new EventRepositoryImpl(em);
    }

    public Event createEvent(Event event, long organizerId, List<Ticket> tickets, long categoryId) {
        for (Ticket ticket: tickets)
            event.addTicket(ticket);

        CategoryService categoryService = new CategoryService();
        UserService userService = new UserService();

        Category category = categoryService.getById(categoryId);
        User user = userService.getById(organizerId);
        event.setOrganizer(user);
        event.setCategory(category);
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        return eventRepository.update(event);
    }
}
