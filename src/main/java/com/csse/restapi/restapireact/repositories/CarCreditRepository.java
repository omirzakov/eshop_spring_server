package com.csse.restapi.restapireact.repositories;

import com.csse.restapi.restapireact.entities.CarCredit;
import com.csse.restapi.restapireact.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarCreditRepository extends JpaRepository<CarCredit, Long> {

    List<CarCredit> findAllByUser(Users user);
}
