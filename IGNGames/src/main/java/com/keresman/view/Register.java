package com.keresman.view;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.Gender;
import com.keresman.model.User;
import com.keresman.utilities.BCryptUtils;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.designer.RegisterDesigner;
import java.awt.event.ActionEvent;
import java.util.Arrays;
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

  private UserRepository userRepository;
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
      initRepository();
    } catch (Exception ex) {
      Logger.getLogger(RegisterDesigner.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
      System.exit(1);
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

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
  }

  private void initRepository() throws Exception {
    userRepository = RepositoryFactory.getInstance(UserRepository.class);
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

  private void initGenders() {
    cbGender.setModel(new DefaultComboBoxModel<>(Gender.values()));
  }

  private void switchToLoginPage() {
    JTabbedPane tabs = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
    if (tabs != null) {
      tabs.setSelectedIndex(LOGIN_PAGE_INDEX);
    }
  }

  @Override
  public void btnRegisterActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      MessageUtils.showErrorMessage("ERROR", "Invalid input, all fields must be set");
      return;
    }

    String username = tfUsername.getText();
    String email = tfEmail.getText();
    String password = Arrays.toString(tfPassword.getPassword());
    String cfmPassword = Arrays.toString(tfCfmPassword.getPassword());

    try {
      if (userRepository.existsByUsername(username)) {
        MessageUtils.showErrorMessage("Registration unsucessfull", "Username already taken!");
        lblErrorUsername.setVisible(true);
        return;
      }

      if (userRepository.existsByEmail(email)) {
        MessageUtils.showErrorMessage("Registration unsucessfull", "Email already in use!!");
        lblErrorEmail.setVisible(true);
        return;
      }

      if (!password.equals(cfmPassword)) {
        MessageUtils.showErrorMessage("Password mismatch", "Dobule check your password!!!");
        lblErrorCfmPassword.setVisible(true);
        lblErrorPassword.setVisible(true);
        return;
      }

    } catch (Exception ex) {
      Logger.getLogger(RegisterDesigner.class.getName()).log(Level.SEVERE, null, ex);
    }

    User user =
        new User(
            username,
            BCryptUtils.hashPassword(password),
            tfFirstName.getText(),
            tfLastName.getText(),
            tfEmail.getText());

    try {
      userRepository.save(user);
      MessageUtils.showInformationMessage(
          "Registration successfull", "You have successffully registered, go to login page now!!");

      clearForm();
      switchToLoginPage();

    } catch (Exception ex) {
      Logger.getLogger(RegisterDesigner.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
