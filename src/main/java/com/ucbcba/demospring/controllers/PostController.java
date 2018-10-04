package com.ucbcba.demospring.controllers;

import com.ucbcba.demospring.entities.Post;
import com.ucbcba.demospring.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PostController {

    PostService postService;


    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String index( Model model) {
        List<Post> posts  = (List) postService.listAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable Integer id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "postsshow";
    }
    @RequestMapping(value = "/post/new")
    public String newPost( Model model) {
        return "PostForm";
    }
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String create(@ModelAttribute ("post") Post post, Model model) {
        postService.savePost(post);
        return "redirect:/posts";
    }
    @RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "editPost";
    }
    @RequestMapping(value="/post/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id,Model model) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

}
