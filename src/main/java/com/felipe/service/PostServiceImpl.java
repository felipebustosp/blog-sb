package com.felipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.persistence.Post;
import com.felipe.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> list() {
        return repository.findAll();
    }

    @Override
    public void save(Post post) {
        repository.save(post);
    }

    @Override
    public Post getPostById(Integer id) {
        Optional<Post> optional = repository.findById(id);
        Post post = null;
        if (optional.isPresent()){
            post = optional.get();
        }
        else {
            throw new RuntimeException("Id: "+ id + " does not have an associated post");
        }
        return post;
    }

    @Override
    public void removePost(Integer id) {
        repository.deleteById(id);
        
    }


}
