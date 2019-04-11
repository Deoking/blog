package io.deoki.blog.entity;

import io.deoki.blog.entity.composite.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String birth;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "street_name")),
            @AttributeOverride(name = "city", column = @Column(name ="city_name")),
            @AttributeOverride(name = "state", column = @Column(name ="state_name"))
    })
    private Address address;

    //Each user has several posts.
    @OneToMany
    private Set<Post> posts = new HashSet<Post>();

    @OneToOne
    private Role role;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;
}
