package com.blogBoys.blogBoys.controllers;

import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    PostService postService;

    public PostController(PostService postService) { this.postService = postService;
    }

    @GetMapping("/posts/{id}")
    public Posts getPostById(@PathVariable Integer id) { return this.postService.getPost(id);}


    @GetMapping("/postsByTag/{tag}")
    public List<Posts> getPostTag(@PathVariable String tag) {return this.postService.PostsByTag(tag);}


    @GetMapping("/posts")
    public List<Posts> getPostAll() { return this.postService.index(); }


    @PostMapping("/posts")
    public Posts createPost(@RequestBody Posts posts) {
        return postService.create(posts);
    }


    @PutMapping("/posts/{id}")
    public Posts updatePost(@PathVariable Integer id, @RequestBody Posts posts) {
        Posts newPost = getPostById(id);
        newPost.setTitle(posts.getTitle());
        newPost.setContent(posts.getContent());
        return this.postService.update(newPost);
    }

    @DeleteMapping("posts/{id}")
    public void deletePost(@PathVariable Integer id) {postService.deletePost(id);}
}
