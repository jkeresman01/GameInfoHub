package com.keresman.view.designer;

import com.keresman.model.Comment;
import com.keresman.model.Developer;
import com.keresman.model.Genre;
import com.keresman.model.Platform;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public abstract class GamesPanelDesigner extends JPanel {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JButton btnAdd;
  protected javax.swing.JButton btnComment;
  protected javax.swing.JButton btnDelete;
  protected javax.swing.JButton btnUpdate;
  protected javax.swing.JLabel lblComments;
  protected javax.swing.JLabel lblDevelopment;
  protected javax.swing.JLabel lblErrorGameName;
  protected javax.swing.JLabel lblErrorRelDate;
  protected javax.swing.JLabel lblGameName;
  protected javax.swing.JLabel lblGenre;
  protected javax.swing.JLabel lblPlatform;
  protected javax.swing.JLabel lblRelDate;
  protected javax.swing.JLabel lblmage;
  protected javax.swing.JList<Comment> lsComments;
  protected javax.swing.JList<Developer> lsDevelopement;
  protected javax.swing.JList<Genre> lsGenre;
  protected javax.swing.JList<Platform> lsPlatform;
  protected javax.swing.JPanel pnlContainer;
  protected javax.swing.JScrollPane spComments;
  protected javax.swing.JScrollPane spDevelopment;
  protected javax.swing.JScrollPane spGamesTable;
  protected javax.swing.JScrollPane spGenre;
  protected javax.swing.JScrollPane spPlatform;
  protected javax.swing.JTable tblGames;
  protected javax.swing.JTextField tfGameName;
  protected javax.swing.JTextField tfRelDate;

  // End of variables declaration//GEN-END:variables

  protected GamesPanelDesigner() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pnlContainer = new javax.swing.JPanel();
    lblComments = new javax.swing.JLabel();
    lblErrorRelDate = new javax.swing.JLabel();
    lblRelDate = new javax.swing.JLabel();
    lblGameName = new javax.swing.JLabel();
    tfRelDate = new javax.swing.JTextField();
    tfGameName = new javax.swing.JTextField();
    btnAdd = new javax.swing.JButton();
    btnDelete = new javax.swing.JButton();
    btnUpdate = new javax.swing.JButton();
    lblErrorGameName = new javax.swing.JLabel();
    spGamesTable = new javax.swing.JScrollPane();
    tblGames = new javax.swing.JTable();
    spComments = new javax.swing.JScrollPane();
    lsComments = new javax.swing.JList<>();
    spDevelopment = new javax.swing.JScrollPane();
    lsDevelopement = new javax.swing.JList<>();
    spGenre = new javax.swing.JScrollPane();
    lsGenre = new javax.swing.JList<>();
    spPlatform = new javax.swing.JScrollPane();
    lsPlatform = new javax.swing.JList<>();
    lblGenre = new javax.swing.JLabel();
    lblPlatform = new javax.swing.JLabel();
    lblDevelopment = new javax.swing.JLabel();
    btnComment = new javax.swing.JButton();
    lblmage = new javax.swing.JLabel();

    setPreferredSize(new java.awt.Dimension(1540, 800));

    pnlContainer.setBackground(new java.awt.Color(24, 24, 24));

    lblComments.setBackground(new java.awt.Color(24, 24, 24));
    lblComments.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblComments.setForeground(new java.awt.Color(255, 255, 255));
    lblComments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblComments.setText("Comments");
    lblComments.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lblErrorRelDate.setForeground(new java.awt.Color(255, 82, 82));
    lblErrorRelDate.setText("Required");

    lblRelDate.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
    lblRelDate.setText("Rel. date");

    lblGameName.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
    lblGameName.setText("Name");

    tfRelDate.setBackground(new java.awt.Color(44, 44, 44));

    tfGameName.setBackground(new java.awt.Color(44, 44, 44));

    btnAdd.setBackground(new java.awt.Color(0, 200, 83));
    btnAdd.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
    btnAdd.setForeground(new java.awt.Color(255, 255, 255));
    btnAdd.setText("+ Add +");
    btnAdd.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
          }
        });

    btnDelete.setBackground(new java.awt.Color(211, 47, 47));
    btnDelete.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
    btnDelete.setForeground(new java.awt.Color(255, 255, 255));
    btnDelete.setText("X Delete X");
    btnDelete.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteActionPerformed(evt);
          }
        });

    btnUpdate.setBackground(new java.awt.Color(255, 255, 153));
    btnUpdate.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
    btnUpdate.setForeground(new java.awt.Color(24, 24, 24));
    btnUpdate.setText("| Update |");
    btnUpdate.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateActionPerformed(evt);
          }
        });

    lblErrorGameName.setForeground(new java.awt.Color(255, 82, 82));
    lblErrorGameName.setText("Required");

    tblGames.setBackground(new java.awt.Color(24, 24, 24));
    tblGames.setModel(
        new javax.swing.table.DefaultTableModel(
            new Object[][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
            },
            new String[] {"Title 1", "Title 2", "Title 3", "Title 4"}));
    tblGames.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblGamesMouseClicked(evt);
          }
        });
    spGamesTable.setViewportView(tblGames);

    lsComments.setBackground(new java.awt.Color(44, 44, 44));
    lsComments.setForeground(new java.awt.Color(255, 255, 255));
    spComments.setViewportView(lsComments);

    lsDevelopement.setBackground(new java.awt.Color(44, 44, 44));
    lsDevelopement.setForeground(new java.awt.Color(255, 255, 255));
    spDevelopment.setViewportView(lsDevelopement);

    lsGenre.setBackground(new java.awt.Color(44, 44, 44));
    lsGenre.setForeground(new java.awt.Color(255, 255, 255));
    spGenre.setViewportView(lsGenre);

    lsPlatform.setBackground(new java.awt.Color(44, 44, 44));
    lsPlatform.setForeground(new java.awt.Color(255, 255, 255));
    spPlatform.setViewportView(lsPlatform);

    lblGenre.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
    lblGenre.setText("Genre");

    lblPlatform.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
    lblPlatform.setText("Platform");

    lblDevelopment.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
    lblDevelopment.setText("Development");

    btnComment.setBackground(new java.awt.Color(204, 51, 255));
    btnComment.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
    btnComment.setForeground(new java.awt.Color(255, 255, 255));
    btnComment.setText("??? Comment ???");
    btnComment.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCommentActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout pnlContainerLayout = new javax.swing.GroupLayout(pnlContainer);
    pnlContainer.setLayout(pnlContainerLayout);
    pnlContainerLayout.setHorizontalGroup(
        pnlContainerLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlContainerLayout
                    .createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(
                        spGamesTable,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        381,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(54, 54, 54)
                    .addGroup(
                        pnlContainerLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(
                                spComments,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                278,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                lblComments,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                278,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                    .addGroup(
                        pnlContainerLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                lblGenre,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                92,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                spPlatform,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                378,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(
                                pnlContainerLayout
                                    .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(
                                        btnComment,
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        pnlContainerLayout
                                            .createSequentialGroup()
                                            .addComponent(
                                                btnAdd,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                108,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(
                                                btnUpdate,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                108,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                btnDelete,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                122,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(
                                        spGenre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spDevelopment)
                                    .addComponent(
                                        lblPlatform,
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        92,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        lblDevelopment,
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        92,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        pnlContainerLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                lblErrorRelDate,
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                lblErrorGameName,
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(
                                                pnlContainerLayout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        false)
                                                    .addGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                        pnlContainerLayout
                                                            .createSequentialGroup()
                                                            .addComponent(
                                                                lblRelDate,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                92,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE)
                                                            .addPreferredGap(
                                                                javax.swing.LayoutStyle
                                                                    .ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout
                                                                    .DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                            .addComponent(
                                                                tfRelDate,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                261,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE))
                                                    .addGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                        pnlContainerLayout
                                                            .createSequentialGroup()
                                                            .addComponent(
                                                                lblGameName,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                95,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(
                                                                tfGameName,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                264,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE))))))
                    .addGap(20, 20, 20)));
    pnlContainerLayout.setVerticalGroup(
        pnlContainerLayout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                pnlContainerLayout
                    .createSequentialGroup()
                    .addGroup(
                        pnlContainerLayout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(
                                pnlContainerLayout
                                    .createSequentialGroup()
                                    .addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(
                                        pnlContainerLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(
                                                pnlContainerLayout
                                                    .createSequentialGroup()
                                                    .addComponent(lblComments)
                                                    .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement
                                                            .RELATED)
                                                    .addComponent(
                                                        spComments,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        654,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(
                                                spGamesTable,
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                692,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                pnlContainerLayout
                                    .createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addGroup(
                                        pnlContainerLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                tfGameName,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblGameName))
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblErrorGameName)
                                    .addGap(16, 16, 16)
                                    .addGroup(
                                        pnlContainerLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblRelDate)
                                            .addComponent(
                                                tfRelDate,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(lblErrorRelDate)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblGenre)
                                    .addGap(28, 28, 28)
                                    .addComponent(
                                        spGenre,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        87,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(lblPlatform)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        spPlatform,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        91,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(lblDevelopment)
                                    .addGap(18, 18, 18)
                                    .addComponent(
                                        spDevelopment,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        101,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55)
                                    .addComponent(
                                        btnComment,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addGroup(
                                        pnlContainerLayout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(
                                                btnAdd,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                btnUpdate,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                btnDelete,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)))
                    .addGap(46, 46, 46)));

    lblmage.setBackground(new java.awt.Color(24, 24, 24));
    lblmage.setIcon(
        new javax.swing.ImageIcon(getClass().getResource("/assets/profile12.jpg"))); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        pnlContainer,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        lblmage,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        301,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                pnlContainer,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout
                    .createSequentialGroup()
                    .addComponent(lblmage)
                    .addGap(0, 0, Short.MAX_VALUE)));
  } // </editor-fold>//GEN-END:initComponents

  public abstract void btnCommentActionPerformed(ActionEvent evt);

  public abstract void btnAddActionPerformed(ActionEvent evt);

  public abstract void btnDeleteActionPerformed(ActionEvent evt);

  public abstract void btnUpdateActionPerformed(ActionEvent evt);

  public abstract void tblGamesMouseClicked(MouseEvent evt);
}
