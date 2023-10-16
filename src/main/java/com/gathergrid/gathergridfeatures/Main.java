package com.gathergrid.gathergridfeatures;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory efm = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = efm.createEntityManager();
        em.getTransaction().begin();



        em.getTransaction().commit();
        efm.close();
    }
}
