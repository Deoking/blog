package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Role {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    @OneToMany
    private Set<Permission> permissions = new HashSet<Permission>();
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;
}
