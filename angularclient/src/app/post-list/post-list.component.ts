import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import {PostService} from '../service/post-service';
import {post} from "selenium-webdriver/http";

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  posts: Post[];

  constructor(private postService: PostService ) {
  }

  ngOnInit() {
    this.postService.findAll().subscribe(data => {
      this.posts = data;
    });
  }

  deletePost(id) {
    this.postService.delete(id).subscribe(data => {
      console.log("success")
    })
  };

  getPostByTag(tag){
    this.postService.findByTag(tag).subscribe(data => {
      this.posts = data;
    })
     console.log(this.posts)
  }

  // updatePostList(postsToAdd: Post){
  //   this.postService.findAll().subscribe(data => {
  //     this.posts = data;
  //     this.posts.push(postsToAdd)
  //   });  }
}
