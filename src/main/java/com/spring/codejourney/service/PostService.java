package com.spring.codejourney.service;

import com.spring.codejourney.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

    List<Post> findAllPost();
    Post findPostById(long id);
    Post savePost(Post post);

}
