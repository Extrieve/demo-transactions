package com.demo.demo.controller;

import com.demo.demo.entity.Post;
import com.demo.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
 @CrossOrigin("http://localhost:4200")
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

    @PostMapping(value = "/posts/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}
