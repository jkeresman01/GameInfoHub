package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Article;
import com.keresman.utilities.FileUtils;
import com.keresman.utilities.IconUtils;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ArticlesPanelDesigner;
import com.keresman.view.designer.RegisterPanelDesigner;
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

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

    private static final String DIR = "resources" + File.separator + "assets" + File.separator + "articles";

    private Article selectedArticle;

    private String picturePath;
    private int selectedArticleId;
    private ArticleRepository articleRepository;
    private ArticleTableModel articleTableModel;

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

        try {
            Article article = new Article(
                    tfTitle.getText().trim(),
                    tfLink.getText().trim(),
                    taDescription.getText().trim(),
                    LocalDateTime.parse(tfPubDate.getText().trim(), Article.DATE_TIME_FORMATTER),
                    picturePath
            );
            articleRepository.save(article);
            articleTableModel.setArticles(articleRepository.findAll());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to create article!");
        }
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
            if (!picturePath.equals(selectedArticle.getPicturePath())) {
   
             if (selectedArticle.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
                }

                String localPicturePath = uploadPicture();
                selectedArticle.setPicturePath(localPicturePath);
            }

            selectedArticle.setTitle(tfTitle.getText().trim());
            selectedArticle.setLink(tfLink.getText().trim());
            selectedArticle.setDescription(taDescription.getText().trim());
            selectedArticle.setPublishedDateTime(LocalDateTime.parse(tfPubDate.getText().trim(), Article.DATE_TIME_FORMATTER));

            articleRepository.updateById(selectedArticle.getArticleId(), selectedArticle);
            articleTableModel.setArticles(articleRepository.findAll());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to update article!");
        }
    }

    @Override
    public void btnDeleteActionPerformed(ActionEvent evt) {
        if (selectedArticle == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose article to delete");
            return;
        }

        if (MessageUtils.showConfirmDialog(
                "Delete article",
                "Do you really want to delete article?")) {
            try {
                if (selectedArticle.getPicturePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
                }
                articleRepository.deleteById(selectedArticle.getArticleId());
                articleTableModel.setArticles(articleRepository.findAll());

                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete article!");
            }
        }
    }

    @Override
    public void lblconMouseClicked(MouseEvent evt) {
        Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");

        if (file.isEmpty()) {
            return;
        }

        picturePath = file.get().getAbsolutePath();
        setIcon(lblcon, file.get());
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to set icon!");
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
        ArticleRepository articleRepository;
        try {
            articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
            List<Article> articles = articleRepository.findAll();
            articleTableModel.setArticles(articles);
        } catch (Exception ex) {
            Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void tblArticlesMouseClicked(MouseEvent evt) {
        int selectedRow = tblArticles.getSelectedRow();
        selectedArticleId = (int) articleTableModel.getValueAt(selectedRow, 0);

        try {
            Optional<Article> optArticle = articleRepository.findById(selectedArticleId);

            if (optArticle.isPresent()) {
                tfTitle.setText(optArticle.get().getTitle());
                tfLink.setText(optArticle.get().getLink());
                taDescription.setText(optArticle.get().getDescription());
                tfPubDate.setText(optArticle.get().getPublishedDateTime().toString());

                selectedArticle = optArticle.get();
                picturePath = optArticle.get().getPicturePath();

                if (picturePath != null) {
                    lblcon.setIcon(new javax.swing.ImageIcon(getClass().getResource(picturePath)));
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearForm() {
        hideErrors();
        fieldsWithErrorLabels.keySet().forEach(tf -> tf.setText(""));
        picturePath = null;
        selectedArticle = null;
    }

    @Override
    public void btnClearActionPerformed(ActionEvent evt) {
        fieldsWithErrorLabels.keySet().forEach(tf -> tf.setText(""));
    }

    @Override
    public void btnReportActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(() -> {
            ReportArticleDialog dialog = new ReportArticleDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
            dialog.setVisible(true);
        });
    }

    @Override
    public void btnCommentActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(() -> {
            AddCommentDialog dialog = new AddCommentDialog((JFrame) SwingUtilities.getWindowAncestor(this), true);
            dialog.setVisible(true);
        });
    }

    private void initRepository() throws Exception {
        articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
    }
}
