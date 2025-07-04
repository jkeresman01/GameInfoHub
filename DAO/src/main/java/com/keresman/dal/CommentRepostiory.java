package com.keresman.dal;

import com.keresman.model.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentRepostiory {

    void save(Comment comment) throws Exception;

    void updateById(int id, Comment comment) throws Exception;

    Optional<Comment> findById() throws Exception;

    List<Comment> findAll() throws Exception;
}
