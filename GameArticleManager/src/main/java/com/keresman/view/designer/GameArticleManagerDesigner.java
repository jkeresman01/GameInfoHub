package com.keresman.view.designer;

import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public abstract class GameArticleManagerDesigner extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JMenu mAbout;
    protected javax.swing.JMenu mExport;
    protected javax.swing.JMenu mHelp;
    protected javax.swing.JMenu mLogout;
    private javax.swing.JMenu mLookAndFeel;
    protected javax.swing.JMenuBar mbMainMenu;
    protected javax.swing.JMenu miAbout;
    protected javax.swing.JMenu miExportJson;
    private javax.swing.JMenu miExportXML;
    protected javax.swing.JMenu miHelp;
    protected javax.swing.JMenu miLogout;
    protected javax.swing.JTabbedPane tpMain;
    // End of variables declaration//GEN-END:variables

  public GameArticleManagerDesigner() {
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
        mLookAndFeel = new javax.swing.JMenu();
        mExport = new javax.swing.JMenu();
        miExportXML = new javax.swing.JMenu();
        miExportJson = new javax.swing.JMenu();
        mLogout = new javax.swing.JMenu();
        miLogout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Articles");

        tpMain.setBackground(new java.awt.Color(24, 24, 24));
        tpMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tpMain.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpMain.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tpMain.setMinimumSize(new java.awt.Dimension(1480, 800));
        tpMain.setPreferredSize(new java.awt.Dimension(1480, 800));
        getContentPane().add(tpMain, java.awt.BorderLayout.CENTER);

        mbMainMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mbMainMenu.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N

        mAbout.setText("About");

        miAbout.setText("About");
        mAbout.add(miAbout);

        mbMainMenu.add(mAbout);

        mHelp.setText("Help");

        miHelp.setText("Help");
        mHelp.add(miHelp);

        mbMainMenu.add(mHelp);

        mLookAndFeel.setText("Look and Feel");
        mbMainMenu.add(mLookAndFeel);

        mExport.setText("Export");

        miExportXML.setText("XML export");
        miExportXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miExportXMLMouseClicked(evt);
            }
        });
        mExport.add(miExportXML);

        miExportJson.setText("JSON export");
        miExportJson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miExportJsonMouseClicked(evt);
            }
        });
        mExport.add(miExportJson);

        mbMainMenu.add(mExport);

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

    private void miExportXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miExportXMLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_miExportXMLMouseClicked

    private void miExportJsonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miExportJsonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_miExportJsonMouseClicked

  public abstract void miLogoutMouseClicked(MouseEvent evt);
}
