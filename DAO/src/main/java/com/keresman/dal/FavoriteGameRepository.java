package com.keresman.dal;

import com.keresman.model.Game;
import java.util.List;
import java.util.Optional;

public interface FavoriteGameRepository {

    void save(Game game) throws Exception;

    void updateById(int id, Game game) throws Exception;

    Optional<Game> findById(int id) throws Exception;

    Optional<Game> findByUserId(int id) throws Exception;
    
    Optional<Game> findByGameId(int id) throws Exception;

    List<Game> findAll() throws Exception;
}
