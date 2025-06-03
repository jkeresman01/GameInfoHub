package com.keresman;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.keresman.view.IGNGamesWelcome;
import com.keresman.view.designer.IGNGamesWelcomeDesigner;
import java.awt.EventQueue;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Application {

  public static void main(String args[]) {
    setLookAndFeel();
    EventQueue.invokeLater(() -> new IGNGamesWelcome().setVisible(true));
  }

  private static void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel(new FlatMacDarkLaf());
    } catch (Exception ex) {
      Logger.getLogger(IGNGamesWelcomeDesigner.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
  }
}
