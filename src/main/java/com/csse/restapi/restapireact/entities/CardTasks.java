package com.csse.restapi.restapireact.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    Cards card;

    @Column(name = "taskText")
    private String name;

    @Column(name = "addedDate")
    private Date addedDate;
}
