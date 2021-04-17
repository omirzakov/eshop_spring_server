package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
}
