package com.keresman.view;

import com.keresman.dal.*;
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
    
    private DefaultListModel<Article> articlesModel = new DefaultListModel<>();

    public ManageGameArticlesPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initRepositories();
            loadModel();
        } catch (Exception ex) {
            Logger.getLogger(ManageGameArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
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

    private void loadModel() throws Exception {
        List<Article> articles = fetchArticlesFromDatabase();
        articlesModel.clear();
        articles.forEach(articlesModel::addElement);
        lsArticles.setModel(articlesModel);
    }

    @Override
    public void btnLoadDbActionPerformed(ActionEvent evt) {
        new Thread(this::loadArticlesFromSource).start();
    }

    private void loadArticlesFromSource() {
        try {
            List<Article> articles = fetchArticlesFromDatabase();

            if (articles.isEmpty()) {
                articles = GameArticleParser.parse();
                articleRepository.saveAll(articles);

                List<Game> uniqueGames = articles.stream()
                        .flatMap(article -> article.getGames().stream())
                        .distinct()
                        .toList();

                gameRepository.saveAll(uniqueGames);
            }

            updateUIWithArticles(articles);
        } catch (Exception ex) {
            handleLoadError(ex);
        }
    }

    private List<Article> fetchArticlesFromDatabase() throws Exception {
        return articleRepository.findAll();
    }

    private void updateUIWithArticles(List<Article> articles) {
        List<Article> finalArticles = articles;
        SwingUtilities.invokeLater(() -> {
            articlesModel.clear();
            finalArticles.forEach(articlesModel::addElement);
            lsArticles.setModel(articlesModel);
            MessageUtils.showInformationMessage("INFO", "Articles loaded successfully!");
        });
    }

    private void handleLoadError(Exception ex) {
        Logger.getLogger(ManageGameArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        SwingUtilities.invokeLater(() -> MessageUtils.showErrorMessage("Error", "Failed to load articles: " + ex.getMessage()));
    }

    @Override
    public void btnDeleteAllActionPerformed(ActionEvent evt) {
        try {
            deleteAll();
            loadModel();
        } catch (Exception ex) {
            Logger.getLogger(ManageGameArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteAll() throws Exception {
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
