package com.keresman.view;

import com.keresman.dal.CommentRepository;
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
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamesPanel extends GamesPanelDesigner {

    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;
    private GameRepository gameRepository;
    private CommentRepository commentRepository;
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
            initRepositories();
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

    private void initRepositories() throws Exception {
        gameRepository = RepositoryFactory.getInstance(GameRepository.class);
        commentRepository = RepositoryFactory.getInstance(CommentRepository.class);
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
        int selectedRow = tblGames.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }

        selectedGameId = (int) tblGames.getValueAt(selectedRow, 0);

        try {
            Optional<Game> optGame = gameRepository.findById(selectedGameId);
            if (optGame.isEmpty()) {
                MessageUtils.showWarningMessage("Warning", "Game not found.");
                return;
            }

            selectedGame = optGame.get();
            tfGameName.setText(selectedGame.getName());
            tfRelDate.setText(
                    selectedGame.getReleaseDate() != null
                    ? selectedGame.getReleaseDate().toString()
                    : ""
            );

            loadListModels();

        } catch (Exception ex) {
            Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, "Error loading game", ex);
            MessageUtils.showErrorMessage("Error", "Failed to load game data.");
        }
    }

    private void loadListModels() throws Exception {
        genreModel.clear();
        selectedGame.getGenres().forEach(genreModel::addElement);
        lsGenre.setModel(genreModel);

        developerModel.clear();
        selectedGame.getDevelopers().forEach(developerModel::addElement);
        lsDevelopement.setModel(developerModel);

        platformModel.clear();
        selectedGame.getPlatforms().forEach(platformModel::addElement);
        lsPlatform.setModel(platformModel);

        commentModel.clear();
        commentRepository.findByGameId(selectedGameId).forEach(commentModel::addElement);
        lsComments.setModel(commentModel);

    }

    private boolean isFormValid() {
        hideErrors();
        fieldsWithErrorLabels.forEach((field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));
        return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
    }

    @Override
    public void btnCommentActionPerformed(ActionEvent evt) {
        int selectedRow = tblGames.getSelectedRow();

        if (selectedRow == -1) {
            MessageUtils.showWarningMessage("Warning", "Please select a game");
            return;
        }

        selectedGameId = (int) tblGames.getValueAt(selectedRow, 0);
        Optional<Game> optGame = Optional.empty();

        try {
            optGame = gameRepository.findById(selectedGameId);
        } catch (Exception ex) {
            Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, "Unable to select game", ex);
            MessageUtils.showErrorMessage("Error", "Unable to select game!");
        }

        if (optGame.isEmpty()) {
            MessageUtils.showWarningMessage("Warning", "Game not found in database.");
            return;
        }

        AddCommentDialog commentGameDialog = new AddCommentDialog(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                true,
                optGame.get()
        );
        EventQueue.invokeLater(() -> commentGameDialog.setVisible(true));
    }
}
