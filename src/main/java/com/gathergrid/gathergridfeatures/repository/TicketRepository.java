package com.gathergrid.gathergridfeatures.repository;

import jakarta.persistence.EntityManager;

public class TicketRepository {
    private final EntityManager entityManager;

    public TicketRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }
}
