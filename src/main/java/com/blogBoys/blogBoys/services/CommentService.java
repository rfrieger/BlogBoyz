package com.blogBoys.blogBoys.services;

import com.blogBoys.blogBoys.models.Comment;
import com.blogBoys.blogBoys.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    public CommentRepo commentRepo;

    public Comment createComment(Comment comment) {
        return this.commentRepo.save(comment);
    }
}
