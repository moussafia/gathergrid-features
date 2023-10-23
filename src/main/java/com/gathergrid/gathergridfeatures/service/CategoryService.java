package com.gathergrid.gathergridfeatures.service;

import com.gathergrid.gathergridfeatures.domain.Category;
import com.gathergrid.gathergridfeatures.repository.interfaces.CategoryRepository;
import com.gathergrid.gathergridfeatures.repository.interfaces.CommentRepositry;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.CategoryRepositoryImpl;
import com.gathergrid.gathergridfeatures.repository.interfacesImpl.CommentRepositryImpl;

import java.util.List;

public class CategoryService {
    public List<Category> listCategory(){
        CategoryRepository categoryRepository = new CategoryRepositoryImpl();
        return categoryRepository.listCategory();
    }
}
