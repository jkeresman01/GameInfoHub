package com.keresman.view;

import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
import com.keresman.model.User;
import com.keresman.service.UserService;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import com.keresman.view.designer.ManageUsersPanelDesigner;
import com.keresman.view.model.UserTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ListSelectionModel;

public class ManageUsersPanel extends ManageUsersPanelDesigner {

    private int selectedUserId;
    private UserService userService;
    private UserTableModel userTableModel;

    public ManageUsersPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initUserService();
            initTable();
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
            MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
            System.exit(1);
        }
    }

    private void initUserService() throws Exception {
        UserRepository userRepository = RepositoryFactory.getInstance(UserRepository.class);
        userService = new UserService(userRepository);
    }

    private void initTable() throws Exception {
        tblUsers.setRowHeight(25);
        tblUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblUsers.setAutoCreateRowSorter(true);

        Result<List<User>> result = userService.getAllUsers();

        if (!result.isSuccess()) {
            MessageUtils.showErrorMessage("Error", result.getMessage());
            return;
        }

        userTableModel = new UserTableModel(result.getData().get());
        tblUsers.setModel(userTableModel);
    }

    @Override
    public void tblUsersMouseClicked(MouseEvent evt) {
        int selectedRow = tblUsers.getSelectedRow();
        selectedUserId = (int) userTableModel.getValueAt(selectedRow, 0);

        Result<User> result = userService.getUserById(selectedUserId);

        if (!result.isSuccess()) {
            MessageUtils.showErrorMessage("Error", result.getMessage());
            return;
        }

        User user = result.getData().get();

        tfUsername.setText(user.getUsername());
        tfFirstName.setText(user.getFirstName());
        tfLastName.setText(user.getLastName());
        tfEmail.setText(user.getEmail());
    }

    private void refreshData() {
        Result<List<User>> result = userService.getAllUsers();

        if (!result.isSuccess()) {
            MessageUtils.showErrorMessage("Error", result.getMessage());
            return;
        }

        userTableModel = new UserTableModel(result.getData().get());
        tblUsers.setModel(userTableModel);
    }

    @Override
    public void btnActivateDeactiveProfileActionPerformed(ActionEvent evt) {
        int selectedRow = tblUsers.getSelectedRow();
        selectedUserId = (int) userTableModel.getValueAt(selectedRow, 0);

        Result<User> deactivateProfileResult = userService.deactivateProfileById(selectedUserId);

        if (deactivateProfileResult.isSuccess()) {
            MessageUtils.showInformationMessage("INFO", "User profile deactivated successfully!");
            refreshData();
        }
    }
}
