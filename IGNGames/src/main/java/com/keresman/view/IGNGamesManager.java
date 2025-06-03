package com.keresman.view;

import com.keresman.session.SessionManager;
import com.keresman.view.designer.IGNGamesManagerDesigner;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class IGNGamesManager extends IGNGamesManagerDesigner {

  private static final String PROFILE = "Profile";
  private static final String FAVOURITES = "Favourites";
  private static final String UPLOAD_GAMES = "Upload Games";
  private static final String EDIT_GAMES = "Edit Games";
  private static final String VIEW_GAMES = "View Games";
  private static final String ADMIN = "Admin";

  public IGNGamesManager() {
    super();
    initPanels();
  }

  private void initPanels() {
    if (SessionManager.getInstance().getCurrentUser().isAdmin()) {
      tpMain.add(ADMIN, new AdminPanel());
    }

    tpMain.add(VIEW_GAMES, new GamesPanel());
    tpMain.add(EDIT_GAMES, new EditGamesPanel());
    tpMain.add(UPLOAD_GAMES, new UploadGamesPanel());
    tpMain.add(FAVOURITES, new FavouritesPanel());
    tpMain.add(PROFILE, new ProfilePanel());
  }

  @Override
  public void miLogoutMouseClicked(MouseEvent evt) {
    SessionManager.getInstance().clear();
    dispose();
    SwingUtilities.invokeLater(() -> new IGNGamesWelcome().setVisible(true));
  }
}
