package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.Cards;
import com.csse.restapi.restapireact.entities.Items;

import java.util.List;

public interface CardService {

    List<Cards> getAllCards();
    Cards getCard(Long id);
    Cards addCard(Cards card);
}
