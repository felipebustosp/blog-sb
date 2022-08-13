package com.felipe.service;

import java.util.List;

import com.felipe.persistence.Post;

public interface PostService {
    public List<Post> list();
    public void save(Post post);
    public Post getPostById(Integer id);
    public void removePost(Integer id);
}
