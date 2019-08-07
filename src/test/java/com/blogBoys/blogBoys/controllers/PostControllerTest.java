package com.blogBoys.blogBoys.controllers;

import com.blogBoys.blogBoys.models.Posts;
import com.blogBoys.blogBoys.services.PostService;
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
    private PostService postService;

    @InjectMocks
    private PostController postController;


    @Test
    public void getPostById() {
        when(postService.getPost(1)).thenReturn(stubData().get(1));
        postController.getPostById(1);

        verify(postService, times(1)).getPost(1);
    }

    @Test
    public void getPostTag() {
        when(postService.PostsByTag("OTHER")).thenReturn(stubData());
        postController.getPostTag("OTHER");

        verify(postService,times(1)).PostsByTag("OTHER");
    }

    @Test
    public void getPostAll() {
        when(postService.index()).thenReturn(stubData());
        postController.getPostAll();
        verify(postService,times(1)).index();
    }

    @Test
    public void createPost() {
        Posts post = mockPerson();

        when(postService.create(post)).thenReturn(post);
        postController.createPost(post);

        verify(postService, times(1)).create(post);
    }


    @Test
    public void deletePost() {

       postController.deletePost(1);
        verify(postService, times(1)).deletePost(1);
    }


    private List<Posts> stubData() {
        Posts post1 = new Posts("stuff", "Rieger", "jnkj",null, "SPORTS","");
        Posts post2 = new Posts("morrestuff", "Rieger", "jnkj",null, "OTHER","");

        return Arrays.asList(post1, post2);
    }

    private Posts mockPerson () {
        return new Posts("morrestuff", "Rieger", "jnkj",null, "OTHER","");
    }
}
