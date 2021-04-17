package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.Cards;
import com.csse.restapi.restapireact.entities.Category;
import com.csse.restapi.restapireact.repositories.CategoryRepository;
import com.csse.restapi.restapireact.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService  {


    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public Category addCard(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCard(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCard(Long id) {
        categoryRepository.deleteById(id);
    }
}
