package com.spring.codejourney.service.serviceImpl;

import com.spring.codejourney.model.Post;
import com.spring.codejourney.repository.PostRepository;
import com.spring.codejourney.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
