package com.keresman.view.designer;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public abstract class ArticlesPanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnAdd;
    protected javax.swing.JButton btnDelete;
    protected javax.swing.JButton btnUpdate;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel lblArticles;
    protected javax.swing.JLabel lblDescription;
    protected javax.swing.JLabel lblErrorDesription;
    protected javax.swing.JLabel lblErrorLink;
    protected javax.swing.JLabel lblErrorPubDate;
    protected javax.swing.JLabel lblErrorTitle;
    protected javax.swing.JLabel lblImage;
    protected javax.swing.JLabel lblLink;
    protected javax.swing.JLabel lblPubDate;
    protected javax.swing.JLabel lblTitle;
    protected javax.swing.JLabel lblmage;
    protected javax.swing.JPanel pnlPlaceholder;
    protected javax.swing.JScrollPane spGamesTable;
    protected javax.swing.JTextArea taDescription;
    protected javax.swing.JTable tblArticles;
    protected javax.swing.JTextField tfLink;
    protected javax.swing.JTextField tfPubDate;
    protected javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

    protected ArticlesPanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPlaceholder = new javax.swing.JPanel();
        lblmage = new javax.swing.JLabel();
        spGamesTable = new javax.swing.JScrollPane();
        tblArticles = new javax.swing.JTable();
        lblImage = new javax.swing.JLabel();
        lblArticles = new javax.swing.JLabel();
        lblLink = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        lblPubDate = new javax.swing.JLabel();
        tfPubDate = new javax.swing.JTextField();
        tfTitle = new javax.swing.JTextField();
        tfLink = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblErrorTitle = new javax.swing.JLabel();
        lblErrorLink = new javax.swing.JLabel();
        lblErrorDesription = new javax.swing.JLabel();
        lblErrorPubDate = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        pnlPlaceholder.setBackground(new java.awt.Color(24, 24, 24));

        lblmage.setBackground(new java.awt.Color(24, 24, 24));
        lblmage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/profile12.jpg"))); // NOI18N

        tblArticles.setBackground(new java.awt.Color(24, 24, 24));
        tblArticles.setModel(new javax.swing.table.DefaultTableModel(
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
        spGamesTable.setViewportView(tblArticles);

        lblImage.setBackground(new java.awt.Color(44, 44, 44));
        lblImage.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblImage.setForeground(new java.awt.Color(255, 255, 255));
        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("Click to select image");
        lblImage.setOpaque(true);
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        lblArticles.setBackground(new java.awt.Color(24, 24, 24));
        lblArticles.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
        lblArticles.setForeground(new java.awt.Color(255, 255, 255));
        lblArticles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArticles.setText("Articles");
        lblArticles.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblLink.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lblLink.setText("Link");

        lblDescription.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lblDescription.setText("Description");

        taDescription.setBackground(new java.awt.Color(44, 44, 44));
        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        lblPubDate.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lblPubDate.setText("Published date");

        tfPubDate.setBackground(new java.awt.Color(44, 44, 44));

        tfTitle.setBackground(new java.awt.Color(44, 44, 44));

        tfLink.setBackground(new java.awt.Color(44, 44, 44));

        btnAdd.setBackground(new java.awt.Color(0, 200, 83));
        btnAdd.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("+ Add +");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(211, 47, 47));
        btnDelete.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("X Delete X");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 153));
        btnUpdate.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(24, 24, 24));
        btnUpdate.setText("| Update |");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblErrorTitle.setForeground(new java.awt.Color(255, 82, 82));
        lblErrorTitle.setText("Required");

        lblErrorLink.setForeground(new java.awt.Color(255, 82, 82));
        lblErrorLink.setText("Required");

        lblErrorDesription.setForeground(new java.awt.Color(255, 82, 82));
        lblErrorDesription.setText("Required");

        lblErrorPubDate.setForeground(new java.awt.Color(255, 82, 82));
        lblErrorPubDate.setText("Required");

        lblTitle.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lblTitle.setText("Title");

        javax.swing.GroupLayout pnlPlaceholderLayout = new javax.swing.GroupLayout(pnlPlaceholder);
        pnlPlaceholder.setLayout(pnlPlaceholderLayout);
        pnlPlaceholderLayout.setHorizontalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                                    .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblErrorLink))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                                    .addComponent(lblPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblErrorPubDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1)
                                .addComponent(lblErrorDesription, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblErrorTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                                    .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                        .addComponent(tfLink))))
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spGamesTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(649, Short.MAX_VALUE))
            .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                    .addGap(0, 942, Short.MAX_VALUE)
                    .addComponent(lblmage)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlPlaceholderLayout.setVerticalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorTitle)
                        .addGap(13, 13, 13)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLink)
                            .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblDescription))
                            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblErrorLink)))
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblErrorDesription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPubDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorPubDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(spGamesTable, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblmage)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1542, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(pnlPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public abstract void btnAddActionPerformed(ActionEvent evt);

    public abstract void btnUpdateActionPerformed(ActionEvent evt);

    public abstract void btnDeleteActionPerformed(ActionEvent evt);

    public abstract void lblImageMouseClicked(MouseEvent evt);
}
