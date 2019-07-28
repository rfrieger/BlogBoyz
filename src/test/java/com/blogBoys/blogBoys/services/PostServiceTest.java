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
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostRepo postRepo ;

    @InjectMocks
    private  PostService postService;

    @Test
    public void postsByTag() {
        when(postRepo.getPostsByTag("SPORTS")).thenReturn(stubData());
        postService.PostsByTag("SPORTS");

        verify(postRepo, times(1)).getPostsByTag("SPORTS");
    }

    @Test
    public void getPost() {
        when(postRepo.findById(0)).thenReturn(Optional.of(stubData().get(0)));
        postService.getPost(0);
        verify(postRepo,times(1)).findById(0);
//
    }

    @Test
    public void index() {
//        List<Posts> list = stubData();
        when(postRepo.getAllByContentNotNull()).thenReturn(stubData());
        postService.index();

        verify(postRepo,times(1)).getAllByContentNotNull();
    }

    @Test
    public void create() {
        Posts post = mockPerson();

        when(postRepo.save(post)).thenReturn(post);
        postService.create(post);
        verify(postRepo, times(1)).save(post);

    }

    @Test
    public void update() {
        Posts posts = mockPerson();
        when(postRepo.save( posts)).thenReturn(posts);
        postService.update( posts);
        verify(postRepo,times(1)).save(posts);

    }

    @Test
    public void deletePost() {
        postService.deletePost(1);
        verify(postRepo, times(1)).deleteById(1);
    }



    private List<Posts> stubData() {
        Posts post1 = new Posts("stuff", "Rieger", "jnkj", null, "SPORTS","");
        Posts post2 = new Posts("morrestuff", "Rieger", "jnkj", null, "OTHER","");

        return Arrays.asList(post1, post2);
    }

    private Posts mockPerson() {
        return new Posts("morrestuff", "Rieger", "jnkj", null, "OTHER","");
    }
}