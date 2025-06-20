package com.keresman.view.designer;

import com.keresman.model.Developer;
import javax.swing.JPanel;

public abstract class FavouriteDevelopersPanelDesigner extends JPanel {

    protected FavouriteDevelopersPanelDesigner() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFavouriteDevelopers = new javax.swing.JLabel();
        spFavDevelopers = new javax.swing.JScrollPane();
        lsFavouriteDevelopers = new javax.swing.JList<>();
        spDevelopers = new javax.swing.JScrollPane();
        lsDevelopers = new javax.swing.JList<>();
        lblFavourites = new javax.swing.JLabel();
        lblDevelopers = new javax.swing.JLabel();

        setBackground(new java.awt.Color(24, 24, 24));
        setPreferredSize(new java.awt.Dimension(942, 800));

        lblFavouriteDevelopers.setBackground(new java.awt.Color(24, 24, 24));
        lblFavouriteDevelopers.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFavouriteDevelopers.setForeground(new java.awt.Color(255, 255, 255));
        lblFavouriteDevelopers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFavouriteDevelopers.setText("Favourites");
        lblFavouriteDevelopers.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lsFavouriteDevelopers.setBackground(new java.awt.Color(204, 204, 255));
        spFavDevelopers.setViewportView(lsFavouriteDevelopers);

        lsDevelopers.setBackground(new java.awt.Color(204, 204, 255));
        spDevelopers.setViewportView(lsDevelopers);

        lblFavourites.setBackground(new java.awt.Color(24, 24, 24));
        lblFavourites.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 28)); // NOI18N
        lblFavourites.setForeground(new java.awt.Color(255, 255, 255));
        lblFavourites.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFavourites.setText("Favourite Devlopers");
        lblFavourites.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        lblDevelopers.setBackground(new java.awt.Color(24, 24, 24));
        lblDevelopers.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDevelopers.setForeground(new java.awt.Color(255, 255, 255));
        lblDevelopers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDevelopers.setText("Developers");
        lblDevelopers.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 10, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spDevelopers, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(lblDevelopers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(375, 375, 375)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFavouriteDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spFavDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(lblFavouriteDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spFavDevelopers, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(lblFavourites, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(724, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel lblDevelopers;
    protected javax.swing.JLabel lblFavouriteDevelopers;
    protected javax.swing.JLabel lblFavourites;
    protected javax.swing.JList<Developer> lsDevelopers;
    protected javax.swing.JList<Developer> lsFavouriteDevelopers;
    protected javax.swing.JScrollPane spDevelopers;
    protected javax.swing.JScrollPane spFavDevelopers;
    // End of variables declaration//GEN-END:variables
}
