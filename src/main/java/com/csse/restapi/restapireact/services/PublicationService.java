package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.CarModification;
import com.csse.restapi.restapireact.entities.Publication;

import java.util.List;

public interface PublicationService {
    List<Publication> getPublications();
    Publication getPublication(Long id);
    Publication addPublication(Publication publication);
    Publication updatePublication(Publication publication);
    Publication findByName(String name);
    List<Publication> getAllPublicationByUserId(Long id);
    List<Publication> getAllByCategoryName(String name);
    void deletePublication(Long id);
}
