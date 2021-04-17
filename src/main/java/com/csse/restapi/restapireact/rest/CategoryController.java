package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.Category;
import com.csse.restapi.restapireact.repositories.CardRepository;
import com.csse.restapi.restapireact.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    private CardRepository cardRepository;

    @GetMapping(value = "/getcategories")
    public ResponseEntity<?> getAllItems(){
        List<Category> items = categoryRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") Long id) {
        System.out.println(id);
        Category category = categoryRepository.findById(id).get();

        System.out.println(category);

        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PostMapping(value = "/newcategory")
    public ResponseEntity addCategory(@RequestBody Category category) {
        categoryRepository.save(category);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @PutMapping(value = "/editcategory/{id}")
    public ResponseEntity editCategory(@RequestBody Category category, @PathVariable Long id) {
        System.out.println(category);
        System.out.println(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }

    @DeleteMapping("/deletecategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id) {
        System.out.println(id);
        categoryRepository.deleteById(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
