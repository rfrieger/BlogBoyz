package com.blogBoys.blogBoys.services;

import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.repos.PostRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostRepo postRepo ;

    @InjectMocks
    private  PostService postService;

    @Test
    public void postsByTag() {
        when(postService.PostsByTag("SPORTS")).thenReturn(subData());
        postService.PostsByTag("SPORTS");

        verify(postRepo, times(1)).getPostsByTag("SPORTS");
    }

    @Test
    public void getPost() {
        when(postService.getPost(1)).thenReturn(subData().get(1));
        postService.getPost(1);

        verify(postRepo,times(1)).findById(1);
    }

    @Test
    public void index() {
        when(postService.index()).thenReturn(subData());
        postService.index();

        verify(postRepo,times(1)).findAll();
    }

    @Test
    public void create() {
        Posts post = mockPerson();

        when(postService.create(post)).thenReturn(post);
        postService.create(post);

        verify(postRepo, times(1)).save(post);
    }

    @Test
    public void update() {
        Posts posts = mockPerson();
        when(postService.update( posts)).thenReturn(posts);
        postService.update( posts);
        verify(postRepo,times(1)).save(posts);

    }

    @Test
    public void deletePost() {
        postService.deletePost(1);
        verify(postRepo, times(1)).deleteById(1);
    }



    private List<Posts> subData() {
        Posts post1 = new Posts("stuff", "Rieger", "jnkj", null, "SPORTS", 1);
        Posts post2 = new Posts("morrestuff", "Rieger", "jnkj", null, "OTHER",1);

        return Arrays.asList(post1, post2);
    }

    private Posts mockPerson() {
        return new Posts("morrestuff", "Rieger", "jnkj", null, "OTHER",1);
    }
}