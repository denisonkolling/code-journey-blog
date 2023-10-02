package com.spring.codejourney.repository;

import com.spring.codejourney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


    User findUserByEmail(String email);
}
