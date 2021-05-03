package com.csse.restapi.restapireact.rest;

import com.csse.restapi.restapireact.entities.Category;
import com.csse.restapi.restapireact.entities.PublicationReports;
import com.csse.restapi.restapireact.repositories.CategoryRepository;
import com.csse.restapi.restapireact.repositories.PublicationReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PublicationReportsController {

    @Autowired
    public PublicationReportsRepository publicationReportsRepository;



    @GetMapping(value = "/getreports")
    public ResponseEntity<?> getAllItems(){
        List<PublicationReports> items = publicationReportsRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
//
//    @GetMapping(value = "/categories/{id}")
//    public ResponseEntity<?> getCategory(@PathVariable("id") Long id) {
//        System.out.println(id);
//        Category category = categoryRepository.findById(id).get();
//
//        System.out.println(category);
//
//        return new ResponseEntity<Category>(category, HttpStatus.OK);
//    }
//
    @PostMapping(value = "/addreport")
    public ResponseEntity addCategory(@RequestBody PublicationReports publicationReports) {
        System.out.println(publicationReports);
        publicationReportsRepository.save(publicationReports);

        return new ResponseEntity("Success", HttpStatus.OK);
    }
//
//    @PutMapping(value = "/editcategory/{id}")
//    public ResponseEntity editCategory(@RequestBody Category category, @PathVariable Long id) {
//        categoryRepository.save(category);
//
//        return new ResponseEntity("Success", HttpStatus.OK);
//    }
//
    @DeleteMapping("/deletereport/{id}")
    public ResponseEntity deleteReport(@PathVariable Long id) {
        System.out.println(id);
        publicationReportsRepository.deleteById(id);

        return new ResponseEntity("deleted", HttpStatus.OK);
    }
}
