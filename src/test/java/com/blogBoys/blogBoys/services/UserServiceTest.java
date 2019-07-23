package com.blogBoys.blogBoys.services;

import com.blogBoys.blogBoys.controllers.UserController;
import com.blogBoys.blogBoys.models.Users;
import com.blogBoys.blogBoys.repos.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @Test
    public void create() {
        Users user = mockPerson();

        when(userRepo.save(user)).thenReturn(user);
        userService.create(user);

        verify(userRepo, times(1)).save(user);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(1);
        verify(userRepo, times(1)).deleteById(1);
    }

    @Test
    public void getUserById() {
////        when(userRepo.findById(0)).thenReturn(subData().get(0));
//        userService.getUserById(0);
//
//        verify(userRepo,times(1)).findById(0);
    }

    @Test
    public void getUserByNP() {
    }

    private List<Users> subData() {
        Users person1 = new Users("Bob", "1234");
        Users person2 = new Users("steve", "1234");

        return Arrays.asList(person1, person2);
    }

    private Users mockPerson() {
        return new Users("steve", "1234");
    }
}