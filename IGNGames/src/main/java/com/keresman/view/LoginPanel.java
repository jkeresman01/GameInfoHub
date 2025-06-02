package com.keresman.view;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.session.SessionManager;
import com.keresman.utilities.BCryptUtils;
import com.keresman.utilities.MessageUtils;
import java.awt.Window;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginPanel extends JPanel {

    private Map<JTextField, JLabel> validationsFieldsWithErrorLabels;
    private UserRepository userRepository;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblErrorUsername;
    private javax.swing.JTextField lblSignInWithAcc;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

    public LoginPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSignInWithAcc = new javax.swing.JTextField();
        tfUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        tfPassword = new javax.swing.JPasswordField();
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

        tfPassword.setBackground(new java.awt.Color(24, 24, 24));
        tfPassword.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        tfPassword.setPreferredSize(new java.awt.Dimension(65, 30));

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
                    .addComponent(tfPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorPassword))
                .addGap(42, 42, 42)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        if (!isFormValid()) {
            MessageUtils.showWarningMessage("WARNING", "You forgot to fill soemthing, please try again!");
            return;
        }

        String username = tfUsername.getText().trim();

        try {
            if (!userRepository.existsByUsername(username)) {
                MessageUtils.showErrorMessage("ERROR", "No user with username: %s".formatted(username));
                return;
            }

            loginUserWithUsername(username);
        } catch (Exception ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void loginUserWithUsername(String username) throws Exception {
        String password = new String(tfPassword.getPassword());

        User user = userRepository.findByUsername(username).get();

        if (BCryptUtils.veriftyPassword(password, user.getPasswordHash())) {
            loginUser(user);
        } else {
            MessageUtils.showErrorMessage("Ivalid password", "Ivalid password, try again!!");
        }
    }

    private void loginUser(User user) {
        SessionManager.getInstance().setCurrentUser(user);

        Runnable showMainForm = () -> {
            Window window = SwingUtilities.getWindowAncestor(this);

            if (window != null) {
                window.dispose();
            }

            new IGNGamesFeedManager().setVisible(true);
        };

        SwingUtilities.invokeLater(showMainForm);
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Critical error, failed to initialize the form.");
            MessageUtils.showErrorMessage("ERROR", "!!! Shutting down !!!");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationsFieldsWithErrorLabels = Map.ofEntries(
                Map.entry(tfUsername, lblErrorUsername),
                Map.entry(tfPassword, lblErrorPassword)
        );
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

    private void initRepository() throws Exception {
        userRepository = RepositoryFactory.getInstance(UserRepository.class);
    }

}
