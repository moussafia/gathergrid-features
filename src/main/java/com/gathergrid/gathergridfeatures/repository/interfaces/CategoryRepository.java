package com.gathergrid.gathergridfeatures.repository.interfaces;

import com.gathergrid.gathergridfeatures.domain.Category;

import java.util.List;

public interface CategoryRepository {
    Category save(Category category);

    Category update(Category category);

    void delete(long id);

    Category find(long id);

    List<Category> findAll();
}
