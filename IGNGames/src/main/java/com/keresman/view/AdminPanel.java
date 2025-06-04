package com.keresman.view;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.AdminPanelDesigner;
import com.keresman.view.model.UserTableModel;
import java.awt.event.MouseEvent;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

public class AdminPanel extends AdminPanelDesigner {

    private UserRepository userRepository;
    private UserTableModel userTableModel;
    private int selectedUserId;

    public AdminPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initRepository();
            initTable();
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Failed to initialize the form!");
        }
    }

    private void initRepository() throws Exception {
        userRepository = RepositoryFactory.getInstance(UserRepository.class);
    }

    private void initTable() throws Exception {
        tblUsers.setRowHeight(25);
        tblUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblUsers.setAutoCreateRowSorter(true);

        userTableModel = new UserTableModel(userRepository.findAll());
        tblUsers.setModel(userTableModel);
    }

    @Override
    public void tblUsersMouseClicked(MouseEvent evt) {
        int selectedRow = tblUsers.getSelectedRow();
        selectedUserId = (int) userTableModel.getValueAt(selectedRow, 0);

        try {
            Optional<User> optUser = userRepository.findById(selectedUserId);

            if (optUser.isPresent()) {
                lblUsername.setText(optUser.get().getUsername());
            }

        } catch (Exception ex) {
            Logger.getLogger(AdminPanelDesigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
