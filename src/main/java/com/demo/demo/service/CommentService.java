package com.demo.demo.service;

import com.demo.demo.entity.Comment;
import com.demo.demo.respository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class CommentService implements Delegator {

    @Autowired
    private CommentRepository commentRepository;

    public ResponseEntity<Collection<Comment>> getAllComments() {
        return ResponseEntity.ok(commentRepository.findAll());
    }

    public ResponseEntity<Comment> getCommentById(Long id) {
        return ResponseEntity.ok(commentRepository.getById(id));
    }

    public ResponseEntity<Comment> createComment(Comment comment) {
        return ResponseEntity.ok(commentRepository.save(comment));
    }
}
