package io.deoki.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Tag {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    private Set<Post> posts = new HashSet<Post>();

}
