package com.keresman.view.designer;

import com.keresman.model.Game;
import javax.swing.JPanel;

public abstract class FavouriteGamesPanelDesigner extends JPanel {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JLabel lblDndDirection1;
  protected javax.swing.JLabel lblDndDirection2;
  protected javax.swing.JLabel lblFavouriteGames;
  protected javax.swing.JLabel lblFavourites;
  protected javax.swing.JLabel lblGames;
  protected javax.swing.JList<Game> lsFavouriteGames;
  protected javax.swing.JList<Game> lsGames;
  protected javax.swing.JScrollPane spFavGames;
  protected javax.swing.JScrollPane spGames;

  // End of variables declaration//GEN-END:variables

  protected FavouriteGamesPanelDesigner() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    lblFavouriteGames = new javax.swing.JLabel();
    spFavGames = new javax.swing.JScrollPane();
    lsFavouriteGames = new javax.swing.JList<>();
    spGames = new javax.swing.JScrollPane();
    lsGames = new javax.swing.JList<>();
    lblFavourites = new javax.swing.JLabel();
    lblGames = new javax.swing.JLabel();
    lblDndDirection1 = new javax.swing.JLabel();
    lblDndDirection2 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(24, 24, 24));
    setPreferredSize(new java.awt.Dimension(942, 800));

    lblFavouriteGames.setBackground(new java.awt.Color(24, 24, 24));
    lblFavouriteGames.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    lblFavouriteGames.setForeground(new java.awt.Color(255, 255, 255));
    lblFavouriteGames.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblFavouriteGames.setText("Favourites");
    lblFavouriteGames.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lsFavouriteGames.setBackground(new java.awt.Color(44, 44, 44));
    lsFavouriteGames.setForeground(new java.awt.Color(255, 255, 255));
    spFavGames.setViewportView(lsFavouriteGames);

    lsGames.setBackground(new java.awt.Color(44, 44, 44));
    lsGames.setForeground(new java.awt.Color(255, 255, 255));
    spGames.setViewportView(lsGames);

    lblFavourites.setBackground(new java.awt.Color(24, 24, 24));
    lblFavourites.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblFavourites.setForeground(new java.awt.Color(255, 255, 255));
    lblFavourites.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblFavourites.setText("Favourite Games");
    lblFavourites.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lblGames.setBackground(new java.awt.Color(24, 24, 24));
    lblGames.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    lblGames.setForeground(new java.awt.Color(255, 255, 255));
    lblGames.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblGames.setText("Games");
    lblGames.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lblDndDirection1.setBackground(new java.awt.Color(24, 24, 24));
    lblDndDirection1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblDndDirection1.setForeground(new java.awt.Color(255, 255, 255));
    lblDndDirection1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblDndDirection1.setText("---->");
    lblDndDirection1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lblDndDirection2.setBackground(new java.awt.Color(24, 24, 24));
    lblDndDirection2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblDndDirection2.setForeground(new java.awt.Color(255, 255, 255));
    lblDndDirection2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblDndDirection2.setText("---->");
    lblDndDirection2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                spGames, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(
                                lblGames,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                spFavGames,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                276,
                                Short.MAX_VALUE)
                            .addComponent(
                                lblFavouriteGames,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addGap(81, 81, 81))
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(
                                lblFavourites,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                806,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(81, Short.MAX_VALUE)))
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(371, 371, 371)
                            .addGroup(
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(
                                        lblDndDirection1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                        lblDndDirection2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        200,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(371, Short.MAX_VALUE))));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap(117, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                lblFavouriteGames,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                lblGames,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                spGames, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                            .addComponent(spFavGames))
                    .addGap(80, 80, 80))
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(
                                lblFavourites,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(724, Short.MAX_VALUE)))
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(349, 349, 349)
                            .addComponent(
                                lblDndDirection1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(
                                lblDndDirection2,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(349, Short.MAX_VALUE))));
  } // </editor-fold>//GEN-END:initComponents
}
