package com.keresman.view;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.service.UserService;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.ValidationResult;
import com.keresman.view.designer.AdminPanelDesigner;
import com.keresman.view.model.UserTableModel;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ListSelectionModel;

public class AdminPanel extends AdminPanelDesigner {

    private UserService userService;
    private UserTableModel userTableModel;
    private int selectedUserId;

    public AdminPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initUserService();
            initTable();
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Failed to initialize the form!");
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

        ValidationResult<List<User>> result = userService.getAllUsers();

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

        ValidationResult<User> result = userService.getUserById(selectedUserId);

        if (!result.isSuccess()) {
            MessageUtils.showErrorMessage("Error", result.getMessage());
            return;
        }

        User user = result.getData().get();
        lblUsername.setText(user.getUsername());
    }

}
