package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.*;
import com.csse.restapi.restapireact.repositories.*;
import com.csse.restapi.restapireact.security.jwt.JwtProvider;
import com.csse.restapi.restapireact.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PublicationController  {

    @Autowired
    public PublicationRepository publicationRepository;


    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getpublications")
    public ResponseEntity<?> getAllItems(){
        List<Publication> items = publicationRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/publications/{id}")
    public ResponseEntity<?> getPublication(@PathVariable("id") Long id) {
        Publication publication = publicationRepository.findById(id).get();

        return new ResponseEntity<Publication>(publication, HttpStatus.OK);
    }

    @PostMapping(value = "/newpublication/{token}")
    public ResponseEntity addPublication(@RequestBody Publication publication, @PathVariable String token) {
        String email = jwtProvider.getLoginFromToken(token);
        Users currentUser = null;
        if(email != null && email.length() > 0) {
            currentUser = userService.findByLogin(email);
            publication.setUser(currentUser);
            publicationRepository.save(publication);
        }

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @PutMapping(value = "/editpublication/{id}/{token}")
    public ResponseEntity editPublication(@RequestBody Publication publication, @PathVariable Long id, @PathVariable String token) {
        publicationRepository.save(publication);
        String email = jwtProvider.getLoginFromToken(token);
        if(email != null && email.length() > 0) {
            publicationRepository.save(publication);
        }

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @DeleteMapping("/deletepublication/{id}")
    public ResponseEntity deletePublication(@PathVariable Long id) {
        publicationRepository.deleteById(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
