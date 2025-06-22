package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Article;
import com.keresman.model.ArticleTransferable;
import com.keresman.view.designer.FavouriteArticlesPanelDesigner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ComponentEvent;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.MOVE;

public class FavouriteArticlesPanel extends FavouriteArticlesPanelDesigner {

    private Set<Article> allArticles = new TreeSet<>();
    private Set<Article> favArticles = new TreeSet<>();
    private ArticleRepository articleRepository;
    private final DefaultListModel<Article> allArticlesModel = new DefaultListModel<>();
    private final DefaultListModel<Article> favArticlesModel = new DefaultListModel<>();

    public FavouriteArticlesPanel() throws Exception {
        super();
        init();
    }

    private void init() throws Exception {
        initDragAndDrop();
        initRepository();
        loadArticless();
        loadAllModels();
    }

    private void initDragAndDrop() {
        initExportDnD();
        initImportDnd();

    }

    private void initExportDnD() {
        lsArticles.setDragEnabled(true);
        lsArticles.setTransferHandler(new AllArticlessExportHandler());

//        lsFavouriteArticless.setDragEnabled(true);
//        lsFavouriteArticless.setTransferHandler(new FavouriteArticlessExportHandler());
    }

    private void initImportDnd() {
//        lsArticless.setDropMode(DropMode.ON);
//        lsArticless.setTransferHandler(new AllArticlessImportHandler());

        lsFavouriteArticles.setDropMode(DropMode.ON);
        lsFavouriteArticles.setTransferHandler(new FavouriteArticlessImportHandler());
    }

    private void initRepository() throws Exception {
        articleRepository = RepositoryFactory.getInstance(ArticleRepository.class);
    }

    private void loadArticless() throws Exception {
        allArticles = new TreeSet<>(articleRepository.findAll());
    }

    @Override
    public void formComponentShown(ComponentEvent evt) {
        try {
            loadArticless();
            loadAllModels();
        } catch (Exception ex) {
            Logger.getLogger(FavouriteArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private abstract class AbstractExportTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return MOVE;
        }

        @Override
        protected abstract Transferable createTransferable(JComponent c);
    }

    private class AllArticlessExportHandler extends AbstractExportTransferHandler {

        private Article exportedArticles;

        @Override
        protected Transferable createTransferable(JComponent c) {
            exportedArticles = lsArticles.getSelectedValue();
            return new ArticleTransferable(exportedArticles);
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action == MOVE && exportedArticles != null) {
                allArticles.remove(exportedArticles);
                loadAllModels();
            }
        }
    }

    private class FavouriteArticlesExportHandler extends AbstractExportTransferHandler {

        private Article exportedArticle;

        @Override
        protected Transferable createTransferable(JComponent c) {
            exportedArticle = lsFavouriteArticles.getSelectedValue();
            return new ArticleTransferable(exportedArticle);
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action == MOVE && exportedArticle != null) {
                favArticles.remove(exportedArticle);
                loadAllModels();
            }
        }
    }

    private abstract class AbstractImportTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(ArticleTransferable.ARTICLE_FLAVOUR);
        }

        @Override
        public abstract boolean importData(TransferHandler.TransferSupport support);
    }

    private class FavouriteArticlessImportHandler extends AbstractImportTransferHandler {

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            try {
                Article Articles = (Article) support.getTransferable().getTransferData(ArticleTransferable.ARTICLE_FLAVOUR);
                if (favArticles.add(Articles)) {
                    allArticles.remove(Articles);
                    loadFavArticlessModel();
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(FavouriteArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    private class AllArticlessImportHandler extends AbstractImportTransferHandler {

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            try {
                Article Articles = (Article) support.getTransferable().getTransferData(ArticleTransferable.ARTICLE_FLAVOUR);
                if (allArticles.add(Articles)) {
                    favArticles.remove(Articles);
                    loadAllModels();
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(FavouriteArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    private void loadAllModels() {
        loadAllArticlessModels();
        loadFavArticlessModel();
    }

    private void loadAllArticlessModels() {
        allArticlesModel.clear();
        allArticles.forEach(allArticlesModel::addElement);
        lsArticles.setModel(allArticlesModel);
    }

    private void loadFavArticlessModel() {
        favArticlesModel.clear();
        favArticles.forEach(favArticlesModel::addElement);
        lsFavouriteArticles.setModel(favArticlesModel);
    }
}
