package com.demo.demo.controller;

import com.demo.demo.entity.Comment;
import com.demo.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<Collection<Comment>> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(Long id) {
        return commentService.getCommentById(id);
    }

    @GetMapping("/comments/create")
    public ResponseEntity<Comment> createComment(Comment comment) {
        return commentService.createComment(comment);
    }
}
