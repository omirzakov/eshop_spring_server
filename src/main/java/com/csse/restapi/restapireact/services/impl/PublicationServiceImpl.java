package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.Publication;
import com.csse.restapi.restapireact.repositories.PublicationRepository;
import com.csse.restapi.restapireact.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Publication> getPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getPublication(Long id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public Publication addPublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public Publication updatePublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Override
    public void deletePublication(Long id) {

    }
}
