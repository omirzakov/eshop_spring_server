package com.csse.restapi.restapireact.repositories;

import com.csse.restapi.restapireact.entities.Cars;
import com.csse.restapi.restapireact.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Cars, Long> {
}
