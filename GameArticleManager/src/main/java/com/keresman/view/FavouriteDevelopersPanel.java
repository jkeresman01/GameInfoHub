package com.keresman.view;

import com.keresman.model.Developer;
import com.keresman.model.DeveloperTransferable;
import com.keresman.view.designer.FavouriteDevelopersPanelDesigner;
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

public class FavouriteDevelopersPanel extends FavouriteDevelopersPanelDesigner {
   
    private Set<Developer> allDevelopers = new TreeSet<>();
    private Set<Developer> favDevelopers = new TreeSet<>();
    private final DefaultListModel<Developer> allDevelopersModel = new DefaultListModel<>();
    private final DefaultListModel<Developer> favDevelopersModel = new DefaultListModel<>();

    public FavouriteDevelopersPanel() {
        super();
        init();
    }

    private void init() {
        initDragAndDrop();
        loadDeveloperss();
        loadAllModels();
    }

    private void initDragAndDrop() {
        initExportDnD();
        initImportDnd();

    }

    private void initExportDnD() {
        lsDevelopers.setDragEnabled(true);
        lsDevelopers.setTransferHandler(new AllDeveloperssExportHandler());

//        lsFavouriteDeveloperss.setDragEnabled(true);
//        lsFavouriteDeveloperss.setTransferHandler(new FavouriteDeveloperssExportHandler());
    }

    private void initImportDnd() {
//        lsDeveloperss.setDropMode(DropMode.ON);
//        lsDeveloperss.setTransferHandler(new AllDeveloperssImportHandler());

        lsFavouriteDevelopers.setDropMode(DropMode.ON);
        lsFavouriteDevelopers.setTransferHandler(new FavouriteDeveloperssImportHandler());
    }

    private void loadDeveloperss() {
        allDevelopers.add(new Developer(1, "First Developers", "AAA"));
        allDevelopers.add(new Developer(2, "Second Developers", "AAA"));
        allDevelopers.add(new Developer(3, "Third Developers", "AAAA"));
    }

    private abstract class AbstractExportTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return MOVE;
        }

        @Override
        protected abstract Transferable createTransferable(JComponent c);
    }

    private class AllDeveloperssExportHandler extends AbstractExportTransferHandler {

        private Developer exportedDevelopers;

        @Override
        protected Transferable createTransferable(JComponent c) {
            exportedDevelopers = lsDevelopers.getSelectedValue();
            return new DeveloperTransferable(exportedDevelopers);
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action == MOVE && exportedDevelopers != null) {
                allDevelopers.remove(exportedDevelopers);
                loadAllModels();
            }
        }
    }

    private class FavouriteDevelopersExportHandler extends AbstractExportTransferHandler {

        private Developer exportedDeveloper;

        @Override
        protected Transferable createTransferable(JComponent c) {
            exportedDeveloper = lsFavouriteDevelopers.getSelectedValue();
            return new DeveloperTransferable(exportedDeveloper);
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action == MOVE && exportedDeveloper != null) {
                favDevelopers.remove(exportedDeveloper);
                loadAllModels();
            }
        }
    }

    private abstract class AbstractImportTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(DeveloperTransferable.DEVELOPER_FLAVOUR);
        }

        @Override
        public abstract boolean importData(TransferHandler.TransferSupport support);
    }

    private class FavouriteDeveloperssImportHandler extends AbstractImportTransferHandler {

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            try {
                Developer Developers = (Developer) support.getTransferable().getTransferData(DeveloperTransferable.DEVELOPER_FLAVOUR);
                if (favDevelopers.add(Developers)) {
                    allDevelopers.remove(Developers);
                    loadFavDeveloperssModel();
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(FavouriteDevelopersPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    private class AllDeveloperssImportHandler extends AbstractImportTransferHandler {

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            try {
                Developer Developers = (Developer) support.getTransferable().getTransferData(DeveloperTransferable.DEVELOPER_FLAVOUR);
                if (allDevelopers.add(Developers)) {
                    favDevelopers.remove(Developers);
                    loadAllModels();
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(FavouriteDevelopersPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    private void loadAllModels() {
        loadAllDeveloperssModels();
        loadFavDeveloperssModel();
    }

    private void loadAllDeveloperssModels() {
        allDevelopersModel.clear();
        allDevelopers.forEach(allDevelopersModel::addElement);
        lsDevelopers.setModel(allDevelopersModel);
    }

    private void loadFavDeveloperssModel() {
        favDevelopersModel.clear();
        favDevelopers.forEach(favDevelopersModel::addElement);
        lsFavouriteDevelopers.setModel(favDevelopersModel);
    }

}
