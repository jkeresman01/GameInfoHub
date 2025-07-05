package com.keresman.view.designer;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class ProfilePanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnUpdateProfile;
    protected javax.swing.JTextField lblEditProfile1;
    protected javax.swing.JLabel lblErrorEmail;
    protected javax.swing.JLabel lblErrorFirstName;
    protected javax.swing.JLabel lblErrorLastName;
    protected javax.swing.JLabel lblErrorUsername;
    protected javax.swing.JTextField lblFavouriteArticles;
    protected javax.swing.JTextField lblFavouriteGames;
    protected javax.swing.JTextField lblFavourites;
    protected javax.swing.JLabel lblProfileImage;
    protected javax.swing.JLabel lblmage;
    protected javax.swing.JList<String> lsFavArticles;
    protected javax.swing.JList<String> lsFavGames;
    protected javax.swing.JPanel pnlContainer;
    protected javax.swing.JScrollPane spFavArticles;
    protected javax.swing.JScrollPane spFavGames;
    protected javax.swing.JTextField tfEmail;
    protected javax.swing.JTextField tfFirstName;
    protected javax.swing.JTextField tfLastName;
    protected javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

    protected ProfilePanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmage = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();
        lblFavourites = new javax.swing.JTextField();
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
        lblEditProfile1 = new javax.swing.JTextField();
        lblFavouriteGames = new javax.swing.JTextField();
        spFavGames = new javax.swing.JScrollPane();
        lsFavGames = new javax.swing.JList<>();
        lblFavouriteArticles = new javax.swing.JTextField();
        spFavArticles = new javax.swing.JScrollPane();
        lsFavArticles = new javax.swing.JList<>();

        setBackground(new java.awt.Color(36, 36, 36));
        setLayout(new java.awt.BorderLayout());

        lblmage.setBackground(new java.awt.Color(24, 24, 24));
        lblmage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/profile12.jpg"))); // NOI18N
        lblmage.setPreferredSize(new java.awt.Dimension(400, 800));
        add(lblmage, java.awt.BorderLayout.LINE_END);

        pnlContainer.setBackground(new java.awt.Color(24, 24, 24));
        pnlContainer.setMinimumSize(new java.awt.Dimension(800, 600));
        pnlContainer.setPreferredSize(new java.awt.Dimension(800, 800));

        lblFavourites.setBackground(new java.awt.Color(24, 24, 24));
        lblFavourites.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblFavourites.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblFavourites.setText("Favourites");
        lblFavourites.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

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

        lblProfileImage.setBackground(new java.awt.Color(153, 153, 153));
        lblProfileImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfileImage.setText("Profle image");
        lblProfileImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        lblErrorFirstName.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorFirstName.setText("X");

        lblErrorLastName.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorLastName.setText("X");

        lblErrorUsername.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorUsername.setText("X");

        lblErrorEmail.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorEmail.setText("X");

        lblEditProfile1.setBackground(new java.awt.Color(24, 24, 24));
        lblEditProfile1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblEditProfile1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblEditProfile1.setText("Edit profile");
        lblEditProfile1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblFavouriteGames.setBackground(new java.awt.Color(24, 24, 24));
        lblFavouriteGames.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblFavouriteGames.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblFavouriteGames.setText("Games");
        lblFavouriteGames.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lsFavGames.setBackground(new java.awt.Color(44, 44, 44));
        lsFavGames.setForeground(new java.awt.Color(255, 255, 255));
        spFavGames.setViewportView(lsFavGames);

        lblFavouriteArticles.setBackground(new java.awt.Color(24, 24, 24));
        lblFavouriteArticles.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblFavouriteArticles.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblFavouriteArticles.setText("Articles");
        lblFavouriteArticles.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lsFavArticles.setBackground(new java.awt.Color(44, 44, 44));
        lsFavArticles.setForeground(new java.awt.Color(255, 255, 255));
        spFavArticles.setViewportView(lsFavArticles);

        javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
        pnlContainer.setLayout(pnlContainerLayout);
        pnlContainerLayout.setHorizontalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContainerLayout.createSequentialGroup()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblFavouriteGames, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(spFavArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFavouriteArticles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spFavGames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFavourites, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addComponent(lblEditProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrorUsername))
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrorEmail))
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrorLastName))
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrorFirstName)))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        pnlContainerLayout.setVerticalGroup(
            pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblEditProfile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblErrorFirstName)
                            .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblErrorLastName)
                            .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addComponent(lblFavouriteGames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(spFavGames, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFavouriteArticles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContainerLayout.createSequentialGroup()
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblErrorUsername)
                            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(pnlContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlContainerLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblErrorEmail))))
                    .addComponent(spFavArticles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnUpdateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        add(pnlContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public abstract void btnUpdateProfileActionPerformed(ActionEvent evt);

}
