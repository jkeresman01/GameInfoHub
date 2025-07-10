package com.keresman.view.designer;

import com.keresman.model.Article;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class ManageGameArticlesPanelDesigner extends JPanel {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JButton btnDeleteAll;
  protected javax.swing.JButton btnLoadDb;
  protected javax.swing.JLabel lblTitle;
  protected javax.swing.JList<Article> lsArticles;
  protected javax.swing.JScrollPane spArticles;

  // End of variables declaration//GEN-END:variables

  protected ManageGameArticlesPanelDesigner() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnDeleteAll = new javax.swing.JButton();
    btnLoadDb = new javax.swing.JButton();
    spArticles = new javax.swing.JScrollPane();
    lsArticles = new javax.swing.JList<>();
    lblTitle = new javax.swing.JLabel();

    setBackground(new java.awt.Color(24, 24, 24));
    setPreferredSize(new java.awt.Dimension(900, 802));

    btnDeleteAll.setBackground(new java.awt.Color(255, 102, 102));
    btnDeleteAll.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
    btnDeleteAll.setForeground(new java.awt.Color(255, 255, 255));
    btnDeleteAll.setText("DELETE ALL");
    btnDeleteAll.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteAllActionPerformed(evt);
          }
        });

    btnLoadDb.setBackground(new java.awt.Color(153, 153, 255));
    btnLoadDb.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
    btnLoadDb.setForeground(new java.awt.Color(255, 255, 255));
    btnLoadDb.setText("LOAD DB");
    btnLoadDb.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoadDbActionPerformed(evt);
          }
        });

    lsArticles.setBackground(new java.awt.Color(44, 44, 44));
    lsArticles.setForeground(new java.awt.Color(255, 255, 255));
    lsArticles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    spArticles.setViewportView(lsArticles);

    lblTitle.setBackground(new java.awt.Color(24, 24, 24));
    lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblTitle.setForeground(new java.awt.Color(255, 255, 255));
    lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblTitle.setText("Manage Game Articles");
    lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                lblTitle,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                793,
                                Short.MAX_VALUE)
                            .addComponent(spArticles)
                            .addComponent(
                                btnDeleteAll,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                btnLoadDb,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addContainerGap(61, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(lblTitle)
                    .addGap(18, 18, 18)
                    .addComponent(
                        spArticles,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        509,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                    .addComponent(
                        btnDeleteAll,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        39,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        btnLoadDb,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        39,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(52, 52, 52)));
  } // </editor-fold>//GEN-END:initComponents

  public abstract void btnDeleteAllActionPerformed(ActionEvent evt);

  public abstract void btnLoadDbActionPerformed(ActionEvent evt);
}
