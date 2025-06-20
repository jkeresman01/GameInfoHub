package com.keresman.dao.sql;

import com.keresman.dal.ArticleRepository;
import com.keresman.mapper.ArticleRowMapper;
import com.keresman.mapper.RowMapper;
import com.keresman.model.Article;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SQLArticleRepository implements ArticleRepository {

    private static final String ARTICLE_ID = "ArticleId";
    private static final String TITLE = "Title";
    private static final String LINK = "Link";
    private static final String DESCRIPTION = "Description";
    private static final String PUB_DATE = "PubDate";
    private static final String PICTURE_PATH = "PicturePath";
    private static final String EXISTS = "Exists";
    private static final String CATEGORY_ID = "CategoryId";
    private static final String GAME_ID = "GameId";
    
    private static final String CREATE_ARTICLE = "{ CALL uspCreateArticle (?,?,?,?,?,?) }";
    private static final String UPDATE_ARTICLE = "{ CALL uspUpdateArticleWithId (?,?,?,?,?,?) }";
    private static final String DELETE_ARTICLE = "{ CALL uspDeleteArticleWithId (?) }";

    private static final String SELECT_BY_ID = "{ CALL uspSelectArticleWithId (?) }";
    private static final String SELECT_ALL = "{ CALL uspSelectAllArticles }";
    private static final String SELECT_BY_TITLE = "{ CALL uspSelectArticlesByTitle (?) }";
    private static final String SELECT_BY_CATEGORY = "{ CALL uspSelectArticlesByCategoryName (?) }";
    private static final String SELECT_BY_GAME = "{ CALL uspSelectArticlesByGameId (?) }";
    private static final String EXISTS_BY_LINK = "{ CALL uspExistsArticleWithLink (?, ?) }";

    private static final String ADD_CATEGORY = "{ CALL uspAddCategoryToArticle (?, ?) }";
    private static final String REMOVE_CATEGORY = "{ CALL uspRemoveCategoryFromArticle (?, ?) }";
    private static final String ADD_GAME = "{ CALL uspAddGameToArticle (?, ?) }";
    private static final String REMOVE_GAME = "{ CALL uspRemoveGameFromArticle (?, ?) }";

    private final RowMapper<Article> articleRowMapper = new ArticleRowMapper();

    @Override
    public int save(Article article) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            stmt.setString(TITLE, article.getTitle());
            stmt.setString(LINK, article.getLink());
            stmt.setString(DESCRIPTION, article.getDescription());
            stmt.setObject(PUB_DATE, article.getPublishedDateTime());
            stmt.setString(PICTURE_PATH, article.getPicturePath());
            stmt.registerOutParameter(ARTICLE_ID, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(ARTICLE_ID);
        }
    }

    @Override
    public void saveAll(List<Article> articles) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_ARTICLE)) {

            for (Article article : articles) {
                stmt.setString(TITLE, article.getTitle());
                stmt.setString(LINK, article.getLink());
                stmt.setString(DESCRIPTION, article.getDescription());
                stmt.setObject(PUB_DATE, article.getPublishedDateTime());
                stmt.setString(PICTURE_PATH, article.getPicturePath());
                stmt.registerOutParameter(ARTICLE_ID, Types.INTEGER);

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void updateById(int id, Article article) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_ARTICLE)) {

            stmt.setInt(ARTICLE_ID, id);
            stmt.setString(TITLE, article.getTitle());
            stmt.setString(LINK, article.getLink());
            stmt.setString(DESCRIPTION, article.getDescription());
            stmt.setObject(PUB_DATE, article.getPublishedDateTime());
            stmt.setString(PICTURE_PATH, article.getPicturePath());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ARTICLE)) {
            stmt.setInt(ARTICLE_ID, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Article> findById(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_ID)) {

            stmt.setInt(ARTICLE_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(articleRowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Article> findAll() throws Exception {
        List<Article> articles = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                articles.add(articleRowMapper.map(rs));
            }
        }
        return articles;
    }

    @Override
    public List<Article> findByTitle(String title) throws Exception {
        List<Article> articles = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_TITLE)) {

            stmt.setString(TITLE, title);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    articles.add(articleRowMapper.map(rs));
                }
            }
        }
        return articles;
    }

    @Override
    public List<Article> findByCategoryName(String categoryName) throws Exception {
        List<Article> articles = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_CATEGORY)) {

            stmt.setString("CategoryName", categoryName);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    articles.add(articleRowMapper.map(rs));
                }
            }
        }
        return articles;
    }

    @Override
    public List<Article> findByGameId(int gameId) throws Exception {
        List<Article> articles = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_GAME)) {

            stmt.setInt(GAME_ID, gameId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    articles.add(articleRowMapper.map(rs));
                }
            }
        }
        return articles;
    }

    @Override
    public boolean existsByLink(String link) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(EXISTS_BY_LINK)) {

            stmt.setString(LINK, link);
            stmt.registerOutParameter(EXISTS, Types.BIT);
            stmt.execute();
            return stmt.getBoolean(EXISTS);
        }
    }

    @Override
    public void addCategoryToArticle(int articleId, int categoryId) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(ADD_CATEGORY)) {

            stmt.setInt(ARTICLE_ID, articleId);
            stmt.setInt(CATEGORY_ID, categoryId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void removeCategoryFromArticle(int articleId, int categoryId) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(REMOVE_CATEGORY)) {

            stmt.setInt(ARTICLE_ID, articleId);
            stmt.setInt(CATEGORY_ID, categoryId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void addGameToArticle(int articleId, int gameId) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(ADD_GAME)) {

            stmt.setInt(ARTICLE_ID, articleId);
            stmt.setInt(GAME_ID, gameId);
            stmt.executeUpdate();
        }
    }

    @Override
    public void removeGameFromArticle(int articleId, int gameId) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(REMOVE_GAME)) {

            stmt.setInt(ARTICLE_ID, articleId);
            stmt.setInt(GAME_ID, gameId);
            stmt.executeUpdate();
        }
    }

}
