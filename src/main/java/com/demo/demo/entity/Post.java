package com.demo.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Component
@Table(name = "post")
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

//    @JsonManagedReference
//    @ToString.Include
//    @JsonInclude
    @OneToMany(mappedBy = "post",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE},
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Collection<Comment> comments = new ArrayList<>();

}
