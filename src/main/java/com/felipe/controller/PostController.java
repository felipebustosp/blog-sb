package com.felipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.felipe.repository.PostRepository;
import com.felipe.service.PostServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.felipe.persistence.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class PostController {

    @Autowired
    private PostRepository repository;

    @Autowired
    private PostServiceImpl service;

    @GetMapping(value = "/posts")
    public String mainPage(Model model) {
        model.addAttribute("allPosts", service.list());
        return "post/posts";
    }

    @GetMapping(value = "/post/{id}")
    public Optional<Post> show(@PathVariable(value = "id") String id) {
        Integer postId = Integer.parseInt(id);
        return repository.findById(postId);
    }

    @GetMapping("/post/new")
    public String addNewPost(Model model){
        Post Post = new Post();
        model.addAttribute("post", Post);
        return "post/new";
    }

    @GetMapping("/post/update/{id}")
    public String updatePost(@PathVariable(value = "id") Integer id, Model model){
        Post Post = service.getPostById(id);
        model.addAttribute("post", Post);
        return "post/update"; 
    }

    @GetMapping("/post/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id){
        service.removePost(id);
        return "redirect:/";
    }

    @PostMapping("/post/save")
    public String savePost(@ModelAttribute ("post") Post Post){
        repository.save(Post);
        return "redirect:/";
    }

    @RequestMapping(value = "/populatedAuthorsDropDownList", method = RequestMethod.GET)
    public String populateAuthors(Model model){
        List<String> names = new ArrayList<String>();
        names.add("Juan Perez");
        model.addAttribute("authorNames", names);
        return "authorsDropDownList/populatedAuthorsDropDownList.html";
    }



}
