package com.csse.restapi.restapireact.rest;

import com.csse.restapi.restapireact.entities.Cards;
import com.csse.restapi.restapireact.entities.Items;
import com.csse.restapi.restapireact.services.CardService;
import com.csse.restapi.restapireact.services.CardTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {


    @Autowired
    private CardService cardService;

    @Autowired
    private CardTaskService cardTaskService;

    @GetMapping(value = "/allcards")
    public ResponseEntity<?> getAllItems(){
        List<Cards> items = cardService.getAllCards();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/add/card")
    public ResponseEntity<?> addItem(@RequestBody Cards card){
        cardService.addCard(card);
        return ResponseEntity.ok(card);
    }

    @GetMapping(value = "/card/{id}")
    @ResponseBody
    public ResponseEntity<Cards> getCard(@PathVariable Long id) {
        Cards card = cardService.getCard(id);

        return new ResponseEntity<Cards>(card, HttpStatus.OK);
    }

    @PostMapping(value = "/addtask")
    public ResponseEntity<?> addTask(@RequestBody Cards card){
        cardService.addCard(card);
        return ResponseEntity.ok(card);
    }

    @PutMapping(value = "/updatecard")
    public ResponseEntity<?> updateTask(@RequestBody Cards card) {
        cardService.updateCard(card);

        return ResponseEntity.ok(card);
    }

    @DeleteMapping(value = "/deletecard/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Cards card = cardService.getCard(id);

        cardService.deleteCard(card.getId());

        return ResponseEntity.ok(card);
    }
}
