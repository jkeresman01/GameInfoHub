package com.keresman.view;

import static javax.swing.TransferHandler.MOVE;

import com.keresman.dal.FavoriteGamesRepository;
import com.keresman.dal.GameRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Game;
import com.keresman.model.GameTransferable;
import com.keresman.session.SessionManager;
import com.keresman.view.designer.FavouriteGamesPanelDesigner;
import java.awt.datatransfer.Transferable;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class FavouriteGamesPanel extends FavouriteGamesPanelDesigner {

  private Set<Game> allGames = new TreeSet<>();
  private Set<Game> favGames = new TreeSet<>();

  private GameRepository gameRepository;
  private FavoriteGamesRepository favoriteGamesRepository;

  private final DefaultListModel<Game> allGamesModel = new DefaultListModel<>();
  private final DefaultListModel<Game> favGamesModel = new DefaultListModel<>();

  public FavouriteGamesPanel() throws Exception {
    super();
    init();
  }

  private void init() throws Exception {
    initRepositories();
    initDragAndDrop();
    loadGamesFromDb();
    loadAllModels();
  }

  private void initRepositories() throws Exception {
    gameRepository = RepositoryFactory.getInstance(GameRepository.class);
    favoriteGamesRepository = RepositoryFactory.getInstance(FavoriteGamesRepository.class);
  }

  private void initDragAndDrop() {
    initExportDnD();
    initImportDnd();
  }

  private void initExportDnD() {
    lsGames.setDragEnabled(true);
    lsGames.setTransferHandler(new AllGamesExportHandler());
  }

  private void initImportDnd() {
    lsFavouriteGames.setDropMode(DropMode.ON);
    lsFavouriteGames.setTransferHandler(new FavouriteGamesImportHandler());
  }

  private void loadGamesFromDb() throws Exception {
    allGames.clear();
    favGames.clear();

    Set<Game> all = new TreeSet<>(gameRepository.findAll());
    Set<Game> fav = new TreeSet<>(favoriteGamesRepository.findAll());

    favGames.addAll(fav);
    allGames.addAll(all);
    allGames.removeAll(favGames);
  }

  private abstract class AbstractExportTransferHandler extends TransferHandler {

    @Override
    public int getSourceActions(JComponent c) {
      return MOVE;
    }

    @Override
    protected abstract Transferable createTransferable(JComponent c);
  }

  private class AllGamesExportHandler extends AbstractExportTransferHandler {

    private Game exportedGame;

    @Override
    protected Transferable createTransferable(JComponent c) {
      exportedGame = lsGames.getSelectedValue();
      return new GameTransferable(exportedGame);
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
      if (action == MOVE && exportedGame != null) {
        allGames.remove(exportedGame);
        loadAllModels();
      }
    }
  }

  private class FavouriteGamesExportHandler extends AbstractExportTransferHandler {

    private Game exportedGame;

    @Override
    protected Transferable createTransferable(JComponent c) {
      exportedGame = lsFavouriteGames.getSelectedValue();
      return new GameTransferable(exportedGame);
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
      if (action == MOVE && exportedGame != null) {
        favGames.remove(exportedGame);
        loadAllModels();
      }
    }
  }

  private abstract class AbstractImportTransferHandler extends TransferHandler {

    @Override
    public boolean canImport(TransferSupport support) {
      return support.isDataFlavorSupported(GameTransferable.GAME_FLAVOUR);
    }

    @Override
    public abstract boolean importData(TransferSupport support);
  }

  private class FavouriteGamesImportHandler extends AbstractImportTransferHandler {

    @Override
    public boolean importData(TransferSupport support) {
      try {
        Game game = (Game) support.getTransferable().getTransferData(GameTransferable.GAME_FLAVOUR);
        if (favGames.add(game)) {
          allGames.remove(game);
          favoriteGamesRepository.save(game, SessionManager.getInstance().getCurrentUser());
          loadFavGamesModel();
          return true;
        }
      } catch (Exception ex) {
        Logger.getLogger(FavouriteGamesPanel.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;
    }
  }

  private class AllGamesImportHandler extends AbstractImportTransferHandler {

    @Override
    public boolean importData(TransferSupport support) {
      try {
        Game game = (Game) support.getTransferable().getTransferData(GameTransferable.GAME_FLAVOUR);
        if (allGames.add(game)) {
          favGames.remove(game);
          loadAllModels();
          return true;
        }
      } catch (Exception ex) {
        Logger.getLogger(FavouriteGamesPanel.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;
    }
  }

  private void loadAllModels() {
    loadAllGamesModels();
    loadFavGamesModel();
  }

  private void loadAllGamesModels() {
    allGamesModel.clear();
    allGames.forEach(allGamesModel::addElement);
    lsGames.setModel(allGamesModel);
  }

  private void loadFavGamesModel() {
    favGamesModel.clear();
    favGames.forEach(favGamesModel::addElement);
    lsFavouriteGames.setModel(favGamesModel);
  }
}
