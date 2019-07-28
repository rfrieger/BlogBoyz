package com.blogBoys.blogBoys.repos;

import com.blogBoys.blogBoys.models.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Posts, Integer> {

    List<Posts> getPostsByTag(String tag);

//    Iterable<Posts> getAllByContentNotNullOrderByDateDesc();

    List<Posts> getAllByContentNotNull();

}
