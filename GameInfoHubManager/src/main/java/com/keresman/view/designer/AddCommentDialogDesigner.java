package com.keresman.view.designer;

import java.awt.event.ActionEvent;
import javax.swing.JDialog;

public abstract class AddCommentDialogDesigner extends JDialog {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JButton btnComment;
  protected javax.swing.JLabel lblErrorContent;
  protected javax.swing.JLabel lblErrorTitle;
  protected javax.swing.JLabel lblTitle1;
  protected javax.swing.JLabel lblWhatOnYourMind;
  protected javax.swing.JTextField tfContent;
  protected javax.swing.JTextField tfTitle;

  // End of variables declaration//GEN-END:variables

  public AddCommentDialogDesigner(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnComment = new javax.swing.JButton();
    tfTitle = new javax.swing.JTextField();
    lblWhatOnYourMind = new javax.swing.JLabel();
    tfContent = new javax.swing.JTextField();
    lblErrorTitle = new javax.swing.JLabel();
    lblErrorContent = new javax.swing.JLabel();
    lblTitle1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setBackground(new java.awt.Color(24, 24, 24));
    setForeground(new java.awt.Color(255, 255, 255));

    btnComment.setBackground(new java.awt.Color(102, 102, 255));
    btnComment.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
    btnComment.setForeground(new java.awt.Color(255, 255, 255));
    btnComment.setText("Comment");
    btnComment.setBorder(null);
    btnComment.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCommentActionPerformed(evt);
          }
        });

    tfTitle.setBackground(new java.awt.Color(44, 44, 44));
    tfTitle.setForeground(new java.awt.Color(255, 255, 255));

    lblWhatOnYourMind.setBackground(new java.awt.Color(24, 24, 24));
    lblWhatOnYourMind.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblWhatOnYourMind.setForeground(new java.awt.Color(255, 255, 255));
    lblWhatOnYourMind.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblWhatOnYourMind.setText("What's on your mind....");
    lblWhatOnYourMind.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

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
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(40, 40, 40)
                                                    .addComponent(tfContent))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(16, 16, 16)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment
                                                                    .LEADING)
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addGap(6, 6, 6)
                                                                    .addComponent(
                                                                        lblTitle1,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        100,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addPreferredGap(
                                                                        javax.swing.LayoutStyle
                                                                            .ComponentPlacement
                                                                            .RELATED,
                                                                        javax.swing.GroupLayout
                                                                            .DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                    .addComponent(
                                                                        tfTitle,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        352,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE))
                                                            .addGroup(
                                                                layout
                                                                    .createSequentialGroup()
                                                                    .addComponent(
                                                                        lblWhatOnYourMind,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE,
                                                                        419,
                                                                        javax.swing.GroupLayout
                                                                            .PREFERRED_SIZE)
                                                                    .addGap(
                                                                        0, 0, Short.MAX_VALUE)))))
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblErrorTitle)
                                            .addComponent(lblErrorContent)))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(172, 172, 172)
                                    .addComponent(
                                        btnComment,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        172,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(49, 49, 49)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(lblWhatOnYourMind)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                tfTitle,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                44,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorTitle)
                            .addComponent(lblTitle1))
                    .addGap(32, 32, 32)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                tfContent,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                133,
                                Short.MAX_VALUE)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(lblErrorContent)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addComponent(
                        btnComment,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        34,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  public abstract void btnCommentActionPerformed(ActionEvent evt);
}
