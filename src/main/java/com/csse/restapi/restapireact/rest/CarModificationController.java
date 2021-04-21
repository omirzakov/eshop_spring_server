package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.CarModification;
import com.csse.restapi.restapireact.entities.Cars;
import com.csse.restapi.restapireact.entities.Category;
import com.csse.restapi.restapireact.repositories.CarModificationRepository;
import com.csse.restapi.restapireact.repositories.CarRepository;
import com.csse.restapi.restapireact.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarModificationController  {

    @Autowired
    public CarModificationRepository carModificationRepository;

    @GetMapping(value = "/getcarmods")
    public ResponseEntity<?> getAllItems(){
        List<CarModification> items = carModificationRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/carmods/{id}")
    public ResponseEntity<?> getCarMod(@PathVariable("id") Long id) {
        System.out.println(id);
        CarModification carmod = carModificationRepository.findById(id).get();

        return new ResponseEntity<CarModification>(carmod, HttpStatus.OK);
    }

    @PostMapping(value = "/newcarmod")
    public ResponseEntity addCarMod(@RequestBody CarModification carmod) {
        carModificationRepository.save(carmod);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @PutMapping(value = "/editcarmod/{id}")
    public ResponseEntity editCarMod(@RequestBody CarModification carmod, @PathVariable Long id) {
        carModificationRepository.save(carmod);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @DeleteMapping("/deletecarmod/{id}")
    public ResponseEntity deleteCarMod(@PathVariable Long id) {
        carModificationRepository.deleteById(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
