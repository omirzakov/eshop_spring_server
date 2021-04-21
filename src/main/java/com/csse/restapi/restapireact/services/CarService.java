package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.Cars;
import com.csse.restapi.restapireact.entities.Category;

import java.util.List;

public interface CarService {

    List<Cars> getAllCars();
    Cars getCar(Long id);
    Cars addCar(Cars car);
    Cars updateCar(Cars car);
    void deleteCar(Long id);
}
