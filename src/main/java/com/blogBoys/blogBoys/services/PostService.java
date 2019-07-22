package com.blogBoys.blogBoys.services;

import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    private PostRepo postRepo;

    @Autowired
    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Iterable<Posts> PostsByTag(String tag) {return postRepo.getPostsByTag(tag);}

    public Posts getPost (Integer id) {return postRepo.findById(id).get();}

    public Iterable<Posts> index() {
        return postRepo.getAllByContentNotNullOrderByDateDesc();
    }

    public Posts create(Posts posts) {return postRepo.save(posts);}

    public Posts update(Posts posts) {return postRepo.save(posts);}

    public void deletePost(Integer id) { postRepo.deleteById(id);}





}
