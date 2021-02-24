package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.Cards;
import com.csse.restapi.restapireact.entities.Items;
import com.csse.restapi.restapireact.repositories.CardRepository;
import com.csse.restapi.restapireact.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;


    @Override
    public List<Cards> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Cards getCard(Long id) {
        return cardRepository.findById(id).get();
    }

    @Override
    public Cards addCard(Cards card) {
        return cardRepository.save(card);
    }
}
