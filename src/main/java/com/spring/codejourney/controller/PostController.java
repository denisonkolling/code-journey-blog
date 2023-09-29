package com.spring.codejourney.controller;

import com.spring.codejourney.model.Post;
import com.spring.codejourney.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    @RequestMapping("/posts")
    public ModelAndView getPosts() {
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> posts = postService.findAllPost();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping
    @RequestMapping("/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("postDetails");
        Post post = postService.findPostById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @GetMapping
    @RequestMapping("/newpost")
    public String getPostForm() {
        return "postForm";
    }

}
