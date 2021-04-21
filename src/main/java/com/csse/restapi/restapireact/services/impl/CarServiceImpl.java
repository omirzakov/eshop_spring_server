package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.Cars;
import com.csse.restapi.restapireact.repositories.CarRepository;
import com.csse.restapi.restapireact.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Cars> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Cars getCar(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Cars addCar(Cars car) {
        return carRepository.save(car);
    }

    @Override
    public Cars updateCar(Cars car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
