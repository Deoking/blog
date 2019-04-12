package io.deoki.blog.entity;

import io.deoki.blog.util.attribute.PermissionEnumType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * This is the entity of the Permission that the Role has.
 * For example, post-writes, post-modifications, post-remove, etc.
 * @author deoki
 * @version 1.0
 */
@Entity
@Setter
@Getter
public class Permission {
    @Id @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;
    /**
     *  Specify the status of the permission.
     *  1 - Enabled, 0 - Disabled
     **/
    private Integer permission;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created = new Date();

    public void setName(PermissionEnumType permissionName){
        this.name = permissionName.getName(permissionName.toString());
    }
}
