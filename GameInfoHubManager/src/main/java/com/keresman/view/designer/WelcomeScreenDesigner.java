package com.keresman.view.designer;

import javax.swing.JFrame;

public abstract class WelcomeScreenDesigner extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel lblWelcomeImg;
    protected javax.swing.JTabbedPane tpLoginRegister;
    // End of variables declaration//GEN-END:variables

  protected WelcomeScreenDesigner() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpLoginRegister = new javax.swing.JTabbedPane();
        lblWelcomeImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GameArticles");

        tpLoginRegister.setBackground(new java.awt.Color(24, 24, 24));
        tpLoginRegister.setForeground(new java.awt.Color(255, 255, 255));
        tpLoginRegister.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpLoginRegister.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tpLoginRegister.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tpLoginRegister.setMinimumSize(new java.awt.Dimension(200, 10));
        tpLoginRegister.setPreferredSize(new java.awt.Dimension(400, 760));
        getContentPane().add(tpLoginRegister, java.awt.BorderLayout.LINE_START);

        lblWelcomeImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/welcome_11.jpg"))); // NOI18N
        lblWelcomeImg.setMaximumSize(new java.awt.Dimension(1081, 780));
        lblWelcomeImg.setMinimumSize(new java.awt.Dimension(1081, 780));
        lblWelcomeImg.setPreferredSize(new java.awt.Dimension(1081, 780));
        getContentPane().add(lblWelcomeImg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
}
