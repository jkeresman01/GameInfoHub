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

  private static final int USER_TABLE_ROW_HEIGHT = 25;

  private int selectedUserId;
  private UserService userService;
  private UserTableModel userTableModel;

  public ManageUsersPanel() {
    super();
    init();
  }

  private void init() {
    try {
      initService();
      setupTable();
      loadUsersToTable();
    } catch (Exception ex) {
      handleCriticalInitError(ex);
    }
  }

  private void initService() throws Exception {
    userService = new UserService(RepositoryFactory.getInstance(UserRepository.class));
  }

  private void setupTable() {
    tblUsers.setRowHeight(USER_TABLE_ROW_HEIGHT);
    tblUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblUsers.setAutoCreateRowSorter(true);
  }

  private void loadUsersToTable() {
    Result<List<User>> result = userService.getAllUsers();

    if (!result.isSuccess()) {
      handleError("Error loading users", result.getMessage());
      return;
    }

    userTableModel = new UserTableModel(result.getData().get());
    tblUsers.setModel(userTableModel);
  }

  private void handleCriticalInitError(Exception ex) {
    ex.printStackTrace();
    MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
    MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
    System.exit(1);
  }

  private void handleError(String title, String message) {
    MessageUtils.showErrorMessage(title, message);
  }

  @Override
  public void tblUsersMouseClicked(MouseEvent evt) {
    int selectedRow = tblUsers.getSelectedRow();
    if (selectedRow == -1) {
      return;
    }

    selectedUserId = (int) userTableModel.getValueAt(selectedRow, 0);
    loadUserDetails(selectedUserId);
  }

  private void loadUserDetails(int userId) {
    Result<User> result = userService.getUserById(userId);

    if (!result.isSuccess()) {
      handleError("Error", result.getMessage());
      return;
    }

    populateUserForm(result.getData().get());
  }

  private void populateUserForm(User user) {
    tfUsername.setText(user.getUsername());
    tfFirstName.setText(user.getFirstName());
    tfLastName.setText(user.getLastName());
    tfEmail.setText(user.getEmail());
  }

  @Override
  public void btnActivateDeactiveProfileActionPerformed(ActionEvent evt) {
    int selectedRow = tblUsers.getSelectedRow();
    if (selectedRow == -1) {
      MessageUtils.showWarningMessage("Warning", "Please select a user.");
      return;
    }

    selectedUserId = (int) userTableModel.getValueAt(selectedRow, 0);
    toggleUserActivation(selectedUserId);
  }

  private void toggleUserActivation(int userId) {
    Result<User> result = userService.deactivateProfileById(userId);

    if (!result.isSuccess()) {
      handleError("Activation Failed", result.getMessage());
      return;
    }

    MessageUtils.showInformationMessage("INFO", "User profile deactivated successfully!");
    loadUsersToTable();
  }
}
