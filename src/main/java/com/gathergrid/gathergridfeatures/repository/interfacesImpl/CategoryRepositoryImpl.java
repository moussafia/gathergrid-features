package com.gathergrid.gathergridfeatures.repository.interfacesImpl;

import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.repository.interfaces.CategoryRepository;
import com.gathergrid.gathergridfeatures.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    public final EntityManager em = EntityManagerUtil.getEntityManager();

    @Override
    public List<Category> listCategory() {
        Query query = em.createQuery("select c from Category c");
        return query.getResultList();
    }
}
