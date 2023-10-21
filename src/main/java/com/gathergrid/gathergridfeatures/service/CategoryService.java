package com.gathergrid.gathergridfeatures.service;

import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.repository.interfaces.CategoryRepository;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.CategoryRepositoryImpl;
import com.gathergrid.gathergridfeatures.utils.EntityManagerUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryService() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        categoryRepository = new CategoryRepositoryImpl(em);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getById(long id) {
        return categoryRepository.find(id);
    }
}
