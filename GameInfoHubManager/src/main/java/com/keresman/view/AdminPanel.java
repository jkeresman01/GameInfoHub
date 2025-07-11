package com.keresman.view;

import com.keresman.components.CustomBasicTabbedPaneUI;
import com.keresman.view.designer.AdminPanelDesigner;

public class AdminPanel extends AdminPanelDesigner {

  private static final String MANAGE_USERS = "Manage Users";
  private static final String MANAGE_GAME_ARTICLERS = "Manage Game Articles";
  private static final String BROWSE_REPORTS = "Browse reports";

  public AdminPanel() {
    super();
    init();
  }

  private void init() {
    initUI();
    initPanels();
  }

  private void initUI() {
    tpAdmin.setUI(new CustomBasicTabbedPaneUI());
  }

  private void initPanels() {
    tpAdmin.add(MANAGE_USERS, new ManageUsersPanel());
    tpAdmin.add(MANAGE_GAME_ARTICLERS, new ManageGameArticlesPanel());
    tpAdmin.add(BROWSE_REPORTS, new BrowseReportsPanel());
  }
}
