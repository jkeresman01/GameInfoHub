package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Article;
import com.keresman.utilities.FileUtils;
import com.keresman.utilities.IconUtils;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ArticlesPanelDesigner;
import com.keresman.view.model.ArticleTableModel;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticlesPanel extends ArticlesPanelDesigner {

    private static final String DIR = "assets" + File.separator + "articles";

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;
    private Article selectedArticle;
    private String picturePath;
    private ArticleRepository articleRepository;
    private ArticleTableModel articleTableModel;
    private int selectedArticleId;

    public ArticlesPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
            initTable();
        } catch (Exception ex) {
            handleInitializationError(ex);
        }
    }

    private void handleInitializationError(Exception ex) {
        Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
        System.exit(1);
    }

    private void initValidation() {
        fieldsWithErrorLabels = Map.of(
                tfTitle, lblErrorTitle,
                tfLink, lblErrorLink,
                taDescription, lblErrorDesription,
                tfPubDate, lblErrorPubDate
        );
    }

    private void initTable() throws Exception {
        tblArticles.setRowHeight(25);
        tblArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblArticles.setAutoCreateRowSorter(true);

        List<Article> articles = articleRepository.findAll();
        articleTableModel = new ArticleTableModel(articles);
        tblArticles.setModel(articleTableModel);
    }

    private boolean isFormValid() {
        hideErrors();
        fieldsWithErrorLabels.forEach((field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));
        return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
    }

    private void hideErrors() {
        fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
    }

    @Override
    public void btnAddActionPerformed(ActionEvent evt) {
        if (!isFormValid()) {
            return;
        }

        try {
            Article article = createArticleFromForm();
            articleRepository.save(article);
            refreshArticleTable();
            clearForm();
        } catch (Exception ex) {
            handleCrudError("create", ex);
        }
    }

    private Article createArticleFromForm() {
        return new Article(
                tfTitle.getText().trim(),
                tfLink.getText().trim(),
                taDescription.getText().trim(),
                LocalDateTime.parse(tfPubDate.getText().trim(), Article.DATE_TIME_FORMATTER),
                picturePath
        );
    }

    private void refreshArticleTable() throws Exception {
        articleTableModel.setArticles(articleRepository.findAll());
    }

    @Override
    public void btnUpdateActionPerformed(ActionEvent evt) {
        if (selectedArticle == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to update");
            return;
        }

        if (picturePath == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose picture path!!!!");
            return;
        }

        if (!isFormValid()) {
            return;
        }

        try {
            handlePictureUpdateIfNeeded();
            updateSelectedArticleFromForm();
            articleRepository.updateById(selectedArticle.getArticleId(), selectedArticle);
            refreshArticleTable();
            clearForm();
        } catch (Exception ex) {
            handleCrudError("update", ex);
        }
    }

    private void handlePictureUpdateIfNeeded() throws IOException {
        if (!picturePath.equals(selectedArticle.getPicturePath())) {
            Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
            selectedArticle.setPicturePath(uploadPicture());
        }
    }

    private void updateSelectedArticleFromForm() {
        selectedArticle.setTitle(tfTitle.getText().trim());
        selectedArticle.setLink(tfLink.getText().trim());
        selectedArticle.setDescription(taDescription.getText().trim());
        selectedArticle.setPublishedDateTime(LocalDateTime.parse(tfPubDate.getText().trim(), Article.DATE_TIME_FORMATTER));
    }

    @Override
    public void btnDeleteActionPerformed(ActionEvent evt) {
        if (selectedArticle == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to delete");
            return;
        }

        if (MessageUtils.showConfirmDialog("Delete article", "Do you really want to delete article?")) {
            try {
                deleteArticlePictureIfExists();
                articleRepository.deleteById(selectedArticle.getArticleId());
                refreshArticleTable();
                clearForm();
            } catch (Exception ex) {
                handleCrudError("delete", ex);
            }
        }
    }

    private void deleteArticlePictureIfExists() throws IOException {
        if (selectedArticle.getPicturePath() != null) {
            Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
        }
    }

    @Override
    public void lblconMouseClicked(MouseEvent evt) {
        Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        file.ifPresent(f -> {
            picturePath = f.getAbsolutePath();
            setIcon(lblcon, f);
        });
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            handleCrudError("set icon", ex);
        }
    }

    private String uploadPicture() throws IOException {
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;
        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    @Override
    public void formAncestorAdded(AncestorEvent evt) {
        refreshData();
    }

    private void refreshData() {
        try {
            List<Article> articles = articleRepository.findAll();
            articleTableModel.setArticles(articles);
        } catch (Exception ex) {
            handleCrudError("refresh", ex);
        }
    }

    @Override
    public void tblArticlesMouseClicked(MouseEvent evt) {
        int selectedRow = tblArticles.getSelectedRow();
        selectedArticleId = (int) articleTableModel.getValueAt(selectedRow, 0);

        try {
            Optional<Article> optArticle = articleRepository.findById(selectedArticleId);
            optArticle.ifPresent(this::populateFormFromArticle);
        } catch (Exception ex) {
            handleCrudError("select article", ex);
        }
    }

    private void populateFormFromArticle(Article article) {
        tfTitle.setText(article.getTitle());
        tfLink.setText(article.getLink());
        taDescription.setText(article.getDescription());
        tfPubDate.setText(article.getPublishedDateTime().toString());

        selectedArticle = article;
        picturePath = article.getPicturePath();

        if (picturePath != null) {
            setIcon(lblcon, new File(picturePath));
        } else {
            lblcon.setIcon(null);
        }
    }

    private void clearForm() {
        hideErrors();
        fieldsWithErrorLabels.keySet().forEach(tf -> tf.setText(""));
        lblcon.setIcon(null);
        picturePath = null;
        selectedArticle = null;
    }

    @Override
    public void btnClearActionPerformed(ActionEvent evt) {
        clearForm();
    }

    @Override
    public void btnReportActionPerformed(ActionEvent evt) {
        int selectedRow = tblArticles.getSelectedRow();
        selectedArticleId = (int) articleTableModel.getValueAt(selectedRow, 0);

        Optional<Article> optArticle = Optional.empty();

        try {
            optArticle = articleRepository.findById(selectedArticleId);
        } catch (Exception ex) {
            handleCrudError("select article", ex);
        }

        if (optArticle.isEmpty()) {
            MessageUtils.showWarningMessage("Warning", "Please select article");
            return;
        }

        ReportArticleDialog reportArticleDialog = new ReportArticleDialog((JFrame) SwingUtilities.getWindowAncestor(this), true, optArticle.get());
        EventQueue.invokeLater(() -> reportArticleDialog.setVisible(true));
    }

    private void initRepository() throws Exception {
        articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
    }

    private void handleCrudError(String action, Exception ex) {
        Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, "Unable to " + action + " article", ex);
        MessageUtils.showErrorMessage("Error", "Unable to " + action + " article!");
    }
}
