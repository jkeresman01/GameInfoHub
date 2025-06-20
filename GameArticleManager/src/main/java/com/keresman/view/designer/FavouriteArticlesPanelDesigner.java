package com.keresman.view.designer;

import com.keresman.model.Article;
import javax.swing.JPanel;

public abstract class FavouriteArticlesPanelDesigner extends JPanel {

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
        lblFavourites = new javax.swing.JLabel();
        lblArticles2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(24, 24, 24));
        setPreferredSize(new java.awt.Dimension(942, 800));

        lblFavouriteArticles.setBackground(new java.awt.Color(24, 24, 24));
        lblFavouriteArticles.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFavouriteArticles.setForeground(new java.awt.Color(255, 255, 255));
        lblFavouriteArticles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFavouriteArticles.setText("Favourites");
        lblFavouriteArticles.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lsFavouriteArticles.setBackground(new java.awt.Color(204, 204, 255));
        spFavArticles.setViewportView(lsFavouriteArticles);

        lsArticles.setBackground(new java.awt.Color(204, 204, 255));
        spArticles.setViewportView(lsArticles);

        lblFavourites.setBackground(new java.awt.Color(24, 24, 24));
        lblFavourites.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
        lblFavourites.setForeground(new java.awt.Color(255, 255, 255));
        lblFavourites.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFavourites.setText("Favourite Articles");
        lblFavourites.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblArticles2.setBackground(new java.awt.Color(24, 24, 24));
        lblArticles2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblArticles2.setForeground(new java.awt.Color(255, 255, 255));
        lblArticles2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArticles2.setText("Articles");
        lblArticles2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spArticles, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(lblArticles2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(375, 375, 375)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFavouriteArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spFavArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(lblFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(81, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFavouriteArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArticles2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spFavArticles, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(lblFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(724, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel lblArticles2;
    protected javax.swing.JLabel lblFavouriteArticles;
    protected javax.swing.JLabel lblFavourites;
    protected javax.swing.JList<Article> lsArticles;
    protected javax.swing.JList<Article> lsFavouriteArticles;
    protected javax.swing.JScrollPane spArticles;
    protected javax.swing.JScrollPane spFavArticles;
    // End of variables declaration//GEN-END:variables
}
