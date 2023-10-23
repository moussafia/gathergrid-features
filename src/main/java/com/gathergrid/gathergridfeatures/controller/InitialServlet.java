package com.gathergrid.gathergridfeatures.controller;


import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.domain.User;
import com.gathergrid.gathergridfeatures.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(loadOnStartup = 1)
public class InitialServlet extends HttpServlet {
    @Override
    public void init() {
        EntityManager em = EntityManagerUtil.getEntityManager();
//        User user = new User("mohammed", "mohammed", "mohammed@gmail.com", "password");
//        em.getTransaction().begin();
//
//        em.persist(new Category("Music"));
//        em.persist(new Category("Science"));
//        em.persist(new Category("Health"));
//        em.persist(new Category("Sport"));
//        em.persist(new Category("Computer science"));
//        em.persist(new Category("css"));
//        em.persist(new Category("Animals"));
//        em.persist(new Category("Food"));
//        em.persist(new Category("Combat sport"));
//        em.persist(new Category("Islam"));
//        em.persist(user);
//
//        em.getTransaction().commit();
    }
}