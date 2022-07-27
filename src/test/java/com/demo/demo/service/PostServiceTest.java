package com.demo.demo.service;

import com.demo.demo.entity.Comment;
import com.demo.demo.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    void setUp() {

        Comment comment = Comment.builder()
//                .commentId(3L)
                .content("Freedom fighters was a great book")
                .build();

        Collection<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);

        Post post = Post.builder()
//                .postId(2L)
                .author("author")
                .title("Freedom Fighters")
                .content("Content of the post")
//                .id(1L)
                .comments(comments)
                .build();

        postService.createPost(post);
    }

    @Test
    void getAllPosts() {
        Collection<Post> posts = postService.getAllPosts().getBody();
//        Collection<Comment> comments = commentService.getAllComments().getBody();
        posts.forEach(System.out::println);
//        comments.forEach(System.out::println);
//        assertEquals(1, posts.size());
    }

    @Test
    void getAllComments(){
        Collection<Comment> comments = commentService.getAllComments().getBody();

        comments.forEach(System.out::println);
    }
}