package io.deoki.blog.repository;

import io.deoki.blog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void crud() {
        User user = new User();
        user.setLastName("test Last name");
        user.setFirstName("test First Name");

        userRepository.save(user);
    }
}