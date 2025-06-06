package com.keresman.view.designer;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public abstract class AdminPanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnActivateDeactiveProfile;
    protected javax.swing.JButton btnDeleteAll;
    protected javax.swing.JButton btnLoadDb;
    protected javax.swing.JLabel lblImage;
    protected javax.swing.JPanel lblPlaceholder;
    protected javax.swing.JLabel lblStatistics;
    protected javax.swing.JLabel lblUsername;
    protected javax.swing.JLabel lblmage;
    protected javax.swing.JScrollPane spStatistics;
    protected javax.swing.JScrollPane spUsersTable;
    protected javax.swing.JTextArea taStatistics;
    protected javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables

    protected AdminPanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmage = new javax.swing.JLabel();
        lblPlaceholder = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblStatistics = new javax.swing.JLabel();
        spUsersTable = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnDeleteAll = new javax.swing.JButton();
        spStatistics = new javax.swing.JScrollPane();
        taStatistics = new javax.swing.JTextArea();
        btnActivateDeactiveProfile = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        btnLoadDb = new javax.swing.JButton();

        lblmage.setBackground(new java.awt.Color(24, 24, 24));
        lblmage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/profile12.jpg"))); // NOI18N

        lblPlaceholder.setBackground(new java.awt.Color(24, 24, 24));

        javax.swing.GroupLayout lblPlaceholderLayout = new javax.swing.GroupLayout(lblPlaceholder);
        lblPlaceholder.setLayout(lblPlaceholderLayout);
        lblPlaceholderLayout.setHorizontalGroup(
            lblPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        lblPlaceholderLayout.setVerticalGroup(
            lblPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/male_default_picture.jpg"))); // NOI18N

        lblStatistics.setBackground(new java.awt.Color(24, 24, 24));
        lblStatistics.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 16)); // NOI18N
        lblStatistics.setForeground(new java.awt.Color(255, 255, 255));
        lblStatistics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatistics.setText("STATISTICS");
        lblStatistics.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        spUsersTable.setBackground(new java.awt.Color(24, 24, 24));

        tblUsers.setBackground(new java.awt.Color(24, 24, 24));
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        spUsersTable.setViewportView(tblUsers);

        btnDeleteAll.setBackground(new java.awt.Color(255, 102, 102));
        btnDeleteAll.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnDeleteAll.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAll.setText("DELETE ALL");

        spStatistics.setBackground(new java.awt.Color(255, 255, 255));

        taStatistics.setBackground(new java.awt.Color(204, 204, 255));
        taStatistics.setColumns(20);
        taStatistics.setForeground(new java.awt.Color(24, 24, 24));
        taStatistics.setLineWrap(true);
        taStatistics.setRows(5);
        spStatistics.setViewportView(taStatistics);

        btnActivateDeactiveProfile.setBackground(new java.awt.Color(255, 102, 102));
        btnActivateDeactiveProfile.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnActivateDeactiveProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnActivateDeactiveProfile.setText("DEACTIVATE PROFILE");

        lblUsername.setBackground(new java.awt.Color(24, 24, 24));
        lblUsername.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 16)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("USERNAME");
        lblUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        btnLoadDb.setBackground(new java.awt.Color(153, 153, 255));
        btnLoadDb.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnLoadDb.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadDb.setText("LOAD DB");
        btnLoadDb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActivateDeactiveProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoadDb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(spUsersTable, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                            .addComponent(lblStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(651, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(lblmage)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(lblStatistics))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnLoadDb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnActivateDeactiveProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(spUsersTable, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblmage))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public abstract void btnLoadDbActionPerformed(ActionEvent evt);

    public abstract void tblUsersMouseClicked(MouseEvent evt);
}
