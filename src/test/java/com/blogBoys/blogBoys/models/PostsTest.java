package com.blogBoys.blogBoys.models;

import org.junit.Assert;
import org.junit.Test;

public class PostsTest {
    Posts posts = new Posts();
    @Test
    public void getPost_id() {
        posts.setPost_id(1);

        Integer actual = 1;
        Integer expected = posts.getPost_id();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setPost_id() {
        posts.setPost_id(1);

        Integer actual = 1;
        Integer expected = posts.getPost_id();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTitle() {
        posts.setTitle("yikes");

        String actual = "yikes";
        String expected = posts.getTitle();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setTitle() {
        posts.setTitle("yikes");

        String actual = "yikes";
        String expected = posts.getTitle();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getContent() {
        posts.setContent("1231241243");

        String actual = "1231241243";
        String expected = posts.getContent();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setContent() {
        posts.setContent("1231241243");

        String actual = "1231241243";
        String expected = posts.getContent();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getImage() {
        posts.setImage("www.test.com");

        String actual = "www.test.com";
        String expected = posts.getImage();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setImage() {
        posts.setImage("www.test.com");

        String actual = "www.test.com";
        String expected = posts.getImage();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getDate() {
        posts.setDate("10/10");

        String actual = "10/10";
        String expected = posts.getDate();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void setDate() {
        posts.setDate("10/10");

        String actual = "10/10";
        String expected = posts.getDate();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getTag() {
        posts.setTag("SPORTS");

        String actual = "SPORTS";
        String expected = posts.getTag();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setTag() {
        posts.setTag("SPORTS");

        String actual = "SPORTS";
        String expected = posts.getTag();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAuthor() {
        posts.setAuthor("bob");

        String actual = "bob";
        String expected = posts.getAuthor();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setAuthor() {
        posts.setAuthor("bob");

        String actual = "bob";
        String expected = posts.getAuthor();

        Assert.assertEquals(expected,actual);
    }
}