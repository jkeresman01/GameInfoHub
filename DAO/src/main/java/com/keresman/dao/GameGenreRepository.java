package com.keresman.dao;

import com.keresman.model.Game;
import com.keresman.model.Genre;
import java.util.List;

public interface GameGenreRepository {

    void save(int gameId, int genreId) throws Exception;

    void delete(int gameId, int genreId) throws Exception;

    List<Genre> findGenresByGameId(int gameId) throws Exception;

    List<Game> findGamesByGenreId(int genreId) throws Exception;
}
