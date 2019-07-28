package com.blogBoys.blogBoys.repos;

import com.blogBoys.blogBoys.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer> {
}
