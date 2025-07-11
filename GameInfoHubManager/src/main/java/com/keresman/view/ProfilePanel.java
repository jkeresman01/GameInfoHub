package com.keresman.view;

import com.keresman.dal.FavoriteGamesRepository;
import com.keresman.dal.FavouriteArticleRepostiory;
import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
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

  private Map<JTextField, JLabel> validationsFieldsWithErrorLabels;
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
      fillForm();
      loadListModels();
    } catch (Exception ex) {
      ex.printStackTrace();
      MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
      MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
      System.exit(1);
    }
  }

  private void initRepositories() throws Exception {
    favoriteGamesRepository = RepositoryFactory.getInstance(FavoriteGamesRepository.class);
    favouriteArticleRepostiory = RepositoryFactory.getInstance(FavouriteArticleRepostiory.class);
  }

  private void loadListModels() throws Exception {
    User user = SessionManager.getInstance().getCurrentUser();

    favGamesModel.clear();
    favoriteGamesRepository.findByUserId(user.getId()).forEach(favGamesModel::addElement);
    lsFavGames.setModel(favGamesModel);

    favArticlesModel.clear();
    favouriteArticleRepostiory.findByUserId(user.getId()).forEach(favArticlesModel::addElement);
    lsFavArticles.setModel(favArticlesModel);
  }

  private void initValidation() {
    validationsFieldsWithErrorLabels =
        Map.ofEntries(
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
