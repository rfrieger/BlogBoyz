package com.blogBoys.blogBoys.controllers;

import com.blogBoys.blogBoys.models.Users;
import com.blogBoys.blogBoys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public Users createUser (@RequestBody Users user) {
        return userService.create(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {userService.deleteUser(id);}
    @GetMapping
    public Iterable<Users> getAllUsers() {
        return userService.index();
    }
    @GetMapping("users/{id}")
    public Users getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @GetMapping("usersbyname/{name}")
    public Users getUserByName(@PathVariable String name) {
        return userService.getUserByNP(name);
    }
}