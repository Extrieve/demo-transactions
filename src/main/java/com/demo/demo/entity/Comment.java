package com.demo.demo.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Component
@Table(name = "comment")
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    @ToString.Exclude
    private Post post;

}
