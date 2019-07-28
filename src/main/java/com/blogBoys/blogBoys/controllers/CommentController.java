package com.blogBoys.blogBoys.controllers;

import com.blogBoys.blogBoys.models.Comment;
import com.blogBoys.blogBoys.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    public CommentService commentService;



    @PostMapping("/comment")
    public Comment creatComment(Comment comment) {
        return this.commentService.createComment(comment);
    }
}

