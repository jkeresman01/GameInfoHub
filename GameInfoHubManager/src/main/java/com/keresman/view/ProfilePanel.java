package com.keresman.view;

import com.keresman.dal.*;
import com.keresman.model.Article;
import com.keresman.model.Game;
import com.keresman.model.User;
import com.keresman.payload.UserUpdateReq;
import com.keresman.service.UserService;
import com.keresman.session.SessionManager;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import com.keresman.view.designer.ProfilePanelDesigner;
import java.awt.event.ActionEvent;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProfilePanel extends ProfilePanelDesigner {

  private Map<JTextField, JLabel> fieldsWithErrorLabels;
  private UserService userService;

  private FavoriteGamesRepository favoriteGamesRepository;
  private FavouriteArticleRepostiory favouriteArticleRepostiory;

  private final DefaultListModel<Game> favGamesModel = new DefaultListModel<>();
  private final DefaultListModel<Article> favArticlesModel = new DefaultListModel<>();

  public ProfilePanel() {
    super();
    init();
  }

  private void init() {
    try {
      initValidation();
      hideErrors();
      initRepositories();
      initUserService();
      populateUserForm();
      loadFavoriteLists();
    } catch (Exception ex) {
      handleInitializationError(ex);
    }
  }

  private void initValidation() {
    fieldsWithErrorLabels =
        Map.of(
            tfUsername, lblErrorUsername,
            tfFirstName, lblErrorFirstName,
            tfLastName, lblErrorLastName,
            tfEmail, lblErrorEmail);
  }

  private void initRepositories() throws Exception {
    favoriteGamesRepository = RepositoryFactory.getInstance(FavoriteGamesRepository.class);
    favouriteArticleRepostiory = RepositoryFactory.getInstance(FavouriteArticleRepostiory.class);
  }

  private void initUserService() throws Exception {
    var userRepository = RepositoryFactory.getInstance(UserRepository.class);
    userService = new UserService(userRepository);
  }

  private void hideErrors() {
    fieldsWithErrorLabels.values().forEach(label -> label.setVisible(false));
  }

  private boolean isFormValid() {
    hideErrors();
    showValidationErrorsIfEmpty();
    return areAllFieldsValid();
  }

  private void showValidationErrorsIfEmpty() {
    fieldsWithErrorLabels.forEach(
        (field, label) -> label.setVisible(field.getText().trim().isEmpty()));
  }

  private boolean areAllFieldsValid() {
    return fieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }

  private void populateUserForm() {
    User user = SessionManager.getInstance().getCurrentUser();

    tfFirstName.setText(user.getFirstName());
    tfLastName.setText(user.getLastName());
    tfEmail.setText(user.getEmail());
    tfUsername.setText(user.getUsername());

    lblProfileImage.setIcon(new ImageIcon(getClass().getResource(user.getPicturePath())));
  }

  private void loadFavoriteLists() throws Exception {
    User user = SessionManager.getInstance().getCurrentUser();

    favGamesModel.clear();
    favoriteGamesRepository.findByUserId(user.getId()).forEach(favGamesModel::addElement);
    lsFavGames.setModel(favGamesModel);

    favArticlesModel.clear();
    favouriteArticleRepostiory.findByUserId(user.getId()).forEach(favArticlesModel::addElement);
    lsFavArticles.setModel(favArticlesModel);
  }

  private void handleInitializationError(Exception ex) {
    ex.printStackTrace();
    MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
    MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
    System.exit(1);
  }

  @Override
  public void btnUpdateProfileActionPerformed(ActionEvent evt) {
    if (!isFormValid()) {
      MessageUtils.showErrorMessage("ERROR", "Invalid input, all fields must be set");
      return;
    }

    updateUserProfile();
  }

  private void updateUserProfile() {
    User user = SessionManager.getInstance().getCurrentUser();

    String firstName = tfFirstName.getText().trim();
    String lastName = tfLastName.getText().trim();
    String username = tfUsername.getText().trim();
    String email = tfEmail.getText().trim();

    var updateRequest = new UserUpdateReq(user.getId(), username, email, firstName, lastName);
    Result<Void> result = userService.updateUser(updateRequest);

    handleUpdateResult(result);
  }

  private void handleUpdateResult(Result<Void> result) {
    if (!result.isSuccess()) {
      MessageUtils.showErrorMessage("Update failed", result.getMessage());
    } else {
      MessageUtils.showInformationMessage("Update Successful", "Profile updated successfully!");
    }
  }
}
