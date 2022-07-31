package com.felipe.service;

import java.util.List;

import com.felipe.persistence.User;

public interface UserService {
    
    public List<User> list();
    public void save(User user);
    public User getUserById(Integer id);
    public void removeUser(Integer id);
}
