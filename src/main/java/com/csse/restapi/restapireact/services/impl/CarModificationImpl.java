package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.CarModification;
import com.csse.restapi.restapireact.repositories.CarModificationRepository;
import com.csse.restapi.restapireact.services.CarModificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarModificationImpl implements CarModificationService {

    @Autowired
    private CarModificationRepository carModificationRepository;

    @Override
    public List<CarModification> getAllCarModifications() {
        return carModificationRepository.findAll();
    }

    @Override
    public CarModification getCarModification(Long id) {
        return carModificationRepository.findById(id).get();
    }

    @Override
    public CarModification addCarModification(CarModification car) {
        return carModificationRepository.save(car);
    }

    @Override
    public CarModification updateCarModification(CarModification car) {
        return carModificationRepository.save(car);
    }

    @Override
    public void deleteCarModification(Long id) {
        carModificationRepository.deleteById(id);
    }
}
