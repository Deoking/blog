package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Post {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)

    private Long id;

    private String title;

    private String content;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    //TODO Category mapping is not yet complete.
    @ManyToOne
    private Category category;

    //Each post has one author.
    @ManyToOne
    private User author;
}
