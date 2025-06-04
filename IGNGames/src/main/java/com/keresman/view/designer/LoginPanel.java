package com.keresman.view.designer;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserLoginReq;
import com.keresman.service.UserLoginService;
import com.keresman.session.SessionManager;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.ValidationResult;
import com.keresman.validator.login.UserLoginValidator;
import com.keresman.view.GameManager;
import com.keresman.view.designer.LoginPanelDesigner;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginPanel extends LoginPanelDesigner {

    private Map<JTextField, JLabel> fieldsWithErrorLabels;
    private UserLoginService userLoginService;

    public LoginPanel() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initUserLoginService();
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
            MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
            System.exit(1);
        }
    }

    private void initValidation() {
        fieldsWithErrorLabels
                = Map.ofEntries(
                        Map.entry(tfUsername, lblErrorUsername), Map.entry(tfPassword, lblErrorPassword));
    }

    private void hideErrors() {
        fieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
    }

    private void initUserLoginService() throws Exception {
        UserRepository userRepository = RepositoryFactory.getInstance(UserRepository.class);
        UserLoginValidator userLoginValidator = new UserLoginValidator(userRepository);

        userLoginService = new UserLoginService(userRepository, userLoginValidator);
    }

    @Override
    public void btnLoginActionPerformed(ActionEvent evt) {
        if (!isFormValid()) {
            MessageUtils.showWarningMessage("WARNING", "You forgot to fill soemthing, please try again!");
            return;
        }

        String username = tfUsername.getText().trim();
        String password = new String(tfPassword.getPassword());

        var userLoginReq = new UserLoginReq(username, password);

        ValidationResult<User> result = userLoginService.login(userLoginReq);

        if (!result.isSuccess()) {
            MessageUtils.showErrorMessage("Login Failed", result.getMessage());
            return;
        }

        User loggedInUser = result.getData().get();
        SessionManager.getInstance().setCurrentUser(loggedInUser);

        clearLoginForm();
        openMainApplicationWindow();
    }

    private boolean isFormValid() {
        hideErrors();

        fieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
    }

    private void clearLoginForm() {
        hideErrors();

        fieldsWithErrorLabels.keySet().forEach(field -> field.setText(""));
    }

    private void openMainApplicationWindow() {

        Runnable showMainForm = () -> {
            Window window = SwingUtilities.getWindowAncestor(this);

            if (window != null) {
                window.dispose();
            }

            new GameManager().setVisible(true);
        };

        SwingUtilities.invokeLater(showMainForm);
    }
}
