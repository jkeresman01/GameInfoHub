package com.keresman.view;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.session.SessionManager;
import com.keresman.utilities.MessageUtils;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfilePanel extends JPanel {

  private Map<JTextField, JLabel> validationsFieldsWithErrorLabels;
  private UserRepository userRepository;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnUpdateProfile;
  private javax.swing.JLabel lblErrorEmail;
  private javax.swing.JLabel lblErrorFirstName;
  private javax.swing.JLabel lblErrorLastName;
  private javax.swing.JLabel lblErrorUsername;
  private javax.swing.JLabel lblProfileImage;
  private javax.swing.JTextField lblSignInWithAcc;
  private javax.swing.JLabel lblTitle;
  private javax.swing.JLabel lblmage;
  private javax.swing.JPanel pnlPlaceholder;
  private javax.swing.JTextField tfEmail;
  private javax.swing.JTextField tfFirstName;
  private javax.swing.JTextField tfLastName;
  private javax.swing.JTextField tfUsername;

  // End of variables declaration//GEN-END:variables

  public ProfilePanel() {
    initComponents();
    init();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    lblmage = new javax.swing.JLabel();
    pnlPlaceholder = new javax.swing.JPanel();
    lblTitle = new javax.swing.JLabel();
    lblSignInWithAcc = new javax.swing.JTextField();
    btnUpdateProfile = new javax.swing.JButton();
    tfUsername = new javax.swing.JTextField();
    tfFirstName = new javax.swing.JTextField();
    tfLastName = new javax.swing.JTextField();
    tfEmail = new javax.swing.JTextField();
    lblProfileImage = new javax.swing.JLabel();
    lblErrorFirstName = new javax.swing.JLabel();
    lblErrorLastName = new javax.swing.JLabel();
    lblErrorUsername = new javax.swing.JLabel();
    lblErrorEmail = new javax.swing.JLabel();

    setBackground(new java.awt.Color(36, 36, 36));
    setLayout(new java.awt.BorderLayout());

    lblmage.setBackground(new java.awt.Color(24, 24, 24));
    lblmage.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/assets/profile12.jpg"))); // NOI18N
    lblmage.setPreferredSize(new java.awt.Dimension(400, 800));
    add(lblmage, java.awt.BorderLayout.LINE_END);

    pnlPlaceholder.setBackground(new java.awt.Color(24, 24, 24));
    pnlPlaceholder.setPreferredSize(new java.awt.Dimension(800, 800));

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

    btnUpdateProfile.setBackground(new java.awt.Color(102, 102, 255));
    btnUpdateProfile.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
    btnUpdateProfile.setForeground(new java.awt.Color(255, 255, 255));
    btnUpdateProfile.setText("Save changes");
    btnUpdateProfile.setBorder(null);
    btnUpdateProfile.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateProfileActionPerformed(evt);
          }
        });

    tfUsername.setBackground(new java.awt.Color(24, 24, 24));
    tfUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
    tfUsername.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Username",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 0, 12),
            new java.awt.Color(255, 255, 255))); // NOI18N
    tfUsername.setPreferredSize(new java.awt.Dimension(65, 30));

    tfFirstName.setBackground(new java.awt.Color(24, 24, 24));
    tfFirstName.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
    tfFirstName.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "First name",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 0, 12),
            new java.awt.Color(255, 255, 255))); // NOI18N

    tfLastName.setBackground(new java.awt.Color(24, 24, 24));
    tfLastName.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
    tfLastName.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Last name",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 0, 12),
            new java.awt.Color(255, 255, 255))); // NOI18N

    tfEmail.setBackground(new java.awt.Color(24, 24, 24));
    tfEmail.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
    tfEmail.setBorder(
        javax.swing.BorderFactory.createTitledBorder(
            null,
            "Email",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.DEFAULT_POSITION,
            new java.awt.Font("Segoe UI", 0, 12),
            new java.awt.Color(255, 255, 255))); // NOI18N

    lblProfileImage.setBackground(new java.awt.Color(153, 153, 153));
    lblProfileImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblProfileImage.setText("Profle image");
    lblProfileImage.setBorder(
        new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

    lblErrorFirstName.setForeground(new java.awt.Color(255, 51, 51));
    lblErrorFirstName.setText("X");

    lblErrorLastName.setForeground(new java.awt.Color(255, 51, 51));
    lblErrorLastName.setText("X");

    lblErrorUsername.setForeground(new java.awt.Color(255, 51, 51));
    lblErrorUsername.setText("X");

    lblErrorEmail.setForeground(new java.awt.Color(255, 51, 51));
    lblErrorEmail.setText("X");

    javax.swing.GroupLayout pnlPlaceholderLayout = new javax.swing.GroupLayout(pnlPlaceholder);
    pnlPlaceholder.setLayout(pnlPlaceholderLayout);
    pnlPlaceholderLayout.setHorizontalGroup(
        pnlPlaceholderLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                lblTitle,
                javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addGroup(
                pnlPlaceholderLayout
                    .createSequentialGroup()
                    .addComponent(lblSignInWithAcc)
                    .addContainerGap())
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                pnlPlaceholderLayout
                    .createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(
                        lblProfileImage,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        150,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(192, 192, 192)
                    .addGroup(
                        pnlPlaceholderLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                pnlPlaceholderLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        pnlPlaceholderLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                tfEmail,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                300,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                tfUsername,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                300,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(
                                        pnlPlaceholderLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblErrorUsername)
                                            .addComponent(lblErrorEmail)
                                            .addComponent(lblErrorLastName)
                                            .addComponent(lblErrorFirstName)))
                            .addComponent(
                                tfLastName,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                300,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                tfFirstName,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                300,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(
                pnlPlaceholderLayout
                    .createSequentialGroup()
                    .addGap(442, 442, 442)
                    .addComponent(
                        btnUpdateProfile,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        172,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)));
    pnlPlaceholderLayout.setVerticalGroup(
        pnlPlaceholderLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                pnlPlaceholderLayout
                    .createSequentialGroup()
                    .addGroup(
                        pnlPlaceholderLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                pnlPlaceholderLayout
                                    .createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(lblTitle)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        lblSignInWithAcc,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(
                                        pnlPlaceholderLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                pnlPlaceholderLayout
                                                    .createSequentialGroup()
                                                    .addGap(218, 218, 218)
                                                    .addComponent(lblErrorFirstName))
                                            .addGroup(
                                                pnlPlaceholderLayout
                                                    .createSequentialGroup()
                                                    .addGap(35, 35, 35)
                                                    .addComponent(
                                                        tfFirstName,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        60,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(
                                pnlPlaceholderLayout
                                    .createSequentialGroup()
                                    .addGap(190, 190, 190)
                                    .addGroup(
                                        pnlPlaceholderLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                tfLastName,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                60,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                lblProfileImage,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                156,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addGroup(
                        pnlPlaceholderLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblErrorLastName)
                            .addComponent(
                                tfUsername,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                60,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(47, 47, 47)
                    .addComponent(lblErrorUsername)
                    .addGap(18, 18, 18)
                    .addGroup(
                        pnlPlaceholderLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                tfEmail,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                60,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErrorEmail))
                    .addGap(35, 35, 35)
                    .addComponent(
                        btnUpdateProfile,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        39,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(118, Short.MAX_VALUE)));

    add(pnlPlaceholder, java.awt.BorderLayout.CENTER);
  } // </editor-fold>//GEN-END:initComponents

  private void btnUpdateProfileActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_btnUpdateProfileActionPerformed

    if (!isFormValid()) {
      MessageUtils.showErrorMessage("ERROR", "Invalid input, all fields must be set");
      return;
    }

    String firstName = tfFirstName.getText().trim();
    String lastName = tfLastName.getText().trim();
    String username = tfUsername.getText().trim();
    String email = tfEmail.getText().trim();

    User user = SessionManager.getInstance().getCurrentUser();

    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUsername(username);
    user.setEmail(email);

    try {
      userRepository.updateById(user.getUserId(), user);
      MessageUtils.showInformationMessage(
          "Update success", "Profile has been successfully updated!");
    } catch (Exception ex) {
      Logger.getLogger(ProfilePanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  } // GEN-LAST:event_btnUpdateProfileActionPerformed

  private void init() {
    try {
      initRepository();
      initValidation();
      hideErrors();
      fillForm();
    } catch (Exception ex) {
      ex.printStackTrace();
      MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
      MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
      System.exit(1);
    }
  }

  private void initValidation() {
    validationsFieldsWithErrorLabels =
        Map.ofEntries(
            Map.entry(tfUsername, lblErrorUsername),
            Map.entry(tfFirstName, lblErrorFirstName),
            Map.entry(tfLastName, lblErrorLastName),
            Map.entry(tfEmail, lblErrorEmail));
  }

  private void hideErrors() {
    validationsFieldsWithErrorLabels.values().forEach(e -> e.setVisible(false));
  }

  private boolean isFormValid() {
    hideErrors();

    validationsFieldsWithErrorLabels.forEach(
        (field, errLabel) -> errLabel.setVisible(field.getText().trim().isEmpty()));

    return validationsFieldsWithErrorLabels.values().stream().noneMatch(JLabel::isVisible);
  }

  private void fillForm() {
    User user = SessionManager.getInstance().getCurrentUser();

    tfFirstName.setText(user.getFirstName());
    tfLastName.setText(user.getLastName());
    tfEmail.setText(user.getEmail());
    tfUsername.setText(user.getUsername());
  }

  private void initRepository() throws Exception {
    userRepository = RepositoryFactory.getInstance(UserRepository.class);
  }
}
