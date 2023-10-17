package com.gathergrid.gathergridfeatures.controller;

<<<<<<< HEAD
        import jakarta.persistence.EntityManagerFactory;
        import jakarta.persistence.Persistence;
        import jakarta.servlet.annotation.WebServlet;
=======
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
>>>>>>> main

@WebServlet(loadOnStartup = 1)
public class InitialServlet extends HttpServlet {
    @Override
    public void init() {
        EntityManagerFactory efm = Persistence.createEntityManagerFactory("my-persistence-unit");
    }
}