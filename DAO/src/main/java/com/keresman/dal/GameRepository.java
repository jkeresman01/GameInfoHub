package com.keresman.dal;

import com.keresman.model.Game;
import java.util.List;
import java.util.Optional;

public interface GameRepository {

    int save(Game game) throws Exception;
    
    void saveAll(List<Game> games) throws Exception;

    void updateById(int id, Game game) throws Exception;

    void deleteById(int id) throws Exception;

    Optional<Game> findById(int id) throws Exception;

    List<Game> findAll() throws Exception;

    List<Game> findByPlatformId(int platformId) throws Exception;

    List<Game> findByGenreId(int genreId) throws Exception;

    void deleteAll() throws Exception;
}
