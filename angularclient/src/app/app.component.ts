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
  isSetFields : boolean;
  formIsShown = false;
  togglePost = false;
  showCreateUserModal = false;
  showSignInModal= false;
  passLogin = false;
  userLoggedInFlag = false;
  user : User;
  loginUser : User;
  tempUser:User;


  constructor(private route: ActivatedRoute, private router: Router, private postService: PostService) {
    this.user = new User();
    this.loginUser = new User();
    this.tempUser = new User();
  }

  ///////////MOVE TO BACK END vv ////////////

  async authUser(name) {
    this.isSetFields = false;
    this.postService.getUser(name).subscribe( data => {

      console.log("--"+data.name)
      console.log("--"+data.password)
      this.tempUser.name= data.name;
      this.tempUser.password= data.password;
    });

    this.sleep(500).then(() => {

      console.log(this.loginUser.name, this.loginUser.password, this.tempUser.name, this.tempUser.password);

      if (this.tempUser.name != "" && this.tempUser.password != "") {
        this.isSetFields = true;
      }
      if (this.isSetFields) {
        if (this.tempUser.name === this.loginUser.name && this.tempUser.password === this.loginUser.password) {
          // this.changeDisplayPostInput();
          this.changeDisplayLoginModal();
          this.userLoggedInFlag = true;
          // this.passLogin = true;
          alert("login Successful")
        } else alert("Incorrect password!");
      }
    })
  }

////////////////////// ^^TO THE BACK ////////////////////////

  changeDisplayPostInput() {
    if (this.formIsShown ===false){
      this.formIsShown = true;}
    else this.formIsShown = false;
    window.scrollTo(0, 0)
  }

  changeDisplayPostbtn() {

    if (this.togglePost ===false){
      this.togglePost = true;}
    else this.togglePost = false;
  }

  changeDisplayCreateUserModal() {
    if (this.showCreateUserModal ===false){
      this.showCreateUserModal = true;}
    else this.showCreateUserModal = false;
  }

  changeDisplayLoginModal() {
    if (this.showSignInModal ===false){
      this.showSignInModal = true;}
    else this.showSignInModal = false;
  }

  createUser() {
    console.log("formIsShown");
    this.postService.saveUser(this.user).subscribe( ()=> console.log("success"));
    this.changeDisplayCreateUserModal()
  }

   sleep = function(time) {
    return new Promise(resolve => {setTimeout(resolve,time)})
   }


}
