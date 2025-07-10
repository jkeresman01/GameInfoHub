package com.keresman.dal;

import com.keresman.model.Game;
import com.keresman.model.User;
import java.util.List;

public interface FavoriteGamesRepository {

  void save(Game game, User user) throws Exception;

  List<Game> findByUserId(int id) throws Exception;

  List<Game> findByGameId(int id) throws Exception;

  List<Game> findAll() throws Exception;

  void deleteAll() throws Exception;
}
