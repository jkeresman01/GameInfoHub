package com.keresman.view;

import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
import com.keresman.model.Gender;
import com.keresman.payload.UserRegistrationReq;
import com.keresman.service.UserRegistrationService;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import com.keresman.validator.user.UserRegistrationValidator;
import com.keresman.view.designer.RegisterPanelDesigner;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

public class RegisterPanel extends RegisterPanelDesigner {

  private static final int LOGIN_PAGE_INDEX = 0;

  private UserRegistrationService registrationService;
  private Map<JTextComponent, JLabel> fieldsWithErrorLabels;

  public RegisterPanel() {
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
      handleInitializationError(ex);
    }
  }

  private void initValidation() {
    fieldsWithErrorLabels =
        Map.ofEntries(
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
    Validator<UserRegistrationReq> userRegistrationValidator =
        new UserRegistrationValidator(userRepository);

    registrationService = new UserRegistrationService(userRepository, userRegistrationValidator);
  }

  private void handleInitializationError(Exception ex) {
    Logger.getLogger(RegisterPanelDesigner.class.getName()).log(Level.SEVERE, null, ex);
    MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
    System.exit(1);
  }

  @Override
  public void btnRegisterActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      MessageUtils.showErrorMessage("ERROR", "Invalid input, all fields must be set");
      return;
    }

    String username = tfUsername.getText().trim();
    String firstName = tfFirstName.getText().trim();
    String lastName = tfLastName.getText().trim();
    String email = tfEmail.getText().trim();
    String password = String.valueOf(tfPassword.getPassword());
    String cfmPassword = String.valueOf(tfCfmPassword.getPassword());
    Gender gender = (Gender) cbGender.getSelectedItem();

    var registerReq =
        new UserRegistrationReq(
            username, email, password, cfmPassword, lastName, firstName, gender);

    Result validationResult = registrationService.register(registerReq);

    if (!validationResult.isSuccess()) {
      MessageUtils.showErrorMessage("Registration failed", validationResult.getMessage());
      showFieldErrors(validationResult.getMessage());
      return;
    }

    MessageUtils.showInformationMessage(
        "Registration successful", "You have successfully registered, go to login page now!!");

    clearRegisterForm();
    redirectToLoginPage();
  }

  private boolean isFormValid() {
    hideErrors();

    fieldsWithErrorLabels.forEach(
        (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

    return fieldsWithErrorLabels.values().stream().noneMatch(errLabel -> errLabel.isVisible());
  }

  private void clearRegisterForm() {
    hideErrors();

    fieldsWithErrorLabels.keySet().forEach(field -> field.setText(""));
  }

  private void redirectToLoginPage() {
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
