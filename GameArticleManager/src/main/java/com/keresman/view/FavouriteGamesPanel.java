package com.keresman.view;

import com.keresman.model.Game;
import com.keresman.model.GameTransferable;
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
import static javax.swing.TransferHandler.MOVE;

public class FavouriteGamesPanel extends FavouriteGamesPanelDesigner {

    private Set<Game> allGames = new TreeSet<>();
    private Set<Game> favGames = new TreeSet<>();
    private final DefaultListModel<Game> allGamesModel = new DefaultListModel<>();
    private final DefaultListModel<Game> favGamesModel = new DefaultListModel<>();

    public FavouriteGamesPanel() {
        super();
        init();
    }

    private void init() {
        initDragAndDrop();
        loadGames();
        loadAllModels();
    }

    private void initDragAndDrop() {
        initExportDnD();
        initImportDnd();

    }

    private void initExportDnD() {
        lsGames.setDragEnabled(true);
        lsGames.setTransferHandler(new AllGamesExportHandler());

//        lsFavouriteGames.setDragEnabled(true);
//        lsFavouriteGames.setTransferHandler(new FavouriteGamesExportHandler());
    }

    private void initImportDnd() {
//        lsGames.setDropMode(DropMode.ON);
//        lsGames.setTransferHandler(new AllGamesImportHandler());

        lsFavouriteGames.setDropMode(DropMode.ON);
        lsFavouriteGames.setTransferHandler(new FavouriteGamesImportHandler());
    }

    private void loadGames() {
        allGames.add(new Game(1, "First game"));
        allGames.add(new Game(2, "Second game"));
        allGames.add(new Game(3, "Third game"));
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
