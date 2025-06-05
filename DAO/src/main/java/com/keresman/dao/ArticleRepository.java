package com.keresman.dao;

import com.keresman.model.Article;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    int save(Article article) throws Exception;

    void updateById(int id, Article updated) throws Exception;

    void deleteById(int id) throws Exception;

    Optional<Article> findById(int id) throws Exception;

    List<Article> findAll() throws Exception;

    List<Article> findByTitle(String title) throws Exception;

    List<Article> findByCategoryName(String categoryName) throws Exception;

    List<Article> findByGameId(int gameId) throws Exception;

    boolean existsByLink(String link) throws Exception;

    void addCategoryToArticle(int articleId, int categoryId) throws Exception;

    void removeCategoryFromArticle(int articleId, int categoryId) throws Exception;

    void addGameToArticle(int articleId, int gameId) throws Exception;

    void removeGameFromArticle(int articleId, int gameId) throws Exception;
}
