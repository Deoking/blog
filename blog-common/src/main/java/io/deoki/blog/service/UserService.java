package io.deoki.blog.service;

import io.deoki.blog.entity.User;
import io.deoki.blog.repository.LoginRepository;
import io.deoki.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    LoginRepository loginRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

}
