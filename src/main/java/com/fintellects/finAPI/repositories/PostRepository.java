package com.fintellects.finAPI.repositories;

import com.fintellects.finAPI.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
