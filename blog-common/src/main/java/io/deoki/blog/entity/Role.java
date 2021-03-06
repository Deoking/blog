package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. Role entities are mapped 1:1 to each user.
 * It also has a set of Permission entities.
 * @author deoki
 * @version 1.0
 */

@Entity
@Setter
@Getter
public class Role {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)

    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Permission> permissions = new HashSet<Permission>();

    @OneToMany(mappedBy = "role")
    private Set<Account> accounts = new HashSet<Account>();

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created = new Date();
}
