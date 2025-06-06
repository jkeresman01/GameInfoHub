package com.keresman.view;

import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.GamesPanelDesigner;
import com.keresman.view.designer.RegisterPanelDesigner;
import com.keresman.view.model.ArticleTableModel;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

public class GamesPanel extends GamesPanelDesigner {

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

    private int selectedArticleId;
//    private UserService userService; ARTICLE
    private ArticleTableModel articleTableModel;

    public GamesPanel() {
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
        tblGames.setRowHeight(25);
        tblGames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblGames.setAutoCreateRowSorter(true);

//        ArticleRepository articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
//        TableModel = new ArticleTableModel(articles);
//        tblArticles.setModel(articleTableModel);
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
}
