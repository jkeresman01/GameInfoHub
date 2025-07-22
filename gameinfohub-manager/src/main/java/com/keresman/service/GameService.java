package com.keresman.service;

import com.keresman.dal.GameRepository;
import com.keresman.model.Game;
import com.keresman.validator.Result;
import java.util.List;

public class GameService {

  private final GameRepository gameRepository;

  public GameService(GameRepository gameRepostitory) {
    this.gameRepository = gameRepostitory;
  }

  public Result<List<Game>> getAllGames() {
    try {
      List<Game> games = gameRepository.findAll();
      return Result.success(games);
    } catch (Exception e) {
      return Result.error("Failed to fetch users.");
    }
  }
}
