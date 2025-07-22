package com.keresman.view.designer;

import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public abstract class BrowseReportsPanelDesigner extends JPanel {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JLabel lblTitle;
  protected javax.swing.JScrollPane spReportsTable;
  protected javax.swing.JTable tblReports;
  protected javax.swing.JTextField tfContent;
  protected javax.swing.JTextField tfTitle;

  // End of variables declaration//GEN-END:variables

  protected BrowseReportsPanelDesigner() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    spReportsTable = new javax.swing.JScrollPane();
    tblReports = new javax.swing.JTable();
    tfTitle = new javax.swing.JTextField();
    tfContent = new javax.swing.JTextField();
    lblTitle = new javax.swing.JLabel();

    setBackground(new java.awt.Color(24, 24, 24));
    setPreferredSize(new java.awt.Dimension(940, 802));
    addComponentListener(
        new java.awt.event.ComponentAdapter() {
          public void componentShown(java.awt.event.ComponentEvent evt) {
            formComponentShown(evt);
          }
        });

    spReportsTable.setBackground(new java.awt.Color(24, 24, 24));

    tblReports.setBackground(new java.awt.Color(24, 24, 24));
    tblReports.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
            },
            new String[] {"Title 1", "Title 2", "Title 3", "Title 4"}));
    tblReports.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblReportsMouseClicked(evt);
          }
        });
    spReportsTable.setViewportView(tblReports);

    tfTitle.setBackground(new java.awt.Color(24, 24, 24));
    tfTitle.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
    tfTitle.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Title",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 0, 12),
            new java.awt.Color(255, 255, 255))); // NOI18N

    tfContent.setBackground(new java.awt.Color(24, 24, 24));
    tfContent.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
    tfContent.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Content",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 0, 12),
            new java.awt.Color(255, 255, 255))); // NOI18N

    lblTitle.setBackground(new java.awt.Color(24, 24, 24));
    lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblTitle.setForeground(new java.awt.Color(255, 255, 255));
    lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblTitle.setText("Browse Reports");
    lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        spReportsTable,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        816,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(55, Short.MAX_VALUE))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfTitle)
                                            .addComponent(tfContent))
                                    .addGap(66, 66, 66))))
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        lblTitle,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addGap(66, 66, 66)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(lblTitle)
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                    .addComponent(
                        tfTitle,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        50,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(
                        tfContent,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        214,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(
                        spReportsTable,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        235,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(124, 124, 124)));
  } // </editor-fold>//GEN-END:initComponents

  public abstract void formComponentShown(ComponentEvent evt);

  public abstract void tblReportsMouseClicked(MouseEvent evt);
}
