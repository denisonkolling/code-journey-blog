package com.spring.codejourney.repository;

import com.spring.codejourney.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
