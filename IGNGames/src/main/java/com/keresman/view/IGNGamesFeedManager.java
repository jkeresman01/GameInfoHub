package com.keresman.view;

import com.keresman.view.admin.AdminPanel;
import com.keresman.view.games.FavouritesPanel;
import com.keresman.view.games.UploadGamesPanel;
import com.keresman.view.games.GamesPanel;
import com.keresman.view.games.EditGamesPanel;
import com.keresman.view.profile.ProfilePanel;

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
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IGN Games");

        tpMain.setBackground(new java.awt.Color(24, 24, 24));
        tpMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tpMain.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpMain.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpMain.setMinimumSize(new java.awt.Dimension(1480, 800));
        tpMain.setPreferredSize(new java.awt.Dimension(1480, 800));
        getContentPane().add(tpMain, java.awt.BorderLayout.CENTER);

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane tpMain;
    // End of variables declaration//GEN-END:variables

    private void initPanels() {
        tpMain.add("View Games", new GamesPanel());
        tpMain.add("Edit Games", new EditGamesPanel());
        tpMain.add("Upload Games", new UploadGamesPanel());
        tpMain.add("Favourites", new FavouritesPanel());
        tpMain.add("Profile", new ProfilePanel());
        tpMain.add("Admin", new AdminPanel());
    }
}
