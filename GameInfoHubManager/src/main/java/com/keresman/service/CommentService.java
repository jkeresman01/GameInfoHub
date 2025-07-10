package com.keresman.service;

import com.keresman.dal.CommentRepository;
import com.keresman.model.Comment;
import com.keresman.validator.Result;
import java.util.List;

public class CommentService {

  private final CommentRepository commentRepository;

  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public Result<Void> createComment(Comment comment, int userId, int gameId) {
    try {
      commentRepository.save(comment, userId, gameId);
      return Result.success();
    } catch (Exception e) {
      return Result.error("Failed to create comment.");
    }
  }

  public Result<List<Comment>> getCommentsByGameId(int gameId) {
    try {
      List<Comment> comments = commentRepository.findByGameId(gameId);
      return Result.success(comments);
    } catch (Exception e) {
      return Result.error("Failed to fetch comments for Game ID [%d].".formatted(gameId));
    }
  }

  public Result<Void> deleteAllComments() {
    try {
      commentRepository.deleteAll();
      return Result.success();
    } catch (Exception e) {
      return Result.error("Failed to delete all comments.");
    }
  }
}
