package com.keresman.view;

import com.keresman.components.CustomBasicTabbedPaneUI;
import com.keresman.view.designer.WelcomeScreenDesigner;

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

  private void initUI() {
    tpLoginRegister.setUI(new CustomBasicTabbedPaneUI());
  }

  private void initPanels() {
    tpLoginRegister.add(LOGIN, new LoginPanel());
    tpLoginRegister.add(REGISTER, new RegisterPanel());
  }
}
