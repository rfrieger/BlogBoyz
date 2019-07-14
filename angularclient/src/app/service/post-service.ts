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
    return this.http.get<Post[]>(this.test);
  }

  public save(post: Post) {
    return this.http.post<Post>(this.usersUrl+"posts", post);
  }

  public delete(id): Observable<Post[]>{
    return this.http.delete<Post[]>(this.usersUrl +"posts/"+ id);
  }

  public saveUser(user: User) {
    return this.http.post<User>(this.usersUrl + "users", user)
  }


}
