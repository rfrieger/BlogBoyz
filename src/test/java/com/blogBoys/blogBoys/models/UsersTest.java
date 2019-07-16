package com.blogBoys.blogBoys.models;

import com.blogBoys.blogBoys.services.UserService;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    Users users = new Users();

    @Test
    public void getUser_id() {
        users.setUser_id(1);

        int actual = 1;
        int expected = users.getUser_id();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setUser_id() {
        users.setUser_id(1);

        int actual = 1;
        int expected = users.getUser_id();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getName() {
        users.setName("bob");

        String actual = "bob";
        String expected = users.getName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setName() {
        users.setName("bob");

        String actual = "bob";
        String expected = users.getName();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getPassword() {
        users.setPassword("123");

        String actual = "123";
        String expected = users.getPassword();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setPassword() {
        users.setPassword("123");

        String actual = "123";
        String expected = users.getPassword();

        Assert.assertEquals(expected,actual);
    }
}