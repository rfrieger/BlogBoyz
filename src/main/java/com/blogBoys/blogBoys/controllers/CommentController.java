package com.blogBoys.blogBoys.controllers;

import com.blogBoys.blogBoys.models.CommentRequest;
import com.blogBoys.blogBoys.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    public CommentService commentService;

    @PostMapping("/comment/{post_id}")
    public void  creatComment(@RequestBody CommentRequest commentRequest, @PathVariable Integer post_id ) {

         this.commentService.createComment(commentRequest , post_id);
    }
}

