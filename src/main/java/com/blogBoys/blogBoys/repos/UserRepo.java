package com.blogBoys.blogBoys.repos;

import com.blogBoys.blogBoys.models.Users;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {
    Users findByName(String name);


}