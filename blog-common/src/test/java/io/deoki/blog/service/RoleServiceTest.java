package io.deoki.blog.service;

import io.deoki.blog.entity.Role;
import io.deoki.blog.entity.Permission;
import io.deoki.blog.util.attribute.PermissionType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    public void crud() {
        //given
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
        
        //when
        Role saveRole = roleService.saveRole(role1);

        //then
        Set<Permission> permissions = saveRole.getPermissions();
        //saveRole의 Permission 갯수는 4개
        assertThat(permissions.size()).isEqualTo(4);
        //DB에 저장된 Permission 갯수도 4개
        assertThat(roleService.findPermissionAll().size()).isEqualTo(4);

        System.out.println("********************* Saved Permissions *********************");
        permissions.forEach(permission -> {
            System.out.println(permission.getName());
        });

        //when
        //persist 상태의 role에서 1번 permission을 삭제하면
        saveRole.getPermissions().remove(permission1);

        //then
        assertThat(roleService.findPermissionAll().size()).isEqualTo(3);



        List<Role> roleAll = roleService.findRoleAll();

    }

}