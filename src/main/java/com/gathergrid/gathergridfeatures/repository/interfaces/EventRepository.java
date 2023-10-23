package com.gathergrid.gathergridfeatures.repository.interfaces;

import com.gathergrid.gathergridfeatures.domain.Event;

import java.util.List;

public interface EventRepository {
    public List<Event> fetchCreatedEventOfUser(Long user_id);
}
