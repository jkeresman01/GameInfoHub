package com.keresman.view.register;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.utilities.BCryptUtils;
import com.keresman.utilities.MessageUtils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

public class RegisterPanel extends javax.swing.JPanel {

    private static final int LOGIN_PAGE_INDEX = 0;

    public RegisterPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblErrorEmail2 = new javax.swing.JLabel();
        lblErrorEmail3 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblRegister = new javax.swing.JTextField();
        tfUsername = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        tfCfmPassword = new javax.swing.JPasswordField();
        lblErrorUsername = new javax.swing.JLabel();
        lblErrorFirstName = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();
        lblErrorLastName = new javax.swing.JLabel();
        tfLastName = new javax.swing.JTextField();
        tfFirstName = new javax.swing.JTextField();
        lblErrorCfmPassword = new javax.swing.JLabel();
        lblErrorEmail = new javax.swing.JLabel();

        jLabel3.setText("X");

        jLabel4.setText("X");

        jLabel5.setText("X");

        jLabel7.setText("X");

        lblErrorEmail2.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorEmail2.setText("X");

        lblErrorEmail3.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorEmail3.setText("X");

        setBackground(new java.awt.Color(24, 24, 24));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setToolTipText("");
        setName(""); // NOI18N

        lblTitle.setBackground(new java.awt.Color(30, 30, 30));
        lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("IGN Games RSS Feed");
        lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblRegister.setBackground(new java.awt.Color(24, 24, 24));
        lblRegister.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblRegister.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblRegister.setText("Register");
        lblRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));
        lblRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblRegisterActionPerformed(evt);
            }
        });

        tfUsername.setBackground(new java.awt.Color(24, 24, 24));
        tfUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        btnRegister.setBackground(new java.awt.Color(255, 102, 204));
        btnRegister.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.setBorder(null);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        tfEmail.setBackground(new java.awt.Color(24, 24, 24));
        tfEmail.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        tfPassword.setBackground(new java.awt.Color(24, 24, 24));
        tfPassword.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tfCfmPassword.setBackground(new java.awt.Color(24, 24, 24));
        tfCfmPassword.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfCfmPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        lblErrorUsername.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorUsername.setText("X");

        lblErrorFirstName.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorFirstName.setText("X");

        lblErrorPassword.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorPassword.setText("X");

        lblErrorLastName.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorLastName.setText("X");

        tfLastName.setBackground(new java.awt.Color(24, 24, 24));
        tfLastName.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tfFirstName.setBackground(new java.awt.Color(24, 24, 24));
        tfFirstName.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        lblErrorCfmPassword.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorCfmPassword.setText("X");

        lblErrorEmail.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorEmail.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegister)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfPassword)
                    .addComponent(tfCfmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLastName)
                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorUsername)
                    .addComponent(lblErrorFirstName)
                    .addComponent(lblErrorPassword)
                    .addComponent(lblErrorLastName)
                    .addComponent(lblErrorCfmPassword)
                    .addComponent(lblErrorEmail))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorLastName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCfmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorCfmPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorEmail))
                .addGap(34, 34, 34)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        if (!isFormValid()) {
            return;
        }

        String username = tfUsername.getText();
        String email = tfEmail.getText();

        try {
            if (repository.existsUserWithUsername(username)) {
                MessageUtils.showErrorMessage("Registration unsucessfull", "Username already taken!");
                lblErrorUsername.setVisible(true);
                return;
            }

            if (repository.existsUserWithEmail(email)) {
                MessageUtils.showErrorMessage("Registration unsucessfull", "Email already in use!!");
                lblErrorEmail.setVisible(true);
                return;
            }

        } catch (Exception ex) {
            Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        User user = new User(
                username,
                BCryptUtils.hashPassword(tfPassword.getText()),
                tfFirstName.getText(),
                tfLastName.getText(),
                tfEmail.getText()
        );

        try {
            repository.createUser(user);
            MessageUtils.showInformationMessage(
                    "Registration successfull",
                    "You have successffully registered, go to login page now!!"
            );

            switchToLoginPage();
        } catch (Exception ex) {
            Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void lblRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblRegisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRegisterActionPerformed

    private void switchToLoginPage() {
        JTabbedPane tabs = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
        if (tabs != null) {
            tabs.setSelectedIndex(LOGIN_PAGE_INDEX);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblErrorCfmPassword;
    private javax.swing.JLabel lblErrorEmail;
    private javax.swing.JLabel lblErrorEmail2;
    private javax.swing.JLabel lblErrorEmail3;
    private javax.swing.JLabel lblErrorFirstName;
    private javax.swing.JLabel lblErrorLastName;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorUsername;
    private javax.swing.JTextField lblRegister;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField tfCfmPassword;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

    private List<JLabel> errorLabels;
    private List<JTextComponent> validationFields;
    private UserRepository repository;

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
        } catch (Exception ex) {
            Logger.getLogger(RegisterPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        tfUsername.requestFocus();

        validationFields = List.of(
                tfLastName,
                tfPassword,
                tfFirstName,
                tfUsername,
                tfPassword,
                tfCfmPassword,
                tfEmail
        );

        errorLabels = List.of(
                lblErrorLastName,
                lblErrorPassword,
                lblErrorFirstName,
                lblErrorUsername,
                lblErrorPassword,
                lblErrorCfmPassword,
                lblErrorEmail
        );
    }

    private void hideErrors() {
        errorLabels.forEach(e -> e.setVisible(false));
    }

    private void initRepository() throws Exception {
        repository = RepositoryFactory.getRepository();
    }

    private boolean isFormValid() {
        hideErrors();
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); ++i) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
        }
        return ok;
    }

    private void clearForm() {
        hideErrors();
        validationFields.forEach(e -> e.setText(""));
    }

}
