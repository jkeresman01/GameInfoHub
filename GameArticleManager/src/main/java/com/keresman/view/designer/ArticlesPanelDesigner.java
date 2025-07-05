package com.keresman.view.designer;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;

public abstract class ArticlesPanelDesigner extends JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnAdd;
    protected javax.swing.JButton btnClear;
    protected javax.swing.JButton btnDelete;
    protected javax.swing.JButton btnReport;
    protected javax.swing.JButton btnUpdate;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel lblDescription;
    protected javax.swing.JLabel lblErrorDesription;
    protected javax.swing.JLabel lblErrorLink;
    protected javax.swing.JLabel lblErrorPubDate;
    protected javax.swing.JLabel lblErrorTitle;
    protected javax.swing.JLabel lblLink;
    protected javax.swing.JLabel lblPubDate;
    protected javax.swing.JLabel lblTitle;
    protected javax.swing.JLabel lblcon;
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
        lblcon = new javax.swing.JLabel();
        lblLink = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
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
        btnClear = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        lblPubDate = new javax.swing.JLabel();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        pnlPlaceholder.setBackground(new java.awt.Color(24, 24, 24));
        pnlPlaceholder.setPreferredSize(new java.awt.Dimension(1574, 800));

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
        tblArticles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArticlesMouseClicked(evt);
            }
        });
        spGamesTable.setViewportView(tblArticles);

        lblcon.setBackground(new java.awt.Color(44, 44, 44));
        lblcon.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblcon.setForeground(new java.awt.Color(255, 255, 255));
        lblcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcon.setText("Click to select image");
        lblcon.setMaximumSize(new java.awt.Dimension(450, 410));
        lblcon.setOpaque(true);
        lblcon.setPreferredSize(new java.awt.Dimension(450, 410));
        lblcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblconMouseClicked(evt);
            }
        });

        lblLink.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lblLink.setText("Link");

        lblDescription.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lblDescription.setText("Description");

        taDescription.setBackground(new java.awt.Color(44, 44, 44));
        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        tfPubDate.setBackground(new java.awt.Color(44, 44, 44));

        tfTitle.setBackground(new java.awt.Color(44, 44, 44));
        tfTitle.setMaximumSize(new java.awt.Dimension(530, 22));
        tfTitle.setMinimumSize(new java.awt.Dimension(530, 22));
        tfTitle.setPreferredSize(new java.awt.Dimension(530, 22));

        tfLink.setBackground(new java.awt.Color(44, 44, 44));
        tfLink.setMaximumSize(new java.awt.Dimension(530, 22));
        tfLink.setMinimumSize(new java.awt.Dimension(530, 22));
        tfLink.setPreferredSize(new java.awt.Dimension(530, 22));

        btnAdd.setBackground(new java.awt.Color(0, 200, 83));
        btnAdd.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("+ Create +");
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
        btnUpdate.setText("<| Update |>");
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

        btnClear.setBackground(new java.awt.Color(255, 204, 204));
        btnClear.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(24, 24, 24));
        btnClear.setText("| Clear |");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnReport.setBackground(new java.awt.Color(255, 102, 102));
        btnReport.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        btnReport.setForeground(new java.awt.Color(24, 24, 24));
        btnReport.setText("| Report |");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        lblPubDate.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        lblPubDate.setText("Published date");

        javax.swing.GroupLayout pnlPlaceholderLayout = new javax.swing.GroupLayout(pnlPlaceholder);
        pnlPlaceholder.setLayout(pnlPlaceholderLayout);
        pnlPlaceholderLayout.setHorizontalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                                .addComponent(lblPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblErrorDesription, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblErrorPubDate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblErrorLink, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblErrorTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                                .addComponent(lblLink, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblcon, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addComponent(spGamesTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1105, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addComponent(lblmage, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlPlaceholderLayout.setVerticalGroup(
            pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPlaceholderLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorLink)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLink)
                            .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblErrorDesription)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPubDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblErrorPubDate)
                        .addGap(27, 27, 27)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblcon, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spGamesTable, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(pnlPlaceholderLayout.createSequentialGroup()
                .addComponent(lblmage)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1574, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlPlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public abstract void btnClearActionPerformed(ActionEvent evt);

    public abstract void btnReportActionPerformed(ActionEvent evt);

    public abstract void tblArticlesMouseClicked(MouseEvent evt);

    public abstract void formAncestorAdded(AncestorEvent evt);

    public abstract void btnAddActionPerformed(ActionEvent evt);

    public abstract void btnUpdateActionPerformed(ActionEvent evt);

    public abstract void btnDeleteActionPerformed(ActionEvent evt);

    public abstract void lblconMouseClicked(MouseEvent evt);
}
