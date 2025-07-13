package com.keresman.view;

import com.keresman.model.Article;
import com.keresman.model.Report;
import com.keresman.model.Reportable;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.ReportArticleDialogDesigner;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class ReportDialog extends ReportArticleDialogDesigner {

  private final Reportable reportable;
  private final Article article;

  private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

  public ReportDialog(Frame parent, boolean modal, Article article) {
    super(parent, modal);
    this.reportable = (Reportable) parent;
    this.article = article;
    init();
  }

  private void init() {
    initValidation();
    hideErrors();
  }

  private void initValidation() {
    fieldsWithErrorLabels =
        Map.of(
            tfTitle, lblErrorTitle,
            tfContent, lblErrorContent);
  }

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
  }

  @Override
  public void btnReportActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      return;
    }

    Report report = extractReportFromForm();
    reportable.report(report, article);

    MessageUtils.showInformationMessage("Report", "Article reported.");
    dispose();
  }

  private Report extractReportFromForm() {
    String title = tfTitle.getText().trim();
    String content = tfContent.getText().trim();
    return new Report(title, content);
  }

  private boolean isFormValid() {
    hideErrors();
    showValidationErrors();
    return areAllFieldsValid();
  }

  private void showValidationErrors() {
    fieldsWithErrorLabels.entrySet().stream()
        .filter(entry -> entry.getKey().getText().trim().isEmpty())
        .forEach(entry -> entry.getValue().setVisible(true));
  }

  private boolean areAllFieldsValid() {
    return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }
}
