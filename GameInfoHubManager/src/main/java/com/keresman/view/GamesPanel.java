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
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

public class GamesPanel extends GamesPanelDesigner {

  private static final int TABLE_ROW_HEIGHT = 25;

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
      bindListModels();
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

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
  }

  private boolean isFormValid() {
    hideErrors();
    fieldsWithErrorLabels.forEach(
        (field, label) -> label.setVisible(field.getText().trim().isEmpty()));
    return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }

  private void initRepositories() throws Exception {
    gameRepository = RepositoryFactory.getInstance(GameRepository.class);
    commentRepository = RepositoryFactory.getInstance(CommentRepository.class);
  }

  private void initTable() throws Exception {
    tblGames.setRowHeight(TABLE_ROW_HEIGHT);
    tblGames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblGames.setAutoCreateRowSorter(true);
    gameTableModel = new GameTableModel(gameRepository.findAll());
    tblGames.setModel(gameTableModel);
  }

  private void bindListModels() {
    lsGenre.setModel(genreModel);
    lsDevelopement.setModel(developerModel);
    lsPlatform.setModel(platformModel);
    lsComments.setModel(commentModel);
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
    addGame();
  }

  private void addGame() {
    try {
      Game game = createGameFromForm();
      gameRepository.save(game);
      refreshGameTable();
      clearForm();
    } catch (Exception ex) {
      showError("add", ex);
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
    updateGame();
  }

  private void updateGame() {
    try {
      updateSelectedGameFromForm();
      gameRepository.updateById(selectedGame.getGameId(), selectedGame);
      refreshGameTable();
      clearForm();
    } catch (Exception ex) {
      showError("update", ex);
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

    deleteGame();
  }

  private void deleteGame() {
    try {
      gameRepository.deleteById(selectedGame.getGameId());
      refreshGameTable();
      clearForm();
    } catch (Exception ex) {
      showError("delete", ex);
    }
  }

  @Override
  public void tblGamesMouseClicked(MouseEvent evt) {
    if (tblGames.getSelectedRow() == -1) {
      return;
    }
    selectedGameId = (int) tblGames.getValueAt(tblGames.getSelectedRow(), 0);
    loadSelectedGame();
  }

  private void loadSelectedGame() {
    try {
      Optional<Game> optGame = gameRepository.findById(selectedGameId);
      if (optGame.isEmpty()) {
        MessageUtils.showWarningMessage("Warning", "Game not found.");
        return;
      }
      selectedGame = optGame.get();
      populateFormFromGame(selectedGame);
      loadAssociatedLists();
    } catch (Exception ex) {
      showError("load game", ex);
    }
  }

  private void populateFormFromGame(Game game) {
    tfGameName.setText(game.getName());
    tfRelDate.setText(game.getReleaseDate() != null ? game.getReleaseDate().toString() : "");
  }

  private void loadAssociatedLists() throws Exception {
    loadGenres();
    loadDevelopers();
    loadPlatforms();
    loadComments();
  }

  private void loadGenres() {
    genreModel.clear();
    selectedGame.getGenres().forEach(genreModel::addElement);
  }

  private void loadDevelopers() {
    developerModel.clear();
    selectedGame.getDevelopers().forEach(developerModel::addElement);
  }

  private void loadPlatforms() {
    platformModel.clear();
    selectedGame.getPlatforms().forEach(platformModel::addElement);
  }

  private void loadComments() throws Exception {
    commentModel.clear();
    commentRepository.findByGameId(selectedGameId).forEach(commentModel::addElement);
  }

  private void refreshGameTable() throws Exception {
    gameTableModel.setGames(gameRepository.findAll());
  }

  private Game createGameFromForm() {
    return new Game(tfGameName.getText().trim());
  }

  private void updateSelectedGameFromForm() {
    selectedGame.setName(tfGameName.getText().trim());
    selectedGame.setReleaseDate(LocalDate.parse(tfRelDate.getText().trim()));
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

  @Override
  public void btnCommentActionPerformed(ActionEvent evt) {
    if (tblGames.getSelectedRow() == -1) {
      MessageUtils.showWarningMessage("Warning", "Please select a game");
      return;
    }

    selectedGameId = (int) tblGames.getValueAt(tblGames.getSelectedRow(), 0);

    try {
      Optional<Game> optGame = gameRepository.findById(selectedGameId);
      if (optGame.isEmpty()) {
        MessageUtils.showWarningMessage("Warning", "Game not found in database.");
        return;
      }

      openCommentDialog(optGame.get());
    } catch (Exception ex) {
      showError("select game", ex);
    }
  }

  private void openCommentDialog(Game game) {
    AddCommentDialog dialog =
        new AddCommentDialog((JFrame) SwingUtilities.getWindowAncestor(this), true, game);
    EventQueue.invokeLater(() -> dialog.setVisible(true));
  }

  private void showError(String action, Exception ex) {
    Logger.getLogger(GamesPanel.class.getName())
        .log(Level.SEVERE, "Unable to " + action + " game", ex);
    MessageUtils.showErrorMessage("Error", "Failed to " + action + " game.");
  }
}
