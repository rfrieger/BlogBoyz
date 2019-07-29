package com.blogBoys.blogBoys.controllers;

import com.blogBoys.blogBoys.models.Comment;
import com.blogBoys.blogBoys.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    public CommentService commentService;



    @PostMapping("/comment")
    public Comment creatComment(@RequestBody Comment comment) {
        System.out.println("testasfas");
        return this.commentService.createComment(comment);
    }
}

