package com.keresman.dal;

import com.keresman.model.Article;
import com.keresman.model.User;
import java.util.List;

public interface FavouriteArticleRepostiory {

    void save(Article article, User user) throws Exception;

    List<Article> findByUserId(int id) throws Exception;

    List<Article> findByGameId(int id) throws Exception;

    List<Article> findAll() throws Exception;

    void deleteAll() throws Exception;
}
