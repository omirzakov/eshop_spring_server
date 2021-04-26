package com.csse.restapi.restapireact.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "additional_info")
    private String additional_info;

    @Column(name = "picture")
    private String picture;

    @Column(name = "contact")
    private String contact;

    @Column(name ="price")
    private Long price;

    @Column(name = "year")
    private int year;

    @Column(name = "email")
    private String email;


    @ManyToOne
    private Users user;

    @ManyToOne
    private Cars car;

    @ManyToMany
    private List<CarModification> carModifications;

    public void setUser(Users user) {
        this.user = user;
    }
}
