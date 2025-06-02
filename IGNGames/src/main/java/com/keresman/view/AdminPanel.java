package com.keresman.view;

import com.keresman.dao.RepositoryFactory;
import com.keresman.dao.UserRepository;
import com.keresman.model.User;
import com.keresman.utilities.MessageUtils;
import com.keresman.view.model.UserTableModel;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

public class AdminPanel extends javax.swing.JPanel {

    public AdminPanel() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmage = new javax.swing.JLabel();
        lblPlaceholder = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblStatistics = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnDeleteAll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnDeleteUser = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        btnParseRss = new javax.swing.JButton();

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

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/df_profile.jpg"))); // NOI18N

        lblStatistics.setBackground(new java.awt.Color(24, 24, 24));
        lblStatistics.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 16)); // NOI18N
        lblStatistics.setForeground(new java.awt.Color(255, 255, 255));
        lblStatistics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatistics.setText("STATISTICS");
        lblStatistics.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        jScrollPane1.setBackground(new java.awt.Color(24, 24, 24));

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
        jScrollPane1.setViewportView(tblUsers);

        btnDeleteAll.setBackground(new java.awt.Color(255, 102, 102));
        btnDeleteAll.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnDeleteAll.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAll.setText("DELETE ALL");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(24, 24, 24));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        btnDeleteUser.setBackground(new java.awt.Color(255, 102, 102));
        btnDeleteUser.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUser.setText("DEACTIVATE PROFILE");

        lblUsername.setBackground(new java.awt.Color(24, 24, 24));
        lblUsername.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 16)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("USERNAME");
        lblUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        btnParseRss.setBackground(new java.awt.Color(153, 153, 255));
        btnParseRss.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnParseRss.setForeground(new java.awt.Color(255, 255, 255));
        btnParseRss.setText("LOAD DB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnParseRss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnParseRss, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        int selectedRow = tblUsers.getSelectedRow();
        selectedUserId = (int) userTableModel.getValueAt(selectedRow, 0);

        try {
            Optional<User> optUser = userRepository.findById(selectedUserId);
            
            if (optUser.isPresent()) {
                lblUsername.setText(optUser.get().getUsername());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tblUsersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnParseRss;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JPanel lblPlaceholder;
    private javax.swing.JLabel lblStatistics;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblmage;
    private javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables

    private UserRepository userRepository;
    private UserTableModel userTableModel;
    private int selectedUserId;

    private void init() {
        try {
            initRepository();
            initTable();
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtils.showErrorMessage("ERROR", "Failed to initialize the form!");
        }
    }

    private void initRepository() {
        userRepository = RepositoryFactory.getRepository();
    }

    private void initTable() throws Exception {
        tblUsers.setRowHeight(25);
        tblUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblUsers.setAutoCreateRowSorter(true);

        userTableModel = new UserTableModel(userRepository.findAll());
        tblUsers.setModel(userTableModel);
    }
}
