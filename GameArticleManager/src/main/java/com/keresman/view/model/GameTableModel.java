package com.keresman.view.model;

import com.keresman.model.Game;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel {

    private static final String[] COLUMS = {
        "Id", "Title", "Description", "Genre", "Picture path"
    };

    private List<Game> games;

    public GameTableModel(List<Game> games) {
        setUsers(games);
    }

    @Override
    public int getRowCount() {
        return games.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Game game = games.get(rowIndex);
        
        return switch (columnIndex) {
//            case 0 -> game.getId();
//            case 1 -> game.getFirstName();
//            case 2 -> game.getLastName();
//            case 3 -> game.getUsername();
//            case 4 -> game.getGender();
//            case 5 -> game.getEmail();
//            case 6 -> game.isActive() ? "YES" : "NO";
            default -> null;
        };
    }

    public void setUsers(List<Game> games) {
        this.games = games;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMS[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        }

        return super.getColumnClass(columnIndex);
    }

}
