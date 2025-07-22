package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.CategoryRepostitory;
import com.keresman.dal.CommentRepository;
import com.keresman.dal.DeveloperRepository;
import com.keresman.dal.FavoriteGamesRepository;
import com.keresman.dal.FavouriteArticleRepostiory;
import com.keresman.dal.GameRepository;
import com.keresman.dal.GenreRepository;
import com.keresman.dal.PlatformRepository;
import com.keresman.dal.ReportRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
import com.keresman.model.Article;
import com.keresman.model.Game;
import com.keresman.parser.rss.GameArticleParser;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ManageGameArticlesPanelDesigner;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class ManageGameArticlesPanel extends ManageGameArticlesPanelDesigner {

  private ArticleRepository articleRepository;
  private GameRepository gameRepository;
  private UserRepository userRepository;
  private ReportRepository reportRepository;
  private CommentRepository commentRepository;
  private FavoriteGamesRepository favGamesRepository;
  private FavouriteArticleRepostiory favArticleRepository;
  private DeveloperRepository developerRepository;
  private GenreRepository genreRepository;
  private PlatformRepository platformRepository;
  private CategoryRepostitory categoryRepository;

  private final DefaultListModel<Article> articlesModel = new DefaultListModel<>();

  public ManageGameArticlesPanel() {
    super();
    init();
  }

  private void init() {
    try {
      initRepositories();
      loadArticlesIntoModel();
    } catch (Exception ex) {
      handleInitializationError(ex);
    }
  }

  private void initRepositories() throws Exception {
    articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
    userRepository = RepositoryFactory.getInstance(UserRepository.class);
    gameRepository = RepositoryFactory.getInstance(GameRepository.class);
    commentRepository = RepositoryFactory.getInstance(CommentRepository.class);
    reportRepository = RepositoryFactory.getInstance(ReportRepository.class);
    favArticleRepository = RepositoryFactory.getInstance(FavouriteArticleRepostiory.class);
    favGamesRepository = RepositoryFactory.getInstance(FavoriteGamesRepository.class);
    developerRepository = RepositoryFactory.getInstance(DeveloperRepository.class);
    genreRepository = RepositoryFactory.getInstance(GenreRepository.class);
    platformRepository = RepositoryFactory.getInstance(PlatformRepository.class);
    categoryRepository = RepositoryFactory.getInstance(CategoryRepostitory.class);
  }

  private void handleInitializationError(Exception ex) {
    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
    MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
    System.exit(1);
  }

  private void loadArticlesIntoModel() throws Exception {
    List<Article> articles = articleRepository.findAll();
    articlesModel.clear();
    articles.forEach(articlesModel::addElement);
    lsArticles.setModel(articlesModel);
  }

  @Override
  public void btnLoadDbActionPerformed(ActionEvent evt) {
    new Thread(this::loadArticlesAsync).start();
  }

  private void loadArticlesAsync() {
    try {
      List<Article> articles = articleRepository.findAll();

      if (articles.isEmpty()) {
        articles = GameArticleParser.parse();
        articleRepository.saveAll(articles);
        gameRepository.saveAll(extractUniqueGames(articles));
      }

      updateUIWithArticles(articles);
    } catch (Exception ex) {
      handleLoadError(ex);
    }
  }

  private List<Game> extractUniqueGames(List<Article> articles) {
    return articles.stream().flatMap(article -> article.getGames().stream()).distinct().toList();
  }

  private void updateUIWithArticles(List<Article> articles) {
    SwingUtilities.invokeLater(
        () -> {
          articlesModel.clear();
          articles.forEach(articlesModel::addElement);
          lsArticles.setModel(articlesModel);
          MessageUtils.showInformationMessage("INFO", "Articles loaded successfully!");
        });
  }

  private void handleLoadError(Exception ex) {
    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
    SwingUtilities.invokeLater(
        () ->
            MessageUtils.showErrorMessage("Error", "Failed to load articles: " + ex.getMessage()));
  }

  @Override
  public void btnDeleteAllActionPerformed(ActionEvent evt) {
    try {
      deleteAllEntities();
      loadArticlesIntoModel();
    } catch (Exception ex) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void deleteAllEntities() throws Exception {
    commentRepository.deleteAll();
    reportRepository.deleteAll();
    favGamesRepository.deleteAll();
    favArticleRepository.deleteAll();
    articleRepository.deleteAll();
    gameRepository.deleteAll();
    userRepository.deleteAll();
    developerRepository.deleteAll();
    genreRepository.deleteAll();
    platformRepository.deleteAll();
    categoryRepository.deleteAll();
  }
}
