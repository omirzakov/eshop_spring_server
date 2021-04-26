package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.CarGallery;
import com.csse.restapi.restapireact.entities.Cars;
import com.csse.restapi.restapireact.repositories.CarGalleryRepository;
import com.csse.restapi.restapireact.services.CarGalleryService;
import com.csse.restapi.restapireact.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarGalleryImpl implements CarGalleryService {
    @Autowired
    private CarGalleryRepository carGalleryRepository;

    @Override
    public CarGallery addPicture(CarGallery picture) {
        return carGalleryRepository.save(picture);
    }

    @Override
    public CarGallery savePicture(CarGallery picture) {
        return carGalleryRepository.save(picture);
    }

    @Override
    public CarGallery getPicture(Long id) {
        return carGalleryRepository.findById(id).get();
    }

    @Override
    public void deletePicture(CarGallery picture) {
        carGalleryRepository.delete(picture);
    }

    @Override
    public List<CarGallery> getAllPhotoItem(Long id) {
        return carGalleryRepository.findAllByPublicationId(id);
    }
}
