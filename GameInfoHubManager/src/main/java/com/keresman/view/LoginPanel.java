package com.keresman.view;

import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
import com.keresman.model.User;
import com.keresman.payload.UserLoginReq;
import com.keresman.service.UserLoginService;
import com.keresman.session.SessionManager;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import com.keresman.validator.Validator;
import com.keresman.validator.user.UserLoginValidator;
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
      initLoginService();
    } catch (Exception ex) {
      handleCriticalInitializationFailure(ex);
    }
  }

  private void initValidation() {
    fieldsWithErrorLabels =
        Map.of(
            tfUsername, lblErrorUsername,
            tfPassword, lblErrorPassword);
  }

  private void initLoginService() throws Exception {
    UserRepository userRepository = RepositoryFactory.getInstance(UserRepository.class);
    Validator<UserLoginReq> validator = new UserLoginValidator(userRepository);
    userLoginService = new UserLoginService(userRepository, validator);
  }

  private void handleCriticalInitializationFailure(Exception ex) {
    ex.printStackTrace();
    MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
    MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
    System.exit(1);
  }

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
  }

  private boolean isFormValid() {
    hideErrors();
    fieldsWithErrorLabels.forEach(
        (field, label) -> label.setVisible(field.getText().trim().isEmpty()));
    return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }

  @Override
  public void btnLoginActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      MessageUtils.showWarningMessage("WARNING", "Please fill in all required fields.");
      return;
    }

    processLogin();
  }

  private void processLogin() {
    UserLoginReq request = buildLoginRequest();
    Result<User> result = userLoginService.login(request);

    if (!result.isSuccess()) {
      MessageUtils.showErrorMessage("Login Failed", result.getMessage());
      return;
    }

    handleLoginSuccess(result.getData().get());
  }

  private UserLoginReq buildLoginRequest() {
    String username = tfUsername.getText().trim();
    String password = String.valueOf(tfPassword.getPassword());
    return new UserLoginReq(username, password);
  }

  private void handleLoginSuccess(User user) {
    SessionManager.getInstance().setCurrentUser(user);
    clearLoginForm();
    openMainApplicationWindow();
  }

  private void clearLoginForm() {
    hideErrors();
    fieldsWithErrorLabels.keySet().forEach(field -> field.setText(""));
  }

  private void openMainApplicationWindow() {
    SwingUtilities.invokeLater(
        () -> {
          Window window = SwingUtilities.getWindowAncestor(this);
          if (window != null) {
            window.dispose();
          }
          new GameArticleManager().setVisible(true);
        });
  }
}
