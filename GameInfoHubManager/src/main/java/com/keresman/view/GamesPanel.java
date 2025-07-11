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
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class GamesPanel extends GamesPanelDesigner {

  private Map<JTextComponent, JLabel> fieldsWithErrorLabels;
  private GameRepository gameRepository;
  private CommentRepository commentRepository;
  private GameTableModel gameTableModel;
  private Game selectedGame;
  private int selectedGameId;

  private final DefaultListModel<Genre> genreModel = new DefaultListModel<>();
  private final DefaultListModel<Developer> developerModel = new DefaultListModel<>();
  private final DefaultListModel<Platform> platformModel = new DefaultListModel<>();
  private final DefaultListModel<Comment> commentModel = new DefaultListModel<>();

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
      handleInitializationError(ex);
    }
  }

  private void initValidation() {
    fieldsWithErrorLabels =
        Map.of(
            tfGameName, lblErrorGameName,
            tfRelDate, lblErrorRelDate);
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

  private void handleInitializationError(Exception ex) {
    Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, null, ex);
    MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
    System.exit(1);
  }

  @Override
  public void btnAddActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      return;
    }

    try {
      Game game = new Game();
      game.setName(tfGameName.getText().trim());
      game.setReleaseDate(LocalDate.parse(tfRelDate.getText().trim()));

      gameRepository.save(game);
      gameTableModel.setGames(gameRepository.findAll());
      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, "Unable to add game", ex);
      MessageUtils.showErrorMessage("Error", "Failed to add game.");
    }
  }

  @Override
  public void btnDeleteActionPerformed(ActionEvent evt) {
    if (selectedGame == null) {
      MessageUtils.showWarningMessage("Warning", "Please select a game to delete.");
      return;
    }

    if (!MessageUtils.showConfirmDialog(
        "Delete Game", "Are you sure you want to delete this game?")) {
      return;
    }

    try {
      gameRepository.deleteById(selectedGame.getGameId());
      gameTableModel.setGames(gameRepository.findAll());
      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, "Unable to delete game", ex);
      MessageUtils.showErrorMessage("Error", "Failed to delete game.");
    }
  }

  @Override
  public void btnUpdateActionPerformed(ActionEvent evt) {
    if (selectedGame == null) {
      MessageUtils.showWarningMessage("Warning", "Please select a game to update.");
      return;
    }

    if (!isFormValid()) {
      return;
    }

    try {
      selectedGame.setName(tfGameName.getText().trim());
      selectedGame.setReleaseDate(LocalDate.parse(tfRelDate.getText().trim()));

      gameRepository.updateById(selectedGame.getGameId(), selectedGame);
      gameTableModel.setGames(gameRepository.findAll());
      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, "Unable to update game", ex);
      MessageUtils.showErrorMessage("Error", "Failed to update game.");
    }
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
          selectedGame.getReleaseDate() != null ? selectedGame.getReleaseDate().toString() : "");

      loadListModels();

    } catch (Exception ex) {
      Logger.getLogger(GamesPanel.class.getName()).log(Level.SEVERE, "Error loading game", ex);
      MessageUtils.showErrorMessage("Error", "Failed to load game data.");
    }
  }

  private void clearForm() {
    tfGameName.setText("");
    tfRelDate.setText("");
    selectedGame = null;
    selectedGameId = 0;

    genreModel.clear();
    developerModel.clear();
    platformModel.clear();
    commentModel.clear();
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
    fieldsWithErrorLabels.forEach(
        (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));
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

    AddCommentDialog commentGameDialog =
        new AddCommentDialog((JFrame) SwingUtilities.getWindowAncestor(this), true, optGame.get());
    EventQueue.invokeLater(() -> commentGameDialog.setVisible(true));
  }
}
