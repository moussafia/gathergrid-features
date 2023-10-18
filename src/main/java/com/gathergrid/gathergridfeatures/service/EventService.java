package com.gathergrid.gathergridfeatures.service;

import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.domain.Ticket;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;

import java.util.List;

public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event, User organizer, List<Ticket> tickets) {
        event.setOrganizer(organizer);
        event.setTickets(tickets);
        event = eventRepository.save(event);
        return event;
    }

    public Event updateEvent(Event event) {
        return eventRepository.update(event);
    }
}
