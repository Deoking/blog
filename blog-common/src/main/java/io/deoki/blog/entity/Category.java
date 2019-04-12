package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Category entity to which blog posts belong. Each category can have a subcategory.
 * @author deoki
 * @version 1.0
 */
@Entity
@Setter
@Getter
public class Category {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;

    //TODO Mapping for subcategory support.
//    @OneToMany
//    private List<Category> categories = new ArrayList<Category>();
//    @ManyToOne
//    private Category category;

    //TODO Post-category mapping is not yet complete.
    @OneToMany
    private Set<Post> posts = new HashSet<Post>();

}
