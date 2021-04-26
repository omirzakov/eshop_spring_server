package com.csse.restapi.restapireact.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars_gallery")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pic_url")
    private String picUrl;

    @ManyToOne
    private Publication publication;

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}

