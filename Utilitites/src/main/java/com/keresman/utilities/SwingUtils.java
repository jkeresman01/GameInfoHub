package com.keresman.utilities;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class SwingUtils {

  private SwingUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static void setLookAndFeel(LookAndFeel lookAndFeel) {
    try {
      UIManager.setLookAndFeel(lookAndFeel);
    } catch (Exception ex) {
      throw new RuntimeException(
          "Failed to set look and feel to: %s".formatted(lookAndFeel.getClass()));
    }
  }
}
