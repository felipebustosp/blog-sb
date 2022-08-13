package com.felipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.felipe.repository.UserRepository;
import com.felipe.service.UserServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.felipe.persistence.User;
//import java.util.List;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserServiceImpl service;

    @GetMapping(value = "/users")
    public String mainPage(Model model) {
        model.addAttribute("allUsers", service.list());
        return "user/users";
    }

    @GetMapping(value = "/users/{id}")
    public Optional<User> show(@PathVariable(value = "id") String id) {
        Integer user_id = Integer.parseInt(id);
        return repository.findById(user_id);
    }

    @GetMapping("/user/new")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/new";
    }

    @GetMapping("/user/update/{id}")
    public String updateUser(@PathVariable(value = "id") Integer id, Model model){
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "user/update"; 
    }

    @GetMapping("/user/delete/{id}")
    public String deleteById(@PathVariable(value = "id") Integer id){
        service.removeUser(id);
        return "redirect:/";
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute ("user") User user){
        repository.save(user);
        return "redirect:/";
    }



}
