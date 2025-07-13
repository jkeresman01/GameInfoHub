package com.keresman.view;

import com.keresman.model.Comment;
import com.keresman.model.CommentAddable;
import com.keresman.model.Game;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.AddCommentDialogDesigner;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class CommentDialog extends AddCommentDialogDesigner {

  private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

  private final CommentAddable commentAddable;
  private final Game game;

  public CommentDialog(Frame parent, boolean modal, Game game) {
    super(parent, modal);
    this.commentAddable = (CommentAddable) parent;
    this.game = game;
    init();
  }

  private void init() {
    mapValidationFields();
    hideErrors();
  }

  private void mapValidationFields() {
    fieldsWithErrorLabels =
        Map.of(
            tfTitle, lblErrorTitle,
            tfContent, lblErrorContent);
  }

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
  }

  @Override
  public void btnCommentActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      return;
    }

    addCommentToGame();
    showSuccessMessage();
    closeDialog();
  }

  private boolean isFormValid() {
    hideErrors();
    showFieldErrorsIfEmpty();
    return areAllFieldValid();
  }

  private void showFieldErrorsIfEmpty() {
    fieldsWithErrorLabels.forEach(
        (field, label) -> label.setVisible(field.getText().trim().isEmpty()));
  }

  private boolean areAllFieldValid() {
    return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }

  private void addCommentToGame() {
    Comment comment = new Comment(tfTitle.getText().trim(), tfContent.getText().trim());
    commentAddable.addComment(comment, game);
  }

  private void showSuccessMessage() {
    MessageUtils.showInformationMessage("Comment", "Comment added.");
  }

  private void closeDialog() {
    dispose();
  }
}
