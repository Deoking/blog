package io.deoki.blog.repository;

import io.deoki.blog.entity.User;
import io.deoki.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserService userService;

    @Test
    public void crud() {
        User user = new User();
        user.setLastName("test Last name");
        user.setFirstName("test First Name");

        userService.save(user);
    }
}