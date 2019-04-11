package io.deoki.blog.service;

import io.deoki.blog.entity.User;
import io.deoki.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

}
