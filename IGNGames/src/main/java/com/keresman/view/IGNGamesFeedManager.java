package com.keresman.view;

import com.keresman.session.SessionManager;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class IGNGamesFeedManager extends JFrame {

    private static final String PROFILE = "Profile";
    private static final String FAVOURITES = "Favourites";
    private static final String UPLOAD_GAMES = "Upload Games";
    private static final String EDIT_GAMES = "Edit Games";
    private static final String VIEW_GAMES = "View Games";
    private static final String ADMIN = "Admin";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu mAbout;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenu mLogout;
    private javax.swing.JMenuBar mbMainMenu;
    private javax.swing.JMenu miAbout;
    private javax.swing.JMenu miHelp;
    private javax.swing.JMenu miLogout;
    private javax.swing.JTabbedPane tpMain;
    // End of variables declaration//GEN-END:variables

    public IGNGamesFeedManager() {
        initComponents();
        initPanels();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMain = new javax.swing.JTabbedPane();
        mbMainMenu = new javax.swing.JMenuBar();
        mAbout = new javax.swing.JMenu();
        miAbout = new javax.swing.JMenu();
        mHelp = new javax.swing.JMenu();
        miHelp = new javax.swing.JMenu();
        mLogout = new javax.swing.JMenu();
        miLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IGN Games");

        tpMain.setBackground(new java.awt.Color(24, 24, 24));
        tpMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tpMain.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpMain.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpMain.setMinimumSize(new java.awt.Dimension(1480, 800));
        tpMain.setPreferredSize(new java.awt.Dimension(1480, 800));
        getContentPane().add(tpMain, java.awt.BorderLayout.CENTER);

        mAbout.setText("About");

        miAbout.setText("About");
        mAbout.add(miAbout);

        mbMainMenu.add(mAbout);

        mHelp.setText("Help");

        miHelp.setText("Help");
        mHelp.add(miHelp);

        mbMainMenu.add(mHelp);

        mLogout.setText("Logout");

        miLogout.setText("Logout");
        miLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miLogoutMouseClicked(evt);
            }
        });
        mLogout.add(miLogout);

        mbMainMenu.add(mLogout);

        setJMenuBar(mbMainMenu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miLogoutMouseClicked(MouseEvent evt) { // GEN-FIRST:event_miLogoutMouseClicked
        SessionManager.getInstance().clear();
        dispose();
        SwingUtilities.invokeLater(() -> new IGNGamesWelcome().setVisible(true));
    } // GEN-LAST:event_miLogoutMouseClicked

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
}
