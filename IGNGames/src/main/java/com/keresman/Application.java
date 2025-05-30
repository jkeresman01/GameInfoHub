package com.keresman;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.keresman.view.welcome.IGNGamesWelcome;
import java.awt.EventQueue;
import javax.swing.UIManager;

public class Application {
     public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(IGNGamesWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> new IGNGamesWelcome().setVisible(true));
    }

}
