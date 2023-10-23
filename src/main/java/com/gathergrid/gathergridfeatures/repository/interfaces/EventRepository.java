package com.gathergrid.gathergridfeatures.repository.interfaces;

import com.gathergrid.gathergridfeatures.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    public Event save(Event event);
    public void delete(long id);
    public Event update(Event event);
    public Optional<Event> find(long id);
    public List<Event> findAll();
}
