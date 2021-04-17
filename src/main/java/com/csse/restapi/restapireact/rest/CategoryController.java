package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.Category;
import com.csse.restapi.restapireact.entities.Items;
import com.csse.restapi.restapireact.repositories.CategoryRepository;
import com.csse.restapi.restapireact.services.CardTaskService;
import com.csse.restapi.restapireact.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping(value = "/getcategories")
    public ResponseEntity<?> getAllItems(){
        List<Category> items = categoryRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
