import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Post } from '../post';
import { User } from '../user';

import {Observable} from "rxjs";


@Injectable()
export class PostService {

  private usersUrl: string;
  test : string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/';
  }

  public findAll(): Observable<Post[]> {
    return this.http.get<Post[]>(this.usersUrl+"posts");
  }

  public findByTag(tag : string): Observable<Post[]> {
    this.test = this.usersUrl+"postsByTag/"+tag;
    console.log(this.test)
    return this.http.get<Post[]>(this.test);
  }

  async save(post: Post) {
     const t = this.http.post<Post>(this.usersUrl+"posts", post).toPromise();
     return t;
  }

  async delete(id){
      const t = this.http.delete<Post[]>(this.usersUrl +"posts/"+ id).toPromise();
      return t

  }

  public saveUser(user: User) {
    return this.http.post<User>(this.usersUrl + "users", user)
  }

  public getUser(name:string) {
    return this.http.get<User>(this.usersUrl  + "usersbyname/" + name);
  }


}
