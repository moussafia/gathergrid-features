package com.gathergrid.gathergridfeatures.repository.interfacesImpl;

import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.repository.interfaces.CategoryRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final EntityManager em;

    public CategoryRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Category save(Category category) {
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        return category;
    }

    @Override
    public Category update(Category category) {
        em.getTransaction().begin();
        em.merge(category);
        em.getTransaction().commit();
        return category;
    }

    @Override
    public void delete(long id) {
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
        em.getTransaction().commit();
    }

    @Override
    public Category find(long id) {
        return em.find(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        String jpql = "SELECT c FROM Category c";
        return em.createQuery(jpql, Category.class)
                .getResultList();
    }
}
