package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.CarModification;
import com.csse.restapi.restapireact.entities.Cars;

import java.util.List;

public interface CarModificationService {


    List<CarModification> getAllCarModifications();
    CarModification getCarModification(Long id);
    CarModification addCarModification(CarModification car);
    CarModification updateCarModification(CarModification car);
    void deleteCarModification(Long id);
}
