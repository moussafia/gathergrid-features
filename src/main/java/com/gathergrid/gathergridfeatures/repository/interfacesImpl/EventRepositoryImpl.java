package com.gathergrid.gathergridfeatures.repository.interfacesImpl;

import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventRepositoryImpl implements EventRepository {
    private final EntityManager em;

    public EventRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Event createEvent(Event event) {
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        return event;
    }

    @Override
    public void deleteEvent(long id) {
        em.getTransaction().begin();
        Event event = em.find(Event.class, id);
        if (event != null) {
            em.remove(event);
        }
        em.getTransaction().commit();
    }

    @Override
    public void updateEvent(Event event) {
        em.getTransaction().begin();
        em.merge(event);
        em.getTransaction().commit();
    }

    @Override
    public Event find(long id) {
        return em.find(Event.class, id);
    }

    @Override
    public List<Event> findAll() {
        String jpql = "SELECT e FROM Event e";
        TypedQuery<Event> query = em.createQuery(jpql, Event.class);
        return query.getResultList();
    }
}
