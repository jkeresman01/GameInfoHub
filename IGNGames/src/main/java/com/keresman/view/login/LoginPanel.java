package com.keresman.view.login;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.utilities.BCryptUtils;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.feedmanager.IGNGamesFeedManager;
import java.awt.Window;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class LoginPanel extends javax.swing.JPanel {

    private final UserRepository repository;

    public LoginPanel() {
        initComponents();
        repository = RepositoryFactory.getRepository();
        tfUsername.requestFocus();
        hideErrors();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSignInWithAcc = new javax.swing.JTextField();
        tfUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        lblErrorUsername = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();

        setBackground(new java.awt.Color(24, 24, 24));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setToolTipText("");
        setName(""); // NOI18N

        lblTitle.setBackground(new java.awt.Color(24, 24, 24));
        lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("IGN Games RSS Feed");
        lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblSignInWithAcc.setBackground(new java.awt.Color(24, 24, 24));
        lblSignInWithAcc.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblSignInWithAcc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblSignInWithAcc.setText("Sign in with your account");
        lblSignInWithAcc.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        tfUsername.setBackground(new java.awt.Color(24, 24, 24));
        tfUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        tfUsername.setPreferredSize(new java.awt.Dimension(65, 30));

        btnLogin.setBackground(new java.awt.Color(255, 102, 204));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("→");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(24, 24, 24));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jPasswordField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPasswordField1.setPreferredSize(new java.awt.Dimension(65, 30));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        lblErrorUsername.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorUsername.setText("X");

        lblErrorPassword.setForeground(new java.awt.Color(255, 0, 204));
        lblErrorPassword.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(lblSignInWithAcc))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorUsername)
                    .addComponent(lblErrorPassword))
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSignInWithAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorUsername))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorPassword))
                .addGap(42, 42, 42)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String username = tfUsername.getText();
        String password = new String(jPasswordField1.getPassword());

        try {
            if (repository.existsUserWithUsername(username)) {
                MessageUtils.showErrorMessage("ERROR", "No user with username: %s".formatted(username));
            } else {
                Optional<User> optUser = repository.selectUserWithUsername(username);

                if (optUser.isPresent()) {

                    boolean isPasswordValid = BCryptUtils.veriftyPassword(password, optUser.get().getPasswordHash());

                    if (!isPasswordValid) {
                        MessageUtils.showErrorMessage("Ivalid password", "Ivalid password, try again!!");
                    } else {
                        SwingUtilities.invokeLater(() -> {
                            Window window = SwingUtilities.getWindowAncestor(this);
                            if (window != null) {
                                window.dispose();
                            }

                            new IGNGamesFeedManager().setVisible(true);
                        });

                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private List<JLabel> errorLabels;

    private void hideErrors() {
        errorLabels = List.of(
                lblErrorPassword,
                lblErrorUsername
        );

        errorLabels.forEach(lbl -> lbl.setVisible(false));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorUsername;
    private javax.swing.JTextField lblSignInWithAcc;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
