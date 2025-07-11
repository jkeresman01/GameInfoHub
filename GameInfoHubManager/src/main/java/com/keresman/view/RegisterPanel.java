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
      initFieldsWithErrorLabels();
      initGenderComboBox();
      hideErrors();
      initRegistrationService();
    } catch (Exception ex) {
      handleInitializationError(ex);
    }
  }

  private void initFieldsWithErrorLabels() {
    fieldsWithErrorLabels =
        Map.of(
            tfLastName, lblErrorLastName,
            tfFirstName, lblErrorFirstName,
            tfUsername, lblErrorUsername,
            tfPassword, lblErrorPassword,
            tfCfmPassword, lblErrorCfmPassword,
            tfEmail, lblErrorEmail);
  }

  private void initGenderComboBox() {
    cbGender.setModel(new DefaultComboBoxModel<>(Gender.values()));
  }

  private void initRegistrationService() throws Exception {
    UserRepository userRepository = RepositoryFactory.getInstance(UserRepository.class);
    Validator<UserRegistrationReq> validator = new UserRegistrationValidator(userRepository);
    registrationService = new UserRegistrationService(userRepository, validator);
  }

  private void handleInitializationError(Exception ex) {
    Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
    MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
    System.exit(1);
  }

  private boolean isFormValid() {
    hideErrors();
    showValidationErrors();
    return areAllFieldsValid();
  }

  private void showValidationErrors() {
    fieldsWithErrorLabels.forEach(
        (field, label) -> {
          if (field.getText().trim().isEmpty()) {
            label.setVisible(true);
          }
        });
  }

  private boolean areAllFieldsValid() {
    return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
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

  private UserRegistrationReq extractFormData() {
    return new UserRegistrationReq(
        tfUsername.getText().trim(),
        tfEmail.getText().trim(),
        String.valueOf(tfPassword.getPassword()),
        String.valueOf(tfCfmPassword.getPassword()),
        tfLastName.getText().trim(),
        tfFirstName.getText().trim(),
        (Gender) cbGender.getSelectedItem());
  }

  private void handleValidationResult(Result<?> result) {
    MessageUtils.showErrorMessage("Registration failed", result.getMessage());

    String msg = result.getMessage();

    if (msg.contains("Username")) lblErrorUsername.setVisible(true);
    if (msg.contains("Email")) lblErrorEmail.setVisible(true);
    if (msg.contains("Passwords")) {
      lblErrorPassword.setVisible(true);
      lblErrorCfmPassword.setVisible(true);
    }
  }

  @Override
  public void btnRegisterActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      MessageUtils.showErrorMessage("ERROR", "Invalid input, all fields must be set");
      return;
    }

    UserRegistrationReq req = extractFormData();
    Result<?> result = registrationService.register(req);

    if (!result.isSuccess()) {
      handleValidationResult(result);
      return;
    }

    MessageUtils.showInformationMessage(
        "Registration successful", "You have successfully registered, go to login page now!!");
    clearRegisterForm();
    redirectToLoginPage();
  }
}
