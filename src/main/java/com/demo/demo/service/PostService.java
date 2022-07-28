package com.demo.demo.service;

import com.demo.demo.entity.Comment;
import com.demo.demo.entity.Post;
import com.demo.demo.respository.CommentRepository;
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

    private final Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public ResponseEntity<Collection<Post>> getAllPosts() {
        return ResponseEntity.ok(postRepository.findAll());
    }

    public ResponseEntity<Post> getPostById(Long id) {

        Post payload = postRepository.getById(id);

        return ResponseEntity.ok().body(payload);
    }

    public ResponseEntity<Post> createPost(Post post) {

        logger.info("Saving post with id: " + post.getPostId());
        System.out.println(post);

        Collection<Comment> comments = post.getComments();
//        post.getComments().forEach(comment -> comment.setPost(post));
        comments.forEach(System.out::println);
//        post.setComments(null);
        postRepository.save(post);

//        comments.forEach(comment -> {
//            comment.setPost(post);
//        });
//
//        commentRepository.saveAll(comments);

        return ResponseEntity.ok().body(post);
    }
}
