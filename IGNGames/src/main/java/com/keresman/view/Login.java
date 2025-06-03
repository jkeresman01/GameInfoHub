package com.keresman.view;

import com.keresman.view.designer.IGNGamesManagerDesigner;
import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.session.SessionManager;
import com.keresman.utilities.BCryptUtils;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.LoginDesigner;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Login extends LoginDesigner {

    private Map<JTextField, JLabel> validationsFieldsWithErrorLabels;
    private UserRepository userRepository;

    public Login() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
            MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationsFieldsWithErrorLabels = Map.ofEntries(
                Map.entry(tfUsername, lblErrorUsername),
                Map.entry(tfPassword, lblErrorPassword));
    }

    private boolean isFormValid() {
        hideErrors();

        validationsFieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return validationsFieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
    }

    private void initRepository() throws Exception {
        userRepository = RepositoryFactory.getInstance(UserRepository.class);
    }

    private void hideErrors() {
        validationsFieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
    }

    @Override
    public void btnLoginActionPerformed(ActionEvent evt) {
        if (!isFormValid()) {
            MessageUtils.showWarningMessage("WARNING", "You forgot to fill soemthing, please try again!");
            return;
        }

        String username = tfUsername.getText().trim();

        try {
            if (!userRepository.existsByUsername(username)) {
                MessageUtils.showErrorMessage("ERROR", "No user with username: %s".formatted(username));
                return;
            }

            loginUserWithUsername(username);
        } catch (Exception ex) {
            Logger.getLogger(LoginDesigner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loginUserWithUsername(String username) throws Exception {
        String password = new String(tfPassword.getPassword());

        User user = userRepository.findByUsername(username).get();

        if (BCryptUtils.veriftyPassword(password, user.getPasswordHash())) {
            loginUser(user);
        } else {
            MessageUtils.showErrorMessage("Ivalid password", "Ivalid password, try again!!");
        }
    }

    private void loginUser(User user) {
        SessionManager.getInstance().setCurrentUser(user);

        Runnable showMainForm = () -> {
            Window window = SwingUtilities.getWindowAncestor(this);

            if (window != null) {
                window.dispose();
            }

            new IGNGamesManager().setVisible(true);
        };

        SwingUtilities.invokeLater(showMainForm);
    }
}
