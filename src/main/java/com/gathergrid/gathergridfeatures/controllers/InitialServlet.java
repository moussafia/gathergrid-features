package com.gathergrid.gathergridfeatures.controllers;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(loadOnStartup = 1)
public class InitialServlet extends HelloServlet {
    @Override
    public void init() {
        EntityManagerFactory efm = Persistence.createEntityManagerFactory("my-persistence-unit");
    }
}
