package com.fintellects.finAPI.services;


import com.fintellects.finAPI.entities.Post;
import com.fintellects.finAPI.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;

    public PostService(PostRepository postRepository){

        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {

        return this.postRepository.findAll();
    }

    //Cannot resolve method 'isActive' in 'Post'
    public  List<Post> getAllActivePosts(){
        return this.postRepository.findAll()
                .stream()
                .filter(d->d.isActive()).collect(Collectors.toList());
    }

    public Post findPostById(Integer id) {
        return this.postRepository.findById(id).orElse(null);
    }

    public Post savePost(Post post){
        return this.postRepository.save(post);
    }

    public Post updatePost(Post post) {
        return this.postRepository.save(post);
    }

    //Cannot resolve method 'setActive' in 'Post'
    public void deletePost(Post post) {
        post.setActive(false);
        this.postRepository.save(post);
    }
}
