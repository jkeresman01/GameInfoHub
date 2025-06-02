package com.keresman.view.model;

import com.keresman.model.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {

    private static final String[] COLUMS = {"id", "first name", "last name", "username", "gender", "email", "path"};

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
        switch (columnIndex) {
            case 0:
                return users.get(rowIndex).getUserId();
            case 1:
                return users.get(rowIndex).getFirstName();
            case 2:
                return users.get(rowIndex).getLastName();
            case 3:
                return users.get(rowIndex).getUsername();
            case 4:
                return users.get(rowIndex).getGender();
            case 5:
                return users.get(rowIndex).getEmail();
            case 6:
                return users.get(rowIndex).getPicturePath();
            default:
                throw new AssertionError();
        }
    }

    public void setUsers(List<User> users) {
        this.users = users;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMS[column];
    }
}
