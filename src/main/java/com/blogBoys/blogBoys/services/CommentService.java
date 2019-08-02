package com.blogBoys.blogBoys.services;

import com.blogBoys.blogBoys.models.Comment;
import com.blogBoys.blogBoys.models.CommentRequest;
import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    public CommentRepo commentRepo;
    @Autowired
    public PostService postService;

    public void createComment(CommentRequest requestComment, Integer post_id) {

        Posts post = postService.getPost(post_id);

        Comment comment = new Comment();
        comment.setContent(requestComment.getContent());
        comment.setCommment_Id(requestComment.getCommment_Id());
        comment.setPosts(post);
        System.out.println(requestComment.getAuthor());
        comment.setAuthor(requestComment.getAuthor());


        this.commentRepo.save(comment);

    }
}
