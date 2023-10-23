package com.gathergrid.gathergridfeatures.service;

import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.EventRepositoryImpl;

import java.util.List;

public class EventService {

    public List<Event> fetchAllEventOfUser(Long user_id){
        EventRepository eventRepository = new EventRepositoryImpl();
        return eventRepository.fetchCreatedEventOfUser(user_id);
    }
}
