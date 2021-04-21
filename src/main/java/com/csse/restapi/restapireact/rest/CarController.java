package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.Cars;
import com.csse.restapi.restapireact.entities.Category;
import com.csse.restapi.restapireact.repositories.CarRepository;
import com.csse.restapi.restapireact.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarController  {

    @Autowired
    public CarRepository carRepository;

    @GetMapping(value = "/getcars")
    public ResponseEntity<?> getAllItems(){
        List<Cars> items = carRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/cars/{id}")
    public ResponseEntity<?> getCar(@PathVariable("id") Long id) {
        System.out.println(id);
        Cars car = carRepository.findById(id).get();

        return new ResponseEntity<Cars>(car, HttpStatus.OK);
    }

    @PostMapping(value = "/newcar")
    public ResponseEntity addCar(@RequestBody Cars car) {
        carRepository.save(car);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @PutMapping(value = "/editcar/{id}")
    public ResponseEntity editcar(@RequestBody Cars car, @PathVariable Long id) {
        carRepository.save(car);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @DeleteMapping("/deletecar/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
