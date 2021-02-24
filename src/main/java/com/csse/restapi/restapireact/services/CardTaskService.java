package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.CardTasks;
import com.csse.restapi.restapireact.entities.Cards;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CardTaskService {


    List<CardTasks> getAllCardTasks(Cards card);
    CardTasks addSubCard(CardTasks card);
    CardTasks updateSubCard(CardTasks card);
    CardTasks getSubCard(Long id);
    void deleteSubCard(Long id);
}
