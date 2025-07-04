package com.keresman.dal;

public interface FavouriteArticleRepostiory {
    
    void save(Game game) throws Exception;

    void updateById(int id, Game game) throws Exception;

    Optional<Game> findById(int id) throws Exception;

    Optional<Game> findByUserId(int id) throws Exception;
    
    Optional<Game> findByGameId(int id) throws Exception;

    List<Game> findAll() throws Exception;
}
