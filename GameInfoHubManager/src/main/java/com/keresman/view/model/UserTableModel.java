package com.keresman.view.model;

import com.keresman.model.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {

    private static final String[] COLUMS = {
        "Id", "First name", "Last name", "Username", "Gender", "Email", "Active"
    };

    private List<User> users;

    public UserTableModel(List<User> users) {
        setUsers(users);
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        
        return switch (columnIndex) {
            case 0 -> user.getId();
            case 1 -> user.getFirstName();
            case 2 -> user.getLastName();
            case 3 -> user.getUsername();
            case 4 -> user.getGender();
            case 5 -> user.getEmail();
            case 6 -> user.isActive() ? "YES" : "NO";
            default -> null;
        };
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
