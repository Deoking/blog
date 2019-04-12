package io.deoki.blog.service;

import io.deoki.blog.entity.Account;
import io.deoki.blog.repository.LoginRepository;
import io.deoki.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository users;
    LoginRepository logins;

    public Account save(Account account){
        return users.save(account);
    }

    public Account findById(Long id){
        return users.findById(id).orElse(null);
    }

    public boolean existsById(Long id){
        return users.existsById(id);
    }

    public void delete(Long id){
        users.deleteById(id);
    }

    public void delete(Account account){
        users.delete(account);
    }

}
