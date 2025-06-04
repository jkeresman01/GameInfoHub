package com.keresman.view;

import com.keresman.view.designer.LoginPanel;
import com.keresman.view.designer.WelcomeScreenDesigner;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class WelcomeScreen extends WelcomeScreenDesigner {

  private static final String REGISTER = "Register";
  private static final String LOGIN = "Login";

  public WelcomeScreen() {
    super();
    init();
  }

  private void init() {
    initUI();
    initPanels();
  }

  private void initPanels() {
    tpLoginRegister.add(LOGIN, new LoginPanel());
    tpLoginRegister.add(REGISTER, new RegisterPanel());
  }

  private void initUI() {
    tpLoginRegister.setUI(
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
              boolean isSelected) {}
        });
  }
}
