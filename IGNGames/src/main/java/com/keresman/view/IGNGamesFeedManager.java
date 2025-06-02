package com.keresman.view;

import com.keresman.session.SessionManager;
import javax.swing.SwingUtilities;

public class IGNGamesFeedManager extends javax.swing.JFrame {

    public IGNGamesFeedManager() {
        initComponents();
        initPanels();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMain = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
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

        jMenuBar1.add(mAbout);

        mHelp.setText("Help");

        miHelp.setText("Help");
        mHelp.add(miHelp);

        jMenuBar1.add(mHelp);

        mLogout.setText("Logout");

        miLogout.setText("Logout");
        miLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miLogoutMouseClicked(evt);
            }
        });
        mLogout.add(miLogout);

        jMenuBar1.add(mLogout);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miLogoutMouseClicked
        // TODO add your handling code here:
        SessionManager.getInstance().clear();
        dispose();
        SwingUtilities.invokeLater(() -> new IGNGamesWelcome().setVisible(true));
    }//GEN-LAST:event_miLogoutMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mAbout;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenu mLogout;
    private javax.swing.JMenu miAbout;
    private javax.swing.JMenu miHelp;
    private javax.swing.JMenu miLogout;
    private javax.swing.JTabbedPane tpMain;
    // End of variables declaration//GEN-END:variables

    private void initPanels() {
        tpMain.add("View Games", new GamesPanel());
        tpMain.add("Edit Games", new EditGamesPanel());
        tpMain.add("Upload Games", new UploadGamesPanel());
        tpMain.add("Favourites", new FavouritesPanel());
        tpMain.add("Profile", new ProfilePanel());

        if (SessionManager.getInstance().getCurrentUser().isAdmin()) {
            tpMain.add("Admin", new AdminPanel());
        }
    }
}
