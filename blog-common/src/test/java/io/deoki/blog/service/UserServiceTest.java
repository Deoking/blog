package io.deoki.blog.service;

import io.deoki.blog.entity.Account;
import io.deoki.blog.entity.Permission;
import io.deoki.blog.entity.Role;
import io.deoki.blog.entity.composite.Address;
import io.deoki.blog.util.attribute.PermissionType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    // Create role for user crud test.
    @Before
    public void saveRole(){


        System.out.println("Before test completed.");
    }

    @Test
    public void createAccount() {
        Account account = new Account();
        //Account settings.
        account.setFirstName("Deoki");
        account.setLastName("Kang");
        account.setBirth("19881113");
        account.setEmail("deoki@test.com");
        account.setUsername("deoki");
        account.setPhoneNumber("01012341234");
        account.setPassword("passw@rd");

        //address settings.
        Address address = new Address();
        address.setCity("Seoul");
        address.setCountry("Republic of Korea");
        address.setState("Gasan-dong, Geumcheongu");
        address.setStreet("Seobuset Gil 606");
        address.setZipCode("12345");
        account.setAddress(address);
        account.setAddress(address);

        Role role = new Role();
        role.setName("Administrator");

        HashSet<Permission> permissionSet = new HashSet<Permission>(roleService.findPermissionAll());

        role.setPermissions(permissionSet);

//        Role saveRole = roleService.saveRole(role);
//        Account savedAccount = userService.saveAccount(account);

        account.setRole(role);
        role.getAccounts().add(account);

        roleService.saveRole(role);
        userService.saveAccount(account);
    }
}