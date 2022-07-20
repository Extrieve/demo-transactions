package com.demo.demo.service;

import com.demo.demo.entity.Post;
import com.demo.demo.respository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class PostService implements Delegator {

    @Autowired
    private PostRepository postRepository;


    public ResponseEntity<Collection<Post>> getAllPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    public ResponseEntity<Post> getPostById(Long id) {
        return ResponseEntity.ok(postRepository.getById(id));
    }

    public ResponseEntity<Post> createPost(Post post) {
        return ResponseEntity.ok(postRepository.save(post));
    }
}
