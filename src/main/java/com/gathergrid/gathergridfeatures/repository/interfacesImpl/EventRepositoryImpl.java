package com.gathergrid.gathergridfeatures.repository.interfacesImpl;

import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;
import com.gathergrid.gathergridfeatures.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class EventRepositoryImpl implements EventRepository {
    private final EntityManager em;

    public EventRepositoryImpl() {
       em = EntityManagerUtil.getEntityManager();
    }

    @Override
    public Event save(Event event) {
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        return event;
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Event event = em.find(Event.class, id);
        if (event != null) {
            em.remove(event);
        }
        em.getTransaction().commit();
    }

    @Override
    public Event update(Event event) {
        em.getTransaction().begin();
        em.merge(event);
        em.getTransaction().commit();
        return event;
    }

    @Override
    public Optional<Event> find(long id) {
        String jpql = "SELECT e FROM Event e where e.id = :id";
        TypedQuery<Event> query = em.createQuery(jpql, Event.class).setParameter("id", id);
        return query
                .getResultStream()
                .findAny();
    }

    @Override
    public List<Event> findAll() {
        String jpql = "SELECT e FROM Event e";
        TypedQuery<Event> query = em.createQuery(jpql, Event.class);
        return query.getResultList();
    }

}