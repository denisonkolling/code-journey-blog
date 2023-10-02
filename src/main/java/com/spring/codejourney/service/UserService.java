package com.spring.codejourney.service;

import com.spring.codejourney.model.User;

public interface UserService {

    User loadUserByUsername(String email);

}
