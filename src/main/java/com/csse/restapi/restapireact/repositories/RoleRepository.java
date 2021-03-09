package com.csse.restapi.restapireact.repositories;


import com.csse.restapi.restapireact.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Roles, Long> {

    Roles findByName(String name);
}
