package com.keresman.components;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class CustomBasicTabbedPaneUI extends BasicTabbedPaneUI {

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
}
