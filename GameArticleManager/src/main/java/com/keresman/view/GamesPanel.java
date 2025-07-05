package com.keresman.view;

import com.keresman.dal.GameRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Comment;
import com.keresman.model.Developer;
import com.keresman.model.Game;
import com.keresman.model.Genre;
import com.keresman.model.Platform;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.GamesPanelDesigner;
import com.keresman.view.model.GameTableModel;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamesPanel extends GamesPanelDesigner {

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;
    private GameRepository gameRepository;
    private GameTableModel gameTableModel;
    private int selectedGameId;
    private Game selectedGame;

    private DefaultListModel<Genre> genreModel = new DefaultListModel<>();
    private DefaultListModel<Developer> developerModel = new DefaultListModel<>();
    private DefaultListModel<Platform> platformModel = new DefaultListModel<>();
    private DefaultListModel<Comment> commentModel = new DefaultListModel<>();

    public GamesPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
            initTable();
            initModels();
        } catch (Exception ex) {
            Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        fieldsWithErrorLabels = Map.of(
                tfGameName, lblErrorGameName,
                tfRelDate, lblErrorRelDate
        );
    }

    private void initRepository() throws Exception {
        gameRepository = RepositoryFactory.getInstance(GameRepository.class);
    }

    private void initTable() throws Exception {
        tblGames.setRowHeight(25);
        tblGames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblGames.setAutoCreateRowSorter(true);

        List<Game> games = gameRepository.findAll();
        gameTableModel = new GameTableModel(games);
        tblGames.setModel(gameTableModel);
    }

    private void initModels() {
        lsGenre.setModel(genreModel);
        lsDevelopement.setModel(developerModel);
        lsPlatform.setModel(platformModel);
        lsComments.setModel(commentModel);
    }

    private void hideErrors() {
        fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
    }

    @Override
    public void btnAddActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void btnDeleteActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void btnUpdateActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tblGamesMouseClicked(MouseEvent evt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private boolean isFormValid() {
        hideErrors();
        fieldsWithErrorLabels.forEach((field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));
        return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
    }

    @Override
    public void btnCommentActionPerformed(ActionEvent evt) {
        
    }
}
