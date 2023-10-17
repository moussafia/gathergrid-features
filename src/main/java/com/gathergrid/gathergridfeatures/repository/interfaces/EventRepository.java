package com.gathergrid.gathergridfeatures.repository.interfaces;

import com.gathergrid.gathergridfeatures.domain.Event;

import java.util.List;

public interface EventRepository {
    public Event createEvent(Event event);
    public void deleteEvent(long id);
    public void updateEvent(Event event);
    public Event find(long id);
    public List<Event> findAll();
}