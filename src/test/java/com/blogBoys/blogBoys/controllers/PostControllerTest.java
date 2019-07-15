package com.blogBoys.blogBoys.controllers;

import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.repos.PostRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class PostControllerTest {

    @Mock
    private PostRepo postRepo;

    @InjectMocks
    private PostController postController;


    @Test
    public void getPostById() {
        when(postController.getPostById(1)).thenReturn(subData().get(1));
        postController.getPostById(1);

        verify(postRepo,times(1)).findById(1);
    }

    @Test
    public void getPostTag() {
        when(postController.getPostTag("OTHER")).thenReturn(subData());
        postController.getPostTag("OTHER");

        verify(postRepo,times(1)).getPostsByTag("OTHER");
    }

    @Test
    public void getPostAll() {
        when(postController.getPostAll()).thenReturn(subData());
        postController.getPostAll();
        verify(postRepo,times(1)).findAll();
    }

    @Test
    public void createPost() {
        Posts post = mockPerson();

        when(postController.createPost(post)).thenReturn(post);
        postController.createPost(post);

        verify(postRepo, times(1)).save(post);
    }


    @Test
    public void updatePost() {
        Posts posts = mockPerson();

        when(postController.updatePost( 1, posts)).thenReturn(posts);
        postController.updatePost( 1,posts);
        verify(postRepo,times(1)).save(posts);

    }

    @Test
    public void deletePost() {
//        when(postController.deletePost(1));
//        postController.deletePost(1);
//
//        verify(postRepo, times(1)).delete(1);
    }


    private List<Posts> subData() {
        Posts post1 = new Posts("stuff", "Rieger", "jnkj",null, "SPORTS");
        Posts post2 = new Posts("morrestuff", "Rieger", "jnkj",null, "OTHER");

        return Arrays.asList(post1, post2);
    }

    private Posts mockPerson () {
        return new Posts("morrestuff", "Rieger", "jnkj",null, "OTHER");
    }
}
