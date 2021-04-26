package com.csse.restapi.restapireact.repositories;


import com.csse.restapi.restapireact.entities.CarGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarGalleryRepository extends JpaRepository<CarGallery, Long> {

    List<CarGallery> findAllByPublicationId(Long id);
}
