package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
import com.keresman.model.Article;
import com.keresman.model.User;
import com.keresman.parser.rss.GameArticleParser;
import com.keresman.service.UserService;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import com.keresman.view.designer.AdminPanelDesigner;
import com.keresman.view.model.UserTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

public class AdminPanel extends AdminPanelDesigner {

    private int selectedUserId;
    private UserService userService;
    private UserTableModel userTableModel;

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
        lblUsername.setText(user.getUsername());
    }

    @Override
    public void btnLoadDbActionPerformed(ActionEvent evt) {
        try {
            ArticleRepository articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
            List<Article> articles = articleRepository.findAll();

            if (articles.isEmpty()) {
                articles = GameArticleParser.parse();
                articleRepository.saveAll(articles);
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
