package io.deoki.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Tag {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Post post;

}
