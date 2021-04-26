package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.CarGallery;
import com.csse.restapi.restapireact.entities.CarModification;
import com.csse.restapi.restapireact.entities.Publication;
import com.csse.restapi.restapireact.repositories.CarGalleryRepository;
import com.csse.restapi.restapireact.repositories.CarModificationRepository;
import com.csse.restapi.restapireact.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarGalleryController {

    @Autowired
    public CarGalleryRepository carGalleryRepository;

    @Autowired
    public PublicationRepository publicationRepository;

    @GetMapping(value = "/getcargallery/{id}")
    public ResponseEntity<?> getAllItems(@PathVariable Long id){
        List<CarGallery> items = carGalleryRepository.findAllByPublicationId(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/addcargallery/{name}")
    public ResponseEntity<?> addCarGallery(@PathVariable String name, @RequestBody List<CarGallery> carGalleries) {
        System.out.println(carGalleries);
        Publication publication = publicationRepository.findByName(name);
        System.out.println(publication);

        for(int i = 0; i < carGalleries.size(); i++) {
            carGalleries.get(i).setPublication(publication);
            carGalleryRepository.save(carGalleries.get(i));
        }


        return new ResponseEntity<>("items", HttpStatus.OK);
    }


}
