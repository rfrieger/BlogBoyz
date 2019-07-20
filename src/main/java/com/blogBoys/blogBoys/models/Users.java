package com.blogBoys.blogBoys.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer user_id;
    String name;
    String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Posts> posts = new ArrayList<>();


    public Users() {
    }

    public Users(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Posts> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Posts> posts) {
//        this.posts = posts;
//    }

}