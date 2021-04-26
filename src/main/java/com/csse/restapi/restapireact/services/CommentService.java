package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.CarGallery;
import com.csse.restapi.restapireact.entities.Comment;

import java.util.List;

public interface CommentService {


    Comment addComment(Comment comment);
    Comment saveComment(Comment comment);
    Comment getComment(Long id);
    void deleteComment(Comment comment);
    List<Comment> allCommentsByItemAndTime(Long id);

}
