package com.keresman.view;

import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ArticlesPanelDesigner;
import com.keresman.view.designer.RegisterPanelDesigner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class ArticlesPanel extends ArticlesPanelDesigner {

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

    public ArticlesPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
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

    private boolean isFormValid() {
        hideErrors();

        fieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return fieldsWithErrorLabels.values().stream().noneMatch(errLabel -> errLabel.isVisible());
    }

    private void clearArticleForm() {
        hideErrors();

        fieldsWithErrorLabels.keySet().forEach(field -> field.setText(""));
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
}
