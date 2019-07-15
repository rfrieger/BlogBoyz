import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PostService} from "./service/post-service";
import {User} from "./user";
import {log} from "util";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  tempUser:User;
  isSetFields : boolean;
  title = 'BlogBoyz';
  formIsShown = false;
  show = false;
  user : User;
  loginUser : User;

  constructor(private route: ActivatedRoute, private router: Router, private postService: PostService) {
    this.user = new User();
    this.loginUser = new User();
    this.tempUser = new User();
    // this.tempUser.name = "";
    // this.tempUser.password = "";

  }

  authUser(name) {
    this.isSetFields = false;
    this.postService.getUser(name).subscribe( data => {
      this.tempUser.name= data.name;
      this.tempUser.password= data.password;
    });

    console.log(this.loginUser.name, this.loginUser.password,this.tempUser.name, this.tempUser.password);

    if(this.tempUser.name != "" && this.tempUser.password != "") {
      this.isSetFields = true;
    }
    if (this.isSetFields) {
      if (this.tempUser.name === this.loginUser.name && this.tempUser.password === this.loginUser.password) {
        this.changeDisplayPostInput();
      } else alert("Incorrect password!");
    }
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
    console.log("formIsShown");
    this.postService.saveUser(this.user).subscribe( ()=> console.log("success"));
    this.changeDisplayModal()
    // this.updatePost.emit(this.post)

  }
}
