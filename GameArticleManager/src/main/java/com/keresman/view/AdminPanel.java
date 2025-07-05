package com.keresman.view;

import com.keresman.view.designer.AdminManagerDesigner;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class AdminPanel extends AdminManagerDesigner {

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

    private void initPanels() {
        tpAdmin.add(MANAGE_USERS, new ManageUsersPanel());
        tpAdmin.add(MANAGE_GAME_ARTICLERS, new UploadGameArticlesPanel());
        tpAdmin.add(BROWSE_REPORTS, new BrowseReportsPanel());
    }

    private void initUI() {
        tpAdmin.setUI(
                new BasicTabbedPaneUI() {
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
