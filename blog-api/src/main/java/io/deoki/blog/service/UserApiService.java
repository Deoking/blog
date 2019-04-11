package io.deoki.blog.service;

import io.deoki.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiService {

    @Autowired
    UserService userService;

    public User saveUser(User user){
        return userService.save(user);
    }

}
