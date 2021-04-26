package com.csse.restapi.restapireact.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "publication_comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "is_edited")
    private boolean isEdited;

    @Column(name = "slug")
    private String slug;

    @ManyToOne
    private Publication publication;

    @ManyToOne
    private Users user;

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
