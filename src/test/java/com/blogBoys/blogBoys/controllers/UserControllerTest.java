package com.blogBoys.blogBoys.controllers;

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
public class UserControllerTest {


        @Mock
        private UserRepo userRepo;

        @InjectMocks
        private UserController userController;

        @Test
        public void createUser() {
        Users user = mockPerson();

        when(userController.createUser(user)).thenReturn(user);
        userController.createUser(user);

        verify(userRepo, times(1)).save(user);
        }


        @Test
        public void deleteUser() {
//        when(userController.deleteById(1));
//        userController.deleteById(1);
//
//        verify(userRepo, times(1)).deleteById(1);

        }

        @Test
        public void getAllUsers() {
        when(userController.getAllUsers()).thenReturn(subData());
        userController.getAllUsers();
        verify(userRepo,times(1)).findAll();

        }

        @Test
        public void getUser() {

        when(userController.getUser(1)).thenReturn(subData().get(1));
        userController.getUser(1);

        verify(userRepo,times(1)).findById(1);
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
