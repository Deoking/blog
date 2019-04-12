package io.deoki.blog.service;

import io.deoki.blog.entity.Permission;
import io.deoki.blog.entity.Role;
import io.deoki.blog.util.attribute.PermissionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    public void crud() {
        Role role1 = new Role();
        role1.setName("administrator");

        Permission permission1 = new Permission();
        permission1.setName(PermissionType.Post.POST_WRITE);
        permission1.setPermission(1);

        Permission permission2 = new Permission();
        permission2.setName(PermissionType.Post.POST_UPDATE);
        permission2.setPermission(1);

        Permission permission3 = new Permission();
        permission3.setName(PermissionType.Category.CATEGORY_WRITE);
        permission3.setPermission(1);

        Permission permission4 = new Permission();
        permission4.setName(PermissionType.User.USER_WRITE);
        permission4.setPermission(1);

        role1.getPermissions().add(permission1);
        role1.getPermissions().add(permission2);
        role1.getPermissions().add(permission3);
        role1.getPermissions().add(permission4);

        roleService.saveRole(role1);

        List<Role> roleAll = roleService.findRoleAll();

    }

}