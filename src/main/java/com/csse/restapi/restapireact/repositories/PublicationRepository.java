package com.csse.restapi.restapireact.repositories;


import com.csse.restapi.restapireact.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByUserId(Long id);
    List<Publication> findAllByCarCategorySlug(String name);
    List<Publication> findAllByCarNameAndPriceBetweenOrderByPriceDesc(String name, Long from, Long to);
    Publication findByName(String name);
}
