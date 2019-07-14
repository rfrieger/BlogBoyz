import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "./service/post-service";
import {User} from "./user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BlogBoyz';
  formIsShown = false
  show = false;
  user : User;

  constructor(private route: ActivatedRoute, private router: Router, private postService: PostService) {
    this.user = new User()
  }

  changeDisplayPostInput() {
    if (this.formIsShown ===false){
      this.formIsShown = true;}
    else this.formIsShown = false;
  }

  changeDisplayModal() {
    if (this.show ===false){
    this.show = true;}
    else this.show = false;
  }

  createUser() {
    console.log("formIsShown")
    this.postService.saveUser(this.user).subscribe( ()=> console.log("success"));
    // this.updatePost.emit(this.post)

  }
}






