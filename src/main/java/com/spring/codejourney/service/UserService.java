package com.spring.codejourney.service;

import com.spring.codejourney.model.User;
import com.spring.codejourney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return user;
    }

    public User createUser(User user){
        User newUser = userRepository.save(user);
        userRepository.flush();
        return newUser;
    }
}
