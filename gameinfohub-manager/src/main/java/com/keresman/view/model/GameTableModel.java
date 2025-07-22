package com.keresman.view.model;

import com.keresman.model.Game;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel {

  private static final String[] COLUMNS = {
    "Id", "Title", "Release Date", "Genre", "Developer", "Platform"
  };

  private List<Game> games;

  public GameTableModel(List<Game> games) {
    setGames(games);
  }

  @Override
  public int getRowCount() {
    return games.size();
  }

  @Override
  public int getColumnCount() {
    return COLUMNS.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Game game = games.get(rowIndex);

    return switch (columnIndex) {
      case 0 -> game.getGameId();
      case 1 -> game.getName();
      case 2 -> game.getReleaseDate();
      case 3 -> !game.getGenres().isEmpty() ? game.getGenres().get(0).getName() : "";
      case 4 -> !game.getDevelopers().isEmpty() ? game.getDevelopers().get(0).getName() : "";
      case 5 -> !game.getPlatforms().isEmpty() ? game.getPlatforms().get(0).getName() : "";
      default -> null;
    };
  }

  public void setGames(List<Game> games) {
    this.games = games;
    fireTableDataChanged();
  }

  @Override
  public String getColumnName(int column) {
    return COLUMNS[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return switch (columnIndex) {
      case 0 -> Integer.class;
      case 2 -> java.time.LocalDate.class;
      default -> String.class;
    };
  }
}
