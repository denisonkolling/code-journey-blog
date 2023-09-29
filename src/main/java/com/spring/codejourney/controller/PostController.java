package com.spring.codejourney.controller;

import com.spring.codejourney.model.Post;
import com.spring.codejourney.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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

    @RequestMapping(value="/newpost", method=RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }

    @RequestMapping(value="/newpost", method= RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }

        post.setData(LocalDate.now());
        postService.savePost(post);
        return "redirect:/posts";

    }
}


