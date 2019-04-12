package io.deoki.blog.service;

import io.deoki.blog.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiService {

    @Autowired
    UserService userService;

    public Account saveUser(Account account){
        return userService.save(account);
    }

}
