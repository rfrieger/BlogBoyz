package com.blogBoys.blogBoys.services;

import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class PostService {

    private PostRepo postRepo;

    List<Posts> postsList;
    Comparator<Posts> compareById = Comparator.comparing(Posts::getPost_id); //to post to top


    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public Iterable<Posts> PostsByTag(String tag) {return postRepo.getPostsByTag(tag);}

    public Posts getPost (Integer id) {return postRepo.findById(id).get();}

    public List<Posts> index() {
        postsList = postRepo.getAllByContentNotNull();
        Collections.sort( postsList , compareById.reversed());
        return postsList;
    }

    public Posts create(Posts posts) {return postRepo.save(posts);}

    public Posts update(Posts posts) {return postRepo.save(posts);}

    public void deletePost(Integer id) { postRepo.deleteById(id);}



}
