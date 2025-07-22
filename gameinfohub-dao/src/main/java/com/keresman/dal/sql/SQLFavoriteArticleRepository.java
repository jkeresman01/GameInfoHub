package com.keresman.dal.sql;

import com.keresman.dal.FavouriteArticleRepostiory;
import com.keresman.mapper.ArticleRowMapper;
import com.keresman.mapper.RowMapper;
import com.keresman.model.Article;
import com.keresman.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SQLFavoriteArticleRepository implements FavouriteArticleRepostiory {

  private static final String USER_ID = "UserId";
  private static final String ARTICLE_ID = "ArticleId";
  private static final String GAME_ID = "GameId";

  private static final String INSERT_FAV_ARTICLE = "{ CALL uspInsertFavouriteArticle(?, ?) }";
  private static final String SELECT_BY_USER_ID = "{ CALL uspSelectFavouriteArticlesByUserId(?) }";
  private static final String SELECT_BY_GAME_ID = "{ CALL uspSelectFavouriteArticlesByGameId(?) }";
  private static final String SELECT_ALL = "{ CALL uspSelectAllFavouriteArticles }";
  private static final String DELETE_ALL = "{ CALL uspDeleteAllFavouriteArticles }";

  private final RowMapper<Article> articleRowMapper = new ArticleRowMapper();

  @Override
  public void save(Article article, User user) throws Exception {
    try (Connection con = DataSourceSingleton.getInstance().getConnection();
        CallableStatement stmt = con.prepareCall(INSERT_FAV_ARTICLE)) {

      stmt.setInt(USER_ID, user.getId());
      stmt.setInt(ARTICLE_ID, article.getArticleId());
      stmt.executeUpdate();
    }
  }

  @Override
  public List<Article> findByUserId(int id) throws Exception {
    List<Article> articles = new ArrayList<>();
    try (Connection con = DataSourceSingleton.getInstance().getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_BY_USER_ID)) {

      stmt.setInt(USER_ID, id);
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          articles.add(articleRowMapper.map(rs));
        }
      }
    }
    return articles;
  }

  @Override
  public List<Article> findByGameId(int id) throws Exception {
    List<Article> articles = new ArrayList<>();
    try (Connection con = DataSourceSingleton.getInstance().getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_BY_GAME_ID)) {

      stmt.setInt(GAME_ID, id);
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          articles.add(articleRowMapper.map(rs));
        }
      }
    }
    return articles;
  }

  @Override
  public List<Article> findAll() throws Exception {
    List<Article> articles = new ArrayList<>();
    try (Connection con = DataSourceSingleton.getInstance().getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_ALL);
        ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        articles.add(articleRowMapper.map(rs));
      }
    }
    return articles;
  }

  @Override
  public void deleteAll() throws Exception {
    try (Connection con = DataSourceSingleton.getInstance().getConnection();
        CallableStatement stmt = con.prepareCall(DELETE_ALL)) {

      stmt.executeUpdate();
    }
  }
}
