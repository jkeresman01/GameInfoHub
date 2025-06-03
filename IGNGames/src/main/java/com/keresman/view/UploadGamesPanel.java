package com.keresman.view;

import javax.swing.JPanel;

public class UploadGamesPanel extends JPanel {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel lblImage;
  private javax.swing.JLabel lblTitle;
  private javax.swing.JLabel lblmage;
  private javax.swing.JPanel pnlPlaceholder;
  private javax.swing.JScrollPane spGamesTable;
  private javax.swing.JTable tblGames;

  // End of variables declaration//GEN-END:variables

  public UploadGamesPanel() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlPlaceholder = new javax.swing.JPanel();
    lblmage = new javax.swing.JLabel();
    spGamesTable = new javax.swing.JScrollPane();
    tblGames = new javax.swing.JTable();
    lblImage = new javax.swing.JLabel();
    lblTitle = new javax.swing.JLabel();

    pnlPlaceholder.setBackground(new java.awt.Color(24, 24, 24));

    lblmage.setBackground(new java.awt.Color(24, 24, 24));
    lblmage.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/assets/profile12.jpg"))); // NOI18N

    tblGames.setBackground(new java.awt.Color(24, 24, 24));
    tblGames.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
            },
            new String[] {"Title 1", "Title 2", "Title 3", "Title 4"}));
    spGamesTable.setViewportView(tblGames);

    lblImage.setText("Image game");

    lblTitle.setBackground(new java.awt.Color(24, 24, 24));
    lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblTitle.setForeground(new java.awt.Color(255, 255, 255));
    lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblTitle.setText("IGN Games RSS Feed");
    lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    javax.swing.GroupLayout pnlPlaceholderLayout = new javax.swing.GroupLayout(pnlPlaceholder);
    pnlPlaceholder.setLayout(pnlPlaceholderLayout);
    pnlPlaceholderLayout.setHorizontalGroup(
        pnlPlaceholderLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlPlaceholderLayout
                    .createSequentialGroup()
                    .addGroup(
                        pnlPlaceholderLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                pnlPlaceholderLayout
                                    .createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addGroup(
                                        pnlPlaceholderLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                spGamesTable,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                765,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                lblImage,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                340,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                pnlPlaceholderLayout
                                    .createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addComponent(
                                        lblTitle,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        806,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(683, Short.MAX_VALUE))
            .addGroup(
                pnlPlaceholderLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        pnlPlaceholderLayout
                            .createSequentialGroup()
                            .addGap(0, 942, Short.MAX_VALUE)
                            .addComponent(lblmage)
                            .addGap(0, 0, Short.MAX_VALUE))));
    pnlPlaceholderLayout.setVerticalGroup(
        pnlPlaceholderLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                pnlPlaceholderLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitle)
                    .addGap(18, 18, 18)
                    .addComponent(
                        lblImage,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        270,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                    .addComponent(
                        spGamesTable,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        347,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44))
            .addGroup(
                pnlPlaceholderLayout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        pnlPlaceholderLayout
                            .createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(lblmage)
                            .addGap(0, 0, Short.MAX_VALUE))));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1542, Short.MAX_VALUE)
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(
                                pnlPlaceholder,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(
                                pnlPlaceholder,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))));
  } // </editor-fold>//GEN-END:initComponents
}
