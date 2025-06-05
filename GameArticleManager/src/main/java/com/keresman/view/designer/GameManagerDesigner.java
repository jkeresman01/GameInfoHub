package com.keresman.view.designer;

import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public abstract class GameManagerDesigner extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenu mAbout;
    protected javax.swing.JMenu mHelp;
    protected javax.swing.JMenu mLogout;
    private javax.swing.JMenu mLookAndFeel;
    protected javax.swing.JMenuBar mbMainMenu;
    protected javax.swing.JMenu miAbout;
    protected javax.swing.JMenu miHelp;
    protected javax.swing.JMenu miLogout;
    protected javax.swing.JTabbedPane tpMain;
    // End of variables declaration//GEN-END:variables

  public GameManagerDesigner() {
    initComponents();
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
        mLookAndFeel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Articles");

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

        mLookAndFeel.setText("Look and Feel");
        mbMainMenu.add(mLookAndFeel);

        setJMenuBar(mbMainMenu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  public abstract void miLogoutMouseClicked(MouseEvent evt);
}
