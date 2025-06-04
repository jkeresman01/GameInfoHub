package com.keresman.view.designer;

import com.keresman.model.Gender;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class RegisterDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnRegister;
    protected javax.swing.JComboBox<Gender> cbGender;
    protected javax.swing.JLabel lblErrorCfmPassword;
    protected javax.swing.JLabel lblErrorEmail;
    protected javax.swing.JLabel lblErrorFirstName;
    protected javax.swing.JLabel lblErrorLastName;
    protected javax.swing.JLabel lblErrorPassword;
    protected javax.swing.JLabel lblErrorUsername;
    protected javax.swing.JLabel lblGender;
    protected javax.swing.JTextField lblRegister;
    protected javax.swing.JLabel lblTitle;
    protected javax.swing.JPasswordField tfCfmPassword;
    protected javax.swing.JTextField tfEmail;
    protected javax.swing.JTextField tfFirstName;
    protected javax.swing.JTextField tfLastName;
    protected javax.swing.JPasswordField tfPassword;
    protected javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

  protected RegisterDesigner() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        cbGender = new javax.swing.JComboBox<>();
        lblGender = new javax.swing.JLabel();

        setBackground(new java.awt.Color(24, 24, 24));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setToolTipText("");
        setName(""); // NOI18N

        lblTitle.setBackground(new java.awt.Color(30, 30, 30));
        lblTitle.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Game reviews");
        lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblRegister.setBackground(new java.awt.Color(24, 24, 24));
        lblRegister.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblRegister.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblRegister.setText("Register");
        lblRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        tfUsername.setBackground(new java.awt.Color(24, 24, 24));
        tfUsername.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        tfUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

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

        cbGender.setBackground(new java.awt.Color(24, 24, 24));
        cbGender.setForeground(new java.awt.Color(255, 255, 255));

        lblGender.setText("Gender");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfPassword)
                    .addComponent(tfCfmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLastName)
                    .addComponent(tfFirstName)
                    .addComponent(tfUsername, javax.swing.GroupLayout.Alignment.LEADING))
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
                .addContainerGap()
                .addComponent(lblRegister))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

  public abstract void btnRegisterActionPerformed(ActionEvent evt);
}
