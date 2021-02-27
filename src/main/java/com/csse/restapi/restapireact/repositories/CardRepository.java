package com.csse.restapi.restapireact.repositories;

import com.csse.restapi.restapireact.entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CardRepository extends JpaRepository<Cards, Long> {

    List<Cards> getAllByNameLike(String name);
}
