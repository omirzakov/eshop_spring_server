package com.csse.restapi.restapireact.rest;

import com.csse.restapi.restapireact.entities.Bank;
import com.csse.restapi.restapireact.entities.Comment;
import com.csse.restapi.restapireact.repositories.BankRepository;
import com.csse.restapi.restapireact.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BankController {

    @Autowired
    public BankRepository bankRepository;

    @GetMapping(value = "/getbanks")
    public ResponseEntity<?> getAllBanks(){
        List<Bank> items = bankRepository.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping(value = "/addbank")
    public ResponseEntity addBank(@RequestBody Bank bank) {
        bankRepository.save(bank);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @PutMapping(value = "/editbank/{id}")
    public ResponseEntity editBank(@RequestBody Bank bank, @PathVariable Long id) {
        bankRepository.save(bank);

        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @DeleteMapping("/deletebank/{id}")
    public ResponseEntity deleteBank(@PathVariable Long id) {
        bankRepository.deleteById(id);

        return new ResponseEntity(null, HttpStatus.OK);
    }
}