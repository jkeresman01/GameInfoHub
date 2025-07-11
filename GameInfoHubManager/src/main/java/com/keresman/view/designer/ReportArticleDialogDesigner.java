package com.keresman.view.designer;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;

public abstract class ReportArticleDialogDesigner extends JDialog {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JButton btnReport;
  protected javax.swing.JLabel lblErrorContent;
  protected javax.swing.JLabel lblErrorTitle;
  protected javax.swing.JLabel lblTitle;
  protected javax.swing.JLabel lblTitle1;
  protected javax.swing.JTextField tfContent;
  protected javax.swing.JTextField tfTitle;

  // End of variables declaration//GEN-END:variables

  public ReportArticleDialogDesigner(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnReport = new javax.swing.JButton();
    tfTitle = new javax.swing.JTextField();
    lblTitle = new javax.swing.JLabel();
    tfContent = new javax.swing.JTextField();
    lblErrorTitle = new javax.swing.JLabel();
    lblErrorContent = new javax.swing.JLabel();
    lblTitle1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setBackground(new java.awt.Color(24, 24, 24));
    setForeground(new java.awt.Color(255, 255, 255));

    btnReport.setBackground(new java.awt.Color(255, 51, 51));
    btnReport.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
    btnReport.setForeground(new java.awt.Color(255, 255, 255));
    btnReport.setText("XX Report XX");
    btnReport.setBorder(null);
    btnReport.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnReportActionPerformed(evt);
          }
        });

    tfTitle.setBackground(new java.awt.Color(44, 44, 44));
    tfTitle.setForeground(new java.awt.Color(255, 255, 255));

    lblTitle.setBackground(new java.awt.Color(24, 24, 24));
    lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblTitle.setForeground(new java.awt.Color(255, 255, 255));
    lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblTitle.setText("Report");
    lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    tfContent.setBackground(new java.awt.Color(44, 44, 44));
    tfContent.setForeground(new java.awt.Color(255, 255, 255));

    lblErrorTitle.setForeground(new java.awt.Color(255, 51, 51));
    lblErrorTitle.setText("X");

    lblErrorContent.setForeground(new java.awt.Color(255, 51, 51));
    lblErrorContent.setText("X");

    lblTitle1.setBackground(new java.awt.Color(24, 24, 24));
    lblTitle1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
    lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblTitle1.setText("Title");
    lblTitle1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        lblTitle1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        101,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        58,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        tfTitle,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        332,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfContent))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorTitle)
                            .addComponent(lblErrorContent))
                    .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(
                                        lblTitle,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        419,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(175, 175, 175)
                                    .addComponent(
                                        btnReport,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        179,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblTitle)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                lblTitle1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                44,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                tfTitle,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                44,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(106, 106, 106)
                                    .addComponent(lblErrorTitle)))
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(lblErrorContent)
                                    .addGap(18, 208, Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfContent)
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        btnReport,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)))));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  public abstract void btnReportActionPerformed(ActionEvent evt);
}
