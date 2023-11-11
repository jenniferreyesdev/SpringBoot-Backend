package com.fintellects.finAPI.controllers;

import com.fintellects.finAPI.entities.Post;
import com.fintellects.finAPI.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/hello")
    public String sayHello() {
        return "Hello, world!";
    }

    @GetMapping("/api/all")
    public List<Post> getAllActivePosts(){
        return this.postService.getAllActivePosts();
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id){
        Post post = this.postService.findPostById(id);
        HttpStatus status;
        ResponseEntity response;

        if(post != null){
            status = HttpStatus.OK;
            response = new ResponseEntity(post,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Post not found",status);
        }

        return response;
    }

    @PostMapping("/api/save")
    public Post postPost(@RequestBody Post post){
        return this.postService.savePost(post);
    }


    @PutMapping("/api/update")
    public ResponseEntity<Post> putPost(@RequestBody Post post){
        Post foundPost = this.postService.findPostById(post.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundPost != null){
            status = HttpStatus.OK;
            this.postService.updatePost(post);
            response = new ResponseEntity(post,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Post not found",status);
        }

        return response;
    }

    @DeleteMapping("/api/delete")
    public ResponseEntity<String> deletePost(@RequestBody Post post){
        Post foundPost = this.postService.findPostById(post.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundPost != null){
            this.postService.deletePost(post);
            status = HttpStatus.OK;
            response = new ResponseEntity("Post successfully deleted",status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Post not found",status);
        }

        return response;
    }


}