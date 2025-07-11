package com.keresman.view;

import com.keresman.view.designer.FavouritesPanelDesigner;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class FavouritesPanel extends FavouritesPanelDesigner {

  private static final String FAVOURITE_ARTICLES = "Articles";
  private static final String FAVOURITE_GAMES = "Games";

  public FavouritesPanel() throws Exception {
    super();
    init();
  }

  private void init() throws Exception {
    initUI();
    initPanels();
  }

  private void initUI() {
    tpFavourites.setUI(new BasicTabbedPaneUI());
  }

  private void initPanels() throws Exception {
    tpFavourites.add(FAVOURITE_ARTICLES, new FavouriteArticlesPanel());
    tpFavourites.add(FAVOURITE_GAMES, new FavouriteGamesPanel());
  }
}
