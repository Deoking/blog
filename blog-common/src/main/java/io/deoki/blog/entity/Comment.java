package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Comment {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String author;
    private String password;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne
    private Post post;
}
