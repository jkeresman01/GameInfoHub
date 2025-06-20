package com.keresman.view;

import com.keresman.view.designer.FavouritesPanelDesigner;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class FavouritesPanel extends FavouritesPanelDesigner {

    private static final String FAVOURITE_ARTICLES = "Articles";
    private static final String FAVOURITE_GAMES = "Games";
    private static final String FAVOURITE_DEVELOPERS = "Developers";

    public FavouritesPanel() {
        super();
        init();
    }

    private void init() {
        initUI();
        initPanels();
    }

    private void initPanels() {
        tpFavourites.add(FAVOURITE_ARTICLES, new FavouriteArticlesPanel());
        tpFavourites.add(FAVOURITE_GAMES, new FavouriteGamesPanel());
        tpFavourites.add(FAVOURITE_DEVELOPERS, new FavouriteDevelopersPanel());
    }

    private void initUI() {
        tpFavourites.setUI(new BasicTabbedPaneUI() {
            @Override
            protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
                return tabPane.getWidth() / tabPane.getTabCount();
            }

            @Override
            protected void paintFocusIndicator(
                    Graphics g,
                    int tabPlacement,
                    Rectangle[] rects,
                    int tabIndex,
                    Rectangle iconRect,
                    Rectangle textRect,
                    boolean isSelected) {
            }
        });
    }

}
