package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Permission {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String permission;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;
}
