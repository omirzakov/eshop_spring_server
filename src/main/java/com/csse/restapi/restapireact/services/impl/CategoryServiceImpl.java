package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.Category;
import com.csse.restapi.restapireact.repositories.CategoryRepository;
import com.csse.restapi.restapireact.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService  {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
