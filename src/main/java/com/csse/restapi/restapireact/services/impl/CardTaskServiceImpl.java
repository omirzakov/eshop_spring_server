package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.CardTasks;
import com.csse.restapi.restapireact.entities.Cards;
import com.csse.restapi.restapireact.repositories.CardTaskRepository;
import com.csse.restapi.restapireact.services.CardTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardTaskServiceImpl implements CardTaskService {
    @Autowired
    private CardTaskRepository cardTaskRepository;



    @Override
    public List<CardTasks> getAllCardTasks(Cards card) {

        return (List<CardTasks>) cardTaskRepository.findAllByCard(card);
    }

    @Override
    public CardTasks addSubCard(CardTasks card) {
        return cardTaskRepository.save(card);
    }

    @Override
    public CardTasks updateSubCard(CardTasks card) {
        return cardTaskRepository.save(card);
    }

    @Override
    public CardTasks getSubCard(Long id) {
        return cardTaskRepository.findById(id).get();
    }


    @Override
    public void deleteSubCard(Long id) {
        cardTaskRepository.deleteById(id);
    }


}
