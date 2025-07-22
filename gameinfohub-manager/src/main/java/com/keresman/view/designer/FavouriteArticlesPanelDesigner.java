package com.keresman.view.designer;

import com.keresman.model.Article;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

public abstract class FavouriteArticlesPanelDesigner extends JPanel {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JLabel lblArticles2;
  protected javax.swing.JLabel lblDndDirection1;
  protected javax.swing.JLabel lblDndDirection2;
  protected javax.swing.JLabel lblFavouriteArticles;
  protected javax.swing.JLabel lblFavourites1;
  protected javax.swing.JList<Article> lsArticles;
  protected javax.swing.JList<Article> lsFavouriteArticles;
  protected javax.swing.JScrollPane spArticles;
  protected javax.swing.JScrollPane spFavArticles;

  // End of variables declaration//GEN-END:variables

  protected FavouriteArticlesPanelDesigner() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    lblFavouriteArticles = new javax.swing.JLabel();
    spFavArticles = new javax.swing.JScrollPane();
    lsFavouriteArticles = new javax.swing.JList<>();
    spArticles = new javax.swing.JScrollPane();
    lsArticles = new javax.swing.JList<>();
    lblDndDirection2 = new javax.swing.JLabel();
    lblArticles2 = new javax.swing.JLabel();
    lblFavourites1 = new javax.swing.JLabel();
    lblDndDirection1 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(24, 24, 24));
    setPreferredSize(new java.awt.Dimension(942, 800));
    addComponentListener(
        new java.awt.event.ComponentAdapter() {
          public void componentShown(java.awt.event.ComponentEvent evt) {
            formComponentShown(evt);
          }
        });

    lblFavouriteArticles.setBackground(new java.awt.Color(24, 24, 24));
    lblFavouriteArticles.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    lblFavouriteArticles.setForeground(new java.awt.Color(255, 255, 255));
    lblFavouriteArticles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblFavouriteArticles.setText("Favourites");
    lblFavouriteArticles.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lsFavouriteArticles.setBackground(new java.awt.Color(44, 44, 44));
    lsFavouriteArticles.setForeground(new java.awt.Color(255, 255, 255));
    spFavArticles.setViewportView(lsFavouriteArticles);

    lsArticles.setBackground(new java.awt.Color(44, 44, 44));
    lsArticles.setForeground(new java.awt.Color(255, 255, 255));
    spArticles.setViewportView(lsArticles);

    lblDndDirection2.setBackground(new java.awt.Color(24, 24, 24));
    lblDndDirection2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblDndDirection2.setForeground(new java.awt.Color(255, 255, 255));
    lblDndDirection2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblDndDirection2.setText("---->");
    lblDndDirection2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lblArticles2.setBackground(new java.awt.Color(24, 24, 24));
    lblArticles2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    lblArticles2.setForeground(new java.awt.Color(255, 255, 255));
    lblArticles2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblArticles2.setText("Articles");
    lblArticles2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lblFavourites1.setBackground(new java.awt.Color(24, 24, 24));
    lblFavourites1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblFavourites1.setForeground(new java.awt.Color(255, 255, 255));
    lblFavourites1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblFavourites1.setText("Favourite Articles");
    lblFavourites1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

    lblDndDirection1.setBackground(new java.awt.Color(24, 24, 24));
    lblDndDirection1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
    lblDndDirection1.setForeground(new java.awt.Color(255, 255, 255));
    lblDndDirection1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lblDndDirection1.setText("---->");
    lblDndDirection1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

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
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(
                                spArticles,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(
                                        lblArticles2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        202,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
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
                                    .addGap(28, 28, 28)
                                    .addComponent(
                                        spFavArticles,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        293,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        lblFavouriteArticles,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        202,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(117, 117, 117))))
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(
                                lblFavourites1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                806,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(71, Short.MAX_VALUE))));
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
                                lblFavouriteArticles,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                lblArticles2,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                spArticles,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                564,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(
                                                spFavArticles,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                564,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(53, 53, 53))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        lblDndDirection1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(
                                        lblDndDirection2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(362, 362, 362))))
            .addGroup(
                layout
                    .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(
                        layout
                            .createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(
                                lblFavourites1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                48,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(714, Short.MAX_VALUE))));
  } // </editor-fold>//GEN-END:initComponents

  public abstract void formComponentShown(ComponentEvent evt);
}
