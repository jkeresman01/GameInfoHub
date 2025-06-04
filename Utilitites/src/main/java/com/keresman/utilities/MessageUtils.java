package com.keresman.utilities;

import javax.swing.JOptionPane;

public class MessageUtils {

  private MessageUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static void showInformationMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showWarningMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
  }

  public static void showErrorMessage(String title, String message) {
    JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
  }

  public static boolean showConfirmDialog(String title, String message) {
    return JOptionPane.showConfirmDialog(
            null, message, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE)
        == JOptionPane.OK_OPTION;
  }
}
