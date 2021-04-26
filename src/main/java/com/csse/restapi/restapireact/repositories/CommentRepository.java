package com.csse.restapi.restapireact.repositories;

import com.csse.restapi.restapireact.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPublicationIdOrderByAddedDateDesc(Long id);
}
