package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.Cars;
import com.csse.restapi.restapireact.entities.Users;
import com.csse.restapi.restapireact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/admin/users")
    public ResponseEntity<?> getAllItems(){
        List<Users> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
