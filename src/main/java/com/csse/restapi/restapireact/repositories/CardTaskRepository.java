package com.csse.restapi.restapireact.repositories;

import com.csse.restapi.restapireact.entities.CardTasks;
import com.csse.restapi.restapireact.entities.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface CardTaskRepository extends JpaRepository<CardTasks, Long> {

    List<CardTasks> findAllByCard(Cards card);
}
