package com.keresman.view.profile;


public class ProfilePanel extends javax.swing.JPanel {

    public ProfilePanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblSignInWithAcc = new javax.swing.JTextField();
        btnUpdateProfile = new javax.swing.JButton();
        tfUsername = new javax.swing.JTextField();
        tfFirstName = new javax.swing.JTextField();
        tfLastName = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        lblProfileImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(36, 36, 36));
        setLayout(new java.awt.BorderLayout());

        lblmage.setBackground(new java.awt.Color(24, 24, 24));
        lblmage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/profile12.jpg"))); // NOI18N
        lblmage.setPreferredSize(new java.awt.Dimension(600, 800));
        add(lblmage, java.awt.BorderLayout.LINE_END);

        jPanel1.setBackground(new java.awt.Color(24, 24, 24));

        lblTitle.setBackground(new java.awt.Color(24, 24, 24));
        lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("IGN Games RSS Feed");
        lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblSignInWithAcc.setBackground(new java.awt.Color(24, 24, 24));
        lblSignInWithAcc.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblSignInWithAcc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblSignInWithAcc.setText("Edit profile");
        lblSignInWithAcc.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));
        lblSignInWithAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSignInWithAccActionPerformed(evt);
            }
        });

        btnUpdateProfile.setBackground(new java.awt.Color(102, 102, 255));
        btnUpdateProfile.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnUpdateProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateProfile.setText("Save changes");
        btnUpdateProfile.setBorder(null);
        btnUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProfileActionPerformed(evt);
            }
        });

        tfUsername.setBackground(new java.awt.Color(24, 24, 24));
        tfUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        tfUsername.setPreferredSize(new java.awt.Dimension(65, 30));

        tfFirstName.setBackground(new java.awt.Color(24, 24, 24));
        tfFirstName.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tfLastName.setBackground(new java.awt.Color(24, 24, 24));
        tfLastName.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tfEmail.setBackground(new java.awt.Color(24, 24, 24));
        tfEmail.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        lblProfileImage.setBackground(new java.awt.Color(153, 153, 153));
        lblProfileImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfileImage.setText("Profle image");
        lblProfileImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblSignInWithAcc)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 379, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSignInWithAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProfileActionPerformed

    }//GEN-LAST:event_btnUpdateProfileActionPerformed

    private void lblSignInWithAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSignInWithAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSignInWithAccActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateProfile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblProfileImage;
    private javax.swing.JTextField lblSignInWithAcc;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblmage;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
