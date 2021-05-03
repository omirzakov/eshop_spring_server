package com.csse.restapi.restapireact.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "publication_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationReports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "info")
    private String info;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Publication publication;

}
