package com.keresman.view;

import com.keresman.model.Comment;
import com.keresman.model.CommentAddable;
import com.keresman.model.Game;
import com.keresman.view.designer.AddCommentDialogDesigner;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class AddCommentDialog extends AddCommentDialogDesigner {

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;
    
    private final CommentAddable commentAddable;
    private final Game game;

    public AddCommentDialog(Frame parent, boolean modal, Game game) {
        super(parent, modal);
        this.commentAddable = (CommentAddable) parent;
        this.game = game;
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
    public void btnCommentActionPerformed(ActionEvent evt) {

        if (!isFormValid()) {
            return;
        }
        
        String title = tfTitle.getText().trim();
        String content = tfContent.getText().trim();
        
        commentAddable.addComment(new Comment(title, content), game);
    }

    private boolean isFormValid() {
        hideErrors();

        fieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return fieldsWithErrorLabels.values().stream().noneMatch(errLabel -> errLabel.isVisible());
    }

}
