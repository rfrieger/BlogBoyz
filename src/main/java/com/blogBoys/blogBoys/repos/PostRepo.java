package com.blogBoys.blogBoys.repos;

import com.blogBoys.blogBoys.models.Posts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Posts, Integer> {
//    Posts findAllByContentContains

    Iterable<Posts> getPostsByTag(String tag);
    List<Posts> getAllByContentNotNull ();

}
