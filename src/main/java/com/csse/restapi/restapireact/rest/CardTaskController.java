package com.csse.restapi.restapireact.rest;



import com.csse.restapi.restapireact.entities.CardTasks;
import com.csse.restapi.restapireact.entities.Cards;
import com.csse.restapi.restapireact.services.CardService;
import com.csse.restapi.restapireact.services.CardTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CardTaskController {

    @Autowired
    private CardTaskService cardTaskService;

    @Autowired
    private CardService cardService;

    @GetMapping(value = "/cards/{id}")
    public ResponseEntity<?> getAllCardTasks(@PathVariable Long id){
        Cards card = cardService.getCard(id);
        List<CardTasks> cardTasks = cardTaskService.getAllCardTasks(card);

        System.out.println(cardTasks);
        return new ResponseEntity<>(cardTasks, HttpStatus.OK);
    }

    @PostMapping(value = "/addsubtask")
    public ResponseEntity<?> addSubTask(@RequestBody CardTasks card){
        Date nowTime = new Date();
        Cards subCard = cardService.getCard(card.getId());
        card.setCard(subCard);
        card.setAddedDate(nowTime);
        card.setId(null);

        cardTaskService.addSubCard(card);
        return ResponseEntity.ok(card);
    }

    @PutMapping(value = "/updatesubtask")
    public ResponseEntity<?> updateSubTask(@RequestBody CardTasks card){

        cardTaskService.updateSubCard(card);
        return ResponseEntity.ok(card);
    }

    @PostMapping(value = "/deletesubtask/{id}")
    public ResponseEntity<?> deleteSubTask(@PathVariable Long id){
        CardTasks card = cardTaskService.getSubCard(id);

        cardTaskService.deleteSubCard(card.getId());
        return ResponseEntity.ok(card);
    }




}
