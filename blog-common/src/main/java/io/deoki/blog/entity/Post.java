package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity that defined the blog post.
 * Post-entity is linked to one user entity and one category entity.
 * @author deoki
 * @version 1.0
 */

@Entity
@Setter
@Getter
public class Post {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;

    private String content;

    private Integer views;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    //TODO Category mapping is not yet complete.
    @ManyToOne
    private Category category;

    //Each post has one author.
    @ManyToOne
    private Account author;

    @OneToMany(mappedBy = "post")
    private Set<Tag> tags = new HashSet<Tag>();

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<Comment>();

    public void addTags(Tag tag) {
        this.getTags().add(tag);
        tag.setPost(this);
    }

    public void addComment(Comment comment) {
        this.getComments().add(comment);
        comment.setPost(this);
    }
}
