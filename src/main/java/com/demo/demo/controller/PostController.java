package com.demo.demo.controller;

import com.demo.demo.entity.Post;
import com.demo.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<Collection<Post>> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts/create")
    public ResponseEntity<Post> createPost(Post post) {
        return postService.createPost(post);
    }
}
