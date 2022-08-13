package com.felipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.felipe.persistence.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{
}
