package com.blogBoys.blogBoys.services;

import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.models.Users;
import com.blogBoys.blogBoys.repos.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Users create(Users user) {return userRepo.save(user);}

    public void deleteUser(int id) {userRepo.deleteById(id);}

    public Iterable<Users> index() {return userRepo.findAll();}

    public Users getUserById(int id) {return userRepo.findById(id).get();}
}