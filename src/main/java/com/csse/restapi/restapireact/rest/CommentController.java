package com.csse.restapi.restapireact.rest;


import com.csse.restapi.restapireact.entities.CarModification;
import com.csse.restapi.restapireact.entities.Comment;
import com.csse.restapi.restapireact.entities.Publication;
import com.csse.restapi.restapireact.repositories.CarModificationRepository;
import com.csse.restapi.restapireact.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    @Autowired
    public CommentRepository commentRepository;

    @GetMapping(value = "/getcomments/{id}")
    public ResponseEntity<?> getAllCommentByPublicationId(@PathVariable Long id){
        List<Comment> items = commentRepository.findAllByPublicationIdOrderByAddedDateDesc(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(value = "/getallcomments")
    public ResponseEntity<?> getAllComments(@PathVariable("id") Long id) {
        System.out.println(id);
        List<Comment> comments = commentRepository.findAll();



        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping(value = "/newcomment")
    public ResponseEntity addComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        Date nowDate = new Date();
        comment.setAddedDate(nowDate);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @PutMapping(value = "/editcomment/{id}")
    public ResponseEntity editCarMod(@RequestBody Comment comment, @PathVariable Long id) {
        commentRepository.save(comment);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @DeleteMapping("/deletecomment/{id}")
    public ResponseEntity deleteCarMod(@PathVariable Long id) {
        commentRepository.deleteById(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}
