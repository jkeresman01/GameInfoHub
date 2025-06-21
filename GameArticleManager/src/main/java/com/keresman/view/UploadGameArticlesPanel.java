package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Article;
import com.keresman.parser.rss.GameArticleParser;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.UploadGameArticlesPanelDesigner;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class UploadGameArticlesPanel extends UploadGameArticlesPanelDesigner {

    private ArticleRepository articleRepository;
    private DefaultListModel<Article> articlesModel;

    public UploadGameArticlesPanel() {
        super();
        init();
    }

    private void init() {
        try {
            articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
            articlesModel = new DefaultListModel<>();
            loadModel();
        } catch (Exception ex) {
            Logger.getLogger(UploadGameArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
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
        Logger.getLogger(UploadGameArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        SwingUtilities.invokeLater(()
                -> MessageUtils.showErrorMessage("Error", "Failed to load articles: " + ex.getMessage())
        );
    }

}
