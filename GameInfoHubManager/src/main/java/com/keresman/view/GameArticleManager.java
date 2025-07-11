package com.keresman.view;

import com.keresman.dal.ArticleRepository;
import com.keresman.dal.CommentRepository;
import com.keresman.dal.ReportRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.dal.UserRepository;
import com.keresman.model.Article;
import com.keresman.model.ArticleArchive;
import com.keresman.model.Comment;
import com.keresman.model.CommentAddable;
import com.keresman.model.Game;
import com.keresman.model.Report;
import com.keresman.model.Reportable;
import com.keresman.model.User;
import com.keresman.model.UserArchive;
import com.keresman.service.ArticleService;
import com.keresman.service.CommentService;
import com.keresman.service.ReportService;
import com.keresman.service.UserService;
import com.keresman.session.SessionManager;
import com.keresman.utilities.JAXBUtils;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import com.keresman.view.designer.GameArticleManagerDesigner;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.xml.bind.JAXBException;

public class GameArticleManager extends GameArticleManagerDesigner
    implements CommentAddable, Reportable {

  private static final String ARCHIVE_BASE_PATH =
      "src"
          + File.separator
          + "main"
          + File.separator
          + "resources"
          + File.separator
          + "assets"
          + File.separator
          + "archives";
  private static final String USER_ARCHIVE_FILENAME =
      ARCHIVE_BASE_PATH + File.separator + "userarchive.xml";
  private static final String ARTICLES_ARCHIVE_FILENAME =
      ARCHIVE_BASE_PATH + File.separator + "articlesarchive.xml";

  private static final String PROFILE = "Profile";
  private static final String FAVOURITES = "Favourites";
  private static final String GAMES = "Games";
  private static final String ARTICLES = "Articles";
  private static final String ADMIN = "Admin";

  private UserService userService;
  private ArticleService articleService;
  private CommentService commentService;
  private ReportService reportService;

  public GameArticleManager() {
    super();
    init();
  }

  private void init() {
    try {
      initPanels();
      initServices();
      handleLookAndFeel();
    } catch (Exception ex) {
      handleInitializationError(ex);
    }
  }

  private void initPanels() throws Exception {
    if (SessionManager.getInstance().getCurrentUser().isAdmin()) {
      tpMain.add(ADMIN, new AdminPanel());
    }

    tpMain.add(GAMES, new GamesPanel());
    tpMain.add(ARTICLES, new ArticlesPanel());
    tpMain.add(FAVOURITES, new FavouritesPanel());
    tpMain.add(PROFILE, new ProfilePanel());
  }

  private void initServices() throws Exception {
    initUserService();
    initReportService();
    initArticleService();
    initCommentService();
  }

  private void initReportService() throws Exception {
    reportService = new ReportService(RepositoryFactory.getInstance(ReportRepository.class));
  }

  private void initArticleService() throws Exception {
    articleService = new ArticleService(RepositoryFactory.getInstance(ArticleRepository.class));
  }

  private void initCommentService() throws Exception {
    commentService = new CommentService(RepositoryFactory.getInstance(CommentRepository.class));
  }

  private void initUserService() throws Exception {
    userService = new UserService(RepositoryFactory.getInstance(UserRepository.class));
  }

  private void handleInitializationError(Exception ex) {
    Logger.getLogger(GameArticleManager.class.getName()).log(Level.SEVERE, null, ex);
    MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
    System.exit(1);
  }

  @Override
  public void miLogoutMouseClicked(MouseEvent evt) {
    SessionManager.getInstance().clear();
    dispose();
    SwingUtilities.invokeLater(() -> new WelcomeScreen().setVisible(true));
  }

  private void handleLookAndFeel() {
    ButtonGroup bgLookFeel = new ButtonGroup();
    Arrays.stream(UIManager.getInstalledLookAndFeels())
        .forEach(lf -> addLookAndFeelOption(bgLookFeel, lf));
  }

  private void addLookAndFeelOption(ButtonGroup group, UIManager.LookAndFeelInfo lf) {
    JRadioButtonMenuItem menuItem = createLookAndFeelMenuItem(lf);
    group.add(menuItem);
    mLookAndFeel.add(menuItem);
  }

  private JRadioButtonMenuItem createLookAndFeelMenuItem(UIManager.LookAndFeelInfo lf) {
    JRadioButtonMenuItem mi = new JRadioButtonMenuItem(lf.getName());

    if ("Nimbus".equals(lf.getName())) {
      mi.setSelected(true);
    }

    mi.addActionListener(e -> applyLookAndFeel(lf.getClassName()));
    return mi;
  }

  private void applyLookAndFeel(String className) {
    try {
      UIManager.setLookAndFeel(className);
      SwingUtilities.updateComponentTreeUI(this);
    } catch (Exception ex) {
      Logger.getLogger(GameArticleManager.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public void mUserArchiveMouseClicked(MouseEvent evt) {
    new Thread(this::exportUserArchive).start();
  }

  private void exportUserArchive() {
    Result<List<User>> getAllUsersResult = userService.getAllUsers();

    if (!getAllUsersResult.isSuccess()) {
      notifyError("Failed to export user archive");
      return;
    }

    try {
      JAXBUtils.save(new UserArchive(getAllUsersResult.getData().get()), USER_ARCHIVE_FILENAME);
      notifySuccess("User archive successfully exported!");
    } catch (JAXBException ex) {
      notifyError("Failed to export user archive:\n%s".formatted(ex.getMessage()));
    }
  }

  @Override
  public void miArticleArchiveMouseClicked(MouseEvent evt) {
    new Thread(this::exportArticleArchive).start();
  }

  private void exportArticleArchive() {
    Result<List<Article>> result = articleService.getAllArticles();

    if (!result.isSuccess()) {
      notifyError("Failed to export article archive");
      return;
    }

    try {
      saveArticleArchive(result.getData().get());
      notifySuccess("Article archive successfully exported!");
    } catch (JAXBException ex) {
      notifyError("Failed to export article archive:\n%s".formatted(ex.getMessage()));
    }
  }

  private void saveArticleArchive(List<Article> articles) throws JAXBException {
    JAXBUtils.save(new ArticleArchive(articles), ARTICLES_ARCHIVE_FILENAME);
  }

  private void notifySuccess(String message) {
    SwingUtilities.invokeLater(() -> MessageUtils.showInformationMessage("INFO", message));
  }

  private void notifyError(String message) {
    SwingUtilities.invokeLater(() -> MessageUtils.showErrorMessage("ERROR", message));
  }

  @Override
  public void mHelpMouseClicked(MouseEvent evt) {
    MessageUtils.showInformationMessage(
        "HELP", "For any assitance you can contact us on: +385 099 00000000");
  }

  @Override
  public void miAboutMouseClicked(MouseEvent evt) {
    MessageUtils.showInformationMessage(
        "About This Application",
        "This desktop application was developed using Java Swing as part of the Java Programming 1 course at Algebra Bernays University.");
  }

  @Override
  public void addComment(Comment comment, Game game) {
    int gameId = game.getGameId();
    int userId = SessionManager.getInstance().getCurrentUser().getId();
    commentService.createComment(comment, userId, gameId);
  }

  @Override
  public void report(Report report, Article article) {
    int articleId = article.getArticleId();
    int userId = SessionManager.getInstance().getCurrentUser().getId();
    reportService.createReport(report, userId, articleId);
  }
}
