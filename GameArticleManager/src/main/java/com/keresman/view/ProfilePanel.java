package com.keresman.view;

import com.keresman.view.designer.ProfilePanelDesigner;
import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserUpdateReq;
import com.keresman.service.UserService;
import com.keresman.session.SessionManager;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProfilePanel extends ProfilePanelDesigner {

    private Map<JTextField, JLabel> validationsFieldsWithErrorLabels;
    private UserService userService;

    public ProfilePanel() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            fillForm();
            initUserService();
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
                Map.entry(tfFirstName, lblErrorFirstName),
                Map.entry(tfLastName, lblErrorLastName),
                Map.entry(tfEmail, lblErrorEmail));
    }

    private void hideErrors() {
        validationsFieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
    }

    private boolean isFormValid() {
        hideErrors();

        validationsFieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return validationsFieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
    }

    private void fillForm() {
        User user = SessionManager.getInstance().getCurrentUser();

        tfFirstName.setText(user.getFirstName());
        tfLastName.setText(user.getLastName());
        tfEmail.setText(user.getEmail());
        tfUsername.setText(user.getUsername());

        lblProfileImage.setIcon(new ImageIcon(getClass().getResource(user.getPicturePath())));
    }

    private void initUserService() throws Exception {
        var userRepository = RepositoryFactory.getInstance(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Override
    public void btnUpdateProfileActionPerformed(ActionEvent evt) {

        if (!isFormValid()) {
            MessageUtils.showErrorMessage("ERROR", "Invalid input, all fields must be set");
            return;
        }

        User user = SessionManager.getInstance().getCurrentUser();

        String firstName = tfFirstName.getText().trim();
        String lastName = tfLastName.getText().trim();
        String username = tfUsername.getText().trim();
        String email = tfEmail.getText().trim();

        var userUpdateReq = new UserUpdateReq(user.getId(), username, email, firstName, lastName);

        Result<Void> userUpdateResult = userService.updateUser(userUpdateReq);

        if (!userUpdateResult.isSuccess()) {
            MessageUtils.showErrorMessage("Update failed", userUpdateResult.getMessage());
            return;
        }

        MessageUtils.showInformationMessage("Update Successful", "Profile updated successfully!");
    }

}
