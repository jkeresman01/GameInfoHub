package com.keresman.dal;

import com.keresman.model.Article;
import java.util.List;
import java.util.Optional;

public interface FavouriteArticleRepostiory {

    void save(Article article) throws Exception;

    void updateById(int id, Article article) throws Exception;

    Optional<Article> findById(int id) throws Exception;

    Optional<Article> findByUserId(int id) throws Exception;

    Optional<Article> findByGameId(int id) throws Exception;

    List<Article> findAll() throws Exception;

    void deleteAll() throws Exception;

}
