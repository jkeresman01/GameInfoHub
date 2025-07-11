package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Article;
import com.keresman.utilities.FileUtils;
import com.keresman.utilities.IconUtils;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ArticlesPanelDesigner;
import com.keresman.view.model.ArticleTableModel;
import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.text.JTextComponent;

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

  private void initValidation() {
    fieldsWithErrorLabels =
        Map.of(
            tfTitle, lblErrorTitle,
            tfLink, lblErrorLink,
            taDescription, lblErrorDesription,
            tfPubDate, lblErrorPubDate);
  }

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
  }

  private void initRepository() throws Exception {
    articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
  }

  private void initTable() throws Exception {
    tblArticles.setRowHeight(25);
    tblArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblArticles.setAutoCreateRowSorter(true);
    refreshArticleTable();
  }

  private void handleInitializationError(Exception ex) {
    Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
    MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
    System.exit(1);
  }

  @Override
  public void btnAddActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      return;
    }
    createArticle();
  }

  private void createArticle() {
    try {
      Article article = createArticleFromForm();
      articleRepository.save(article);
      refreshArticleTable();
      clearForm();
    } catch (Exception ex) {
      handleCrudError("create", ex);
    }
  }

  @Override
  public void btnUpdateActionPerformed(ActionEvent evt) {
    if (!canUpdateArticle()) {
      return;
    }
    updateArticle();
  }

  private boolean canUpdateArticle() {
    if (selectedArticle == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose article to update");
      return false;
    }
    if (picturePath == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose picture path");
      return false;
    }
    return isFormValid();
  }

  private void updateArticle() {
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

  @Override
  public void btnDeleteActionPerformed(ActionEvent evt) {
    if (!canDeleteArticle()) {
      return;
    }
    deleteArticle();
  }

  private boolean canDeleteArticle() {
    if (selectedArticle == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose article to delete");
      return false;
    }
    return MessageUtils.showConfirmDialog(
        "Delete article", "Do you really want to delete article?");
  }

  private void deleteArticle() {
    try {
      deleteArticlePictureIfExists();
      articleRepository.deleteById(selectedArticle.getArticleId());
      refreshArticleTable();
      clearForm();
    } catch (Exception ex) {
      handleCrudError("delete", ex);
    }
  }

  private void deleteArticlePictureIfExists() throws IOException {
    if (selectedArticle.getPicturePath() != null) {
      Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
    }
  }

  @Override
  public void btnClearActionPerformed(ActionEvent evt) {
    clearForm();
  }

  @Override
  public void formAncestorAdded(AncestorEvent evt) {
    refreshData();
  }

  private void refreshData() {
    try {
      refreshArticleTable();
    } catch (Exception ex) {
      handleCrudError("refresh", ex);
    }
  }

  private void refreshArticleTable() throws Exception {
    List<Article> articles = articleRepository.findAll();
    if (articleTableModel == null) {
      articleTableModel = new ArticleTableModel(articles);
      tblArticles.setModel(articleTableModel);
    } else {
      articleTableModel.setArticles(articles);
    }
  }

  @Override
  public void tblArticlesMouseClicked(MouseEvent evt) {
    int selectedRow = tblArticles.getSelectedRow();
    selectedArticleId = (int) articleTableModel.getValueAt(selectedRow, 0);
    loadSelectedArticle();
  }

  private void loadSelectedArticle() {
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

  @Override
  public void lblconMouseClicked(MouseEvent evt) {
    Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
    file.ifPresent(
        f -> {
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

  private Article createArticleFromForm() {
    return new Article(
        tfTitle.getText().trim(),
        tfLink.getText().trim(),
        taDescription.getText().trim(),
        LocalDateTime.parse(tfPubDate.getText().trim(), Article.DATE_TIME_FORMATTER),
        picturePath);
  }

  private void updateSelectedArticleFromForm() {
    selectedArticle.setTitle(tfTitle.getText().trim());
    selectedArticle.setLink(tfLink.getText().trim());
    selectedArticle.setDescription(taDescription.getText().trim());
    selectedArticle.setPublishedDateTime(
        LocalDateTime.parse(tfPubDate.getText().trim(), Article.DATE_TIME_FORMATTER));
  }

  private boolean isFormValid() {
    hideErrors();
    showFieldErrorsIfEmpty();
    return areAllFieldsValid();
  }

  private void showFieldErrorsIfEmpty() {
    fieldsWithErrorLabels.forEach(
        (field, label) -> label.setVisible(field.getText().trim().isEmpty()));
  }

  private boolean areAllFieldsValid() {
    return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }

  private void clearForm() {
    hideErrors();
    fieldsWithErrorLabels.keySet().forEach(tf -> tf.setText(""));
    lblcon.setIcon(null);
    picturePath = null;
    selectedArticle = null;
  }

  @Override
  public void btnReportActionPerformed(ActionEvent evt) {
    if (!hasSelectedRow()) {
      MessageUtils.showWarningMessage("Warning", "Please select a game");
      return;
    }

    loadSelectedArticleForReport().ifPresent(this::openReportDialog);
  }

  private boolean hasSelectedRow() {
    return tblArticles.getSelectedRow() != -1;
  }

  private Optional<Article> loadSelectedArticleForReport() {
    selectedArticleId = (int) articleTableModel.getValueAt(tblArticles.getSelectedRow(), 0);
    try {
      return articleRepository.findById(selectedArticleId);
    } catch (Exception ex) {
      handleCrudError("select article", ex);
      return Optional.empty();
    }
  }

  private void openReportDialog(Article article) {
    ReportArticleDialog dialog =
        new ReportArticleDialog((JFrame) SwingUtilities.getWindowAncestor(this), true, article);
    EventQueue.invokeLater(() -> dialog.setVisible(true));
  }

  private void handleCrudError(String action, Exception ex) {
    Logger.getLogger(ArticlesPanel.class.getName())
        .log(Level.SEVERE, "Unable to " + action + " article", ex);
    MessageUtils.showErrorMessage("Error", "Unable to " + action + " article!");
  }
}
