package com.demo.demo.service;

import com.demo.demo.entity.Post;
import com.demo.demo.respository.PostRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@Slf4j
public class PostService implements Delegator {


    private Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;


    public ResponseEntity<Collection<Post>> getAllPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    public ResponseEntity<Post> getPostById(Long id) {

        try {
            Post payload = postRepository.getById(id);
            return ResponseEntity.ok(postRepository.getById(id));
        } catch(RuntimeException e){
            logger.error("Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(Post.builder().build());
        }
    }

    public ResponseEntity<Post> createPost(Post post) {
        return ResponseEntity.ok(postRepository.save(post));
    }
}
