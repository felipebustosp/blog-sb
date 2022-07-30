package com.felipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.felipe.persistence.User;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/")
    public String mainPage() {
        return "Welcome!";
    }


    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public Optional<User> show(@PathVariable(value = "id") String id) {
        Integer user_id = Integer.parseInt(id);
        return repository.findById(user_id);
    }


}
