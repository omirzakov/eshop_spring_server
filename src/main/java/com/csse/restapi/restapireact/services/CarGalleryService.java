package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.CarGallery;

import java.util.List;

public interface CarGalleryService {

    CarGallery addPicture(CarGallery picture);
    CarGallery savePicture(CarGallery picture);
    CarGallery getPicture(Long id);
    void deletePicture(CarGallery picture);

    List<CarGallery> getAllPhotoItem(Long id);
}
