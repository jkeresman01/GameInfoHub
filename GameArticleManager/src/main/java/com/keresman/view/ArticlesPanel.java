package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Article;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ArticlesPanelDesigner;
import com.keresman.view.designer.RegisterPanelDesigner;
import com.keresman.view.model.ArticleTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.text.JTextComponent;

public class ArticlesPanel extends ArticlesPanelDesigner {

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

    private int selectedArticleId;
//    private UserService userService; ARTICLE
    private ArticleTableModel articleTableModel;

    public ArticlesPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(RegisterPanelDesigner.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        fieldsWithErrorLabels = Map.ofEntries(
                Map.entry(tfTitle, lblErrorTitle),
                Map.entry(tfLink, lblErrorLink),
                Map.entry(taDescription, lblErrorDesription),
                Map.entry(tfPubDate, lblErrorPubDate));
    }

    private void initTable() throws Exception {
        tblArticles.setRowHeight(25);
        tblArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblArticles.setAutoCreateRowSorter(true);

        ArticleRepository articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);

        List<Article> articles = articleRepository.findAll();

        articleTableModel = new ArticleTableModel(articles);
        tblArticles.setModel(articleTableModel);
    }

    private boolean isFormValid() {
        hideErrors();

        fieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return fieldsWithErrorLabels.values().stream().noneMatch(errLabel -> errLabel.isVisible());
    }

    private void hideErrors() {
        fieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
    }

    @Override
    public void btnAddActionPerformed(ActionEvent evt) {
        if (!isFormValid()) {
            return;
        }
    }

    @Override
    public void btnUpdateActionPerformed(ActionEvent evt) {
        if (!isFormValid()) {
            return;
        }
    }

    @Override
    public void btnDeleteActionPerformed(ActionEvent evt) {
        if (!isFormValid()) {
            return;
        }
    }

    @Override
    public void lblImageMouseClicked(MouseEvent evt) {
        if (!isFormValid()) {
            return;
        }
    }

    @Override
    public void formAncestorAdded(AncestorEvent evt) {
        refreshData();
    }

    private void refreshData() {
        ArticleRepository articleRepository;
        try {
            articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
            List<Article> articles = articleRepository.findAll();
            articleTableModel.setAricles(articles);
        } catch (Exception ex) {
            Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void tblArticlesMouseClicked(MouseEvent evt) {
        int selectedRow = tblArticles.getSelectedRow();
        selectedArticleId = (int) articleTableModel.getValueAt(selectedRow, 0);

        ArticleRepository articleRepository;
        try {
            articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
            
            Optional<Article>optArticle = articleRepository.findById(selectedArticleId);
            
            if (optArticle.isPresent()) {
                tfTitle.setText(optArticle.get().getTitle());
                tfLink.setText(optArticle.get().getLink());
                taDescription.setText(optArticle.get().getDescription());
                tfPubDate.setText(optArticle.get().getPublishedDateTime().toString());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
