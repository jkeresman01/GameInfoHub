package com.keresman;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.keresman.utilities.SwingUtils;
import com.keresman.view.GameReviewsWelcomeScreen;
import java.awt.EventQueue;

public class Application {

    public static void main(String args[]) {
        SwingUtils.setLookAndFeel(new FlatMacDarkLaf());
        EventQueue.invokeLater(() -> new GameReviewsWelcomeScreen().setVisible(true));
    }
}
