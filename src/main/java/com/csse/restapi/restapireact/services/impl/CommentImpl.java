package com.csse.restapi.restapireact.services.impl;

import com.csse.restapi.restapireact.entities.CarGallery;
import com.csse.restapi.restapireact.entities.Comment;
import com.csse.restapi.restapireact.repositories.CommentRepository;
import com.csse.restapi.restapireact.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> allCommentsByItemAndTime(Long id) {
        return commentRepository.findAllByPublicationIdOrderByAddedDateDesc(id);
    }
}
