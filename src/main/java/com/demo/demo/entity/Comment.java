package com.demo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
