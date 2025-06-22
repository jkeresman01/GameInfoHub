package com.keresman;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.keresman.utilities.SwingUtils;
import com.keresman.view.WelcomeScreen;
import java.awt.EventQueue;

public class Application {

    public static void main(String args[]) throws Exception {
        SwingUtils.setLookAndFeel(new FlatMacDarkLaf());
        EventQueue.invokeLater(() -> new WelcomeScreen().setVisible(true));
    }
}
