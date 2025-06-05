package com.keresman.view;

import com.keresman.session.SessionManager;
import com.keresman.view.designer.GameArticleManagerDesigner;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

public class GameArticleManager extends GameArticleManagerDesigner {

    private static final String PROFILE = "Profile";
    private static final String FAVOURITES = "Favourites";
    private static final String GAMES = "Games";
    private static final String DEVELOPERS = "Developers";
    private static final String ARTICLES = "Articles";
    private static final String ADMIN = "Admin";

    public GameArticleManager() {
        super();
        initPanels();
    }

    private void initPanels() {
        if (SessionManager.getInstance().getCurrentUser().isAdmin()) {
            tpMain.add(ADMIN, new AdminPanel());
        }

        tpMain.add(GAMES, new GamesPanel());
        tpMain.add(ARTICLES, new ArticlesPanel());
        tpMain.add(DEVELOPERS, new DevelopersPanel());
        tpMain.add(FAVOURITES, new FavouritesPanel());
        tpMain.add(PROFILE, new ProfilePanel());
    }

    @Override
    public void miLogoutMouseClicked(MouseEvent evt) {
        SessionManager.getInstance().clear();
        dispose();
        SwingUtilities.invokeLater(() -> new WelcomeScreen().setVisible(true));
    }
}
