package com.keresman.dao;

import com.keresman.model.Article;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

  int save(Article review) throws Exception;

  void updateById(int id, Article review) throws Exception;

  void deleteById(int id) throws Exception;

  Optional<Article> findById(int id) throws Exception;

  List<Article> findByGameId(int gameId) throws Exception;

  List<Article> findAll() throws Exception;
}
