package com.gathergrid.gathergridfeatures.repository.interfacesImpl;

import com.gathergrid.gathergridfeatures.domain.Event;
import com.gathergrid.gathergridfeatures.repository.interfaces.EventRepository;
import com.gathergrid.gathergridfeatures.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class EventRepositoryImpl implements EventRepository {

    private final EntityManager em = EntityManagerUtil.getEntityManager();
    @Override
    public List<Event> fetchCreatedEventOfUser(Long user_id) {
         Query query = em.createQuery("select e from Event e where e.organizer.id = :user_id",Event.class);
         query.setParameter("user_id", user_id);
         return query.getResultList();
    }
}
