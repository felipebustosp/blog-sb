package com.felipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.persistence.User;
import com.felipe.repository.UserRepository;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository repository;

    public List<User> list(){
        return repository.findAll();
    } 

    public void save(User user){
        repository.save(user);
    }

    public User getUserById(Integer id){
        Optional<User> optional = repository.findById(id);
        User user = null;
        if (optional.isPresent()){
            user = optional.get();
        }
        else {
            throw new RuntimeException("Id: "+ id +" does not have an associated user.");
        }
        return user;
    }
    public void removeUser(Integer id){
        repository.deleteById(id);
    }
}