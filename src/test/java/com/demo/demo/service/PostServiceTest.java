package com.demo.demo.service;

import com.demo.demo.entity.Comment;
import com.demo.demo.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    void setUp() {

        Comment comment = Comment.builder()
                .id(1L)
                .content("test")
                .build();

        Collection<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);

        Post post = Post.builder()
                .author("author")
                .title("title")
                .id(1L)
                .build();

        post.setComments(comments);

        postService.createPost(post);
    }

    @Test
    void getAllPosts() {
        Collection<Post> posts = postService.getAllPosts().getBody();
        Collection<Comment> comments = commentService.getAllComments().getBody();
        posts.forEach(System.out::println);
        comments.forEach(System.out::println);
        assertEquals(1, posts.size());
    }
}