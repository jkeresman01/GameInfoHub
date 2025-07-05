package com.keresman.view;

import com.keresman.model.Article;
import com.keresman.model.Report;
import com.keresman.model.ReportAddable;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ReportArticleDialogDesigner;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class ReportArticleDialog extends ReportArticleDialogDesigner {

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

    private final ReportAddable reportAddable;
    private final Article article;

    public ReportArticleDialog(Frame parent, boolean modal, Article article) {
        super(parent, modal);
        reportAddable = (ReportAddable) parent;
        this.article = article;
        init();
    }

    private void init() {
        initValidation();
        hideErrors();
    }

    private void initValidation() {
        fieldsWithErrorLabels = Map.ofEntries(
                Map.entry(tfTitle, lblErrorTitle),
                Map.entry(tfContent, lblErrorContent));
    }

    private void hideErrors() {
        fieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
    }

    @Override
    public void btnReportActionPerformed(ActionEvent evt) {

        if (!isFormValid()) {
            return;
        }

        String title = tfTitle.getText().trim();
        String content = tfContent.getText().trim();

        reportAddable.addReport(new Report(title, content), article);

        MessageUtils.showInformationMessage("Report", "Article reported.");

        dispose();
    }

    private boolean isFormValid() {
        hideErrors();

        fieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return fieldsWithErrorLabels.values().stream().noneMatch(errLabel -> errLabel.isVisible());
    }

}
