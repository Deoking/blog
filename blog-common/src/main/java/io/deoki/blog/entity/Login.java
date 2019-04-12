package io.deoki.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * History entity to store the log-in histories of the authors.
 * @author deoki
 * @version 1.0
 */
@Entity
@Setter
@Getter
@Table(name = "login_histories")
public class Login {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private Long userId;
    private Long roleId;
    private String ip;
    private String userAgent;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created;
}
