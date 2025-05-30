package com.keresman.view.welcome;

import com.keresman.view.login.LoginPanel;
import com.keresman.view.register.RegisterPanel;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public class IGNGamesWelcome extends javax.swing.JFrame {

    private static final String REGISTER = "Register";
    private static final String LOGIN = "Login";

    public IGNGamesWelcome() {
        initComponents();
        initPanels();
        initUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpLoginRegister = new javax.swing.JTabbedPane();
        lblWelcomImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IGN Games");

        tpLoginRegister.setBackground(new java.awt.Color(24, 24, 24));
        tpLoginRegister.setForeground(new java.awt.Color(255, 255, 255));
        tpLoginRegister.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpLoginRegister.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        tpLoginRegister.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tpLoginRegister.setMinimumSize(new java.awt.Dimension(200, 10));
        tpLoginRegister.setPreferredSize(new java.awt.Dimension(400, 760));
        getContentPane().add(tpLoginRegister, java.awt.BorderLayout.LINE_START);

        lblWelcomImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/welcome_11.jpg"))); // NOI18N
        lblWelcomImg.setMaximumSize(new java.awt.Dimension(1081, 780));
        lblWelcomImg.setMinimumSize(new java.awt.Dimension(1081, 780));
        lblWelcomImg.setPreferredSize(new java.awt.Dimension(1081, 780));
        getContentPane().add(lblWelcomImg, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel lblWelcomImg;
    protected javax.swing.JTabbedPane tpLoginRegister;
    // End of variables declaration//GEN-END:variables

    private void initPanels() {
        tpLoginRegister.add(LOGIN, new LoginPanel());
        tpLoginRegister.add(REGISTER, new RegisterPanel());
    }

    private void initUI() {
        tpLoginRegister.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return tabPane.getWidth() / tabPane.getTabCount();
            }

            @Override
            protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
                    Rectangle iconRect, Rectangle textRect, boolean isSelected) {
            }
        });
    }
}
