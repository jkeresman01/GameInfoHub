package com.keresman.dal;

import com.keresman.model.Comment;
import java.util.List;

public interface CommentRepostiory {

    int save(Comment comment, int userId, int gameId) throws Exception;

    List<Comment> findByGameId(int gameId) throws Exception;

    void deleteAll() throws Exception;
}
