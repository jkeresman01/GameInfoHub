package com.keresman.view;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.payload.UserRegistrationReq;
import com.keresman.model.Gender;
import com.keresman.service.UserRegistrationService;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.ValidationResult;
import com.keresman.validator.register.UserRegistrationValidator;
import com.keresman.view.designer.RegisterDesigner;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

public class Register extends RegisterDesigner {

    private static final int LOGIN_PAGE_INDEX = 0;

    private UserRegistrationService registrationService;
    private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

    public Register() {
        super();
        init();
    }

    private void init() {
        try {
            initValidation();
            initGenders();
            hideErrors();
            initRegistrationService();
        } catch (Exception ex) {
            Logger.getLogger(RegisterDesigner.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        fieldsWithErrorLabels
                = Map.ofEntries(
                        Map.entry(tfLastName, lblErrorLastName),
                        Map.entry(tfFirstName, lblErrorFirstName),
                        Map.entry(tfUsername, lblErrorUsername),
                        Map.entry(tfPassword, lblErrorPassword),
                        Map.entry(tfCfmPassword, lblErrorCfmPassword),
                        Map.entry(tfEmail, lblErrorEmail));
    }

    private void initGenders() {
        cbGender.setModel(new DefaultComboBoxModel<>(Gender.values()));
    }

    private void hideErrors() {
        fieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
    }

    private void initRegistrationService() throws Exception {
        UserRepository userRepository = RepositoryFactory.getInstance(UserRepository.class);
        UserRegistrationValidator userRegistrationValidator = new UserRegistrationValidator(userRepository);

        registrationService = new UserRegistrationService(userRepository, userRegistrationValidator);
    }

    @Override
    public void btnRegisterActionPerformed(ActionEvent evt) {
        if (!isFormValid()) {
            MessageUtils.showErrorMessage("ERROR", "Invalid input, all fields must be set");
            return;
        }

        UserRegistrationReq registerReq = new UserRegistrationReq(
                tfUsername.getText(),
                tfEmail.getText(),
                new String(tfPassword.getPassword()),
                new String(tfCfmPassword.getPassword()),
                tfFirstName.getText(),
                tfLastName.getText()
        );

        ValidationResult validationResult = registrationService.register(registerReq);

        if (!validationResult.isSuccess()) {
            MessageUtils.showErrorMessage("Registration failed", validationResult.getMessage());
            showFieldErrors(validationResult.getMessage());
            return;
        }

        MessageUtils.showInformationMessage("Registration successful", "You have successfully registered, go to login page now!!");
        clearForm();
        switchToLoginPage();
    }

    private boolean isFormValid() {
        hideErrors();

        fieldsWithErrorLabels.forEach(
                (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

        return fieldsWithErrorLabels.values().stream().noneMatch(errLabel -> errLabel.isVisible());
    }

    private void clearForm() {
        hideErrors();

        fieldsWithErrorLabels.keySet().forEach(field -> field.setText(""));
    }

    private void switchToLoginPage() {
        JTabbedPane tabs = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
        if (tabs != null) {
            tabs.setSelectedIndex(LOGIN_PAGE_INDEX);
        }
    }

    private void showFieldErrors(String message) {
        if (message.contains("Username")) {
            lblErrorUsername.setVisible(true);
        }

        if (message.contains("Email")) {
            lblErrorEmail.setVisible(true);
        }

        if (message.contains("Passwords")) {
            lblErrorPassword.setVisible(true);
            lblErrorCfmPassword.setVisible(true);
        }
    }
}
