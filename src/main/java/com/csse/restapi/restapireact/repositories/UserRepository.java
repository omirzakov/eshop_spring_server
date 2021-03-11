package com.csse.restapi.restapireact.repositories;


import com.csse.restapi.restapireact.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Long> {

    Users getByEmail(String email);
}
