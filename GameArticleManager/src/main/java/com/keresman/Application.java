package com.keresman;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.keresman.utilities.SwingUtils;
import com.keresman.view.WelcomeScreen;
import java.awt.EventQueue;

public class Application {

    public static void main(String args[]) throws Exception {
        SwingUtils.setLookAndFeel(new FlatMacDarkLaf());
        EventQueue.invokeLater(()-> new WelcomeScreen().setVisible(true));
    }
//        List<Article> results = ArticleParser.parse();
//        results.stream()
//                .limit(10)
//                .forEach(System.out::println);
//    }
//
//        results.stream()
//                .map(review -> review.getCategories())
//                .distinct()
//                .forEach(System.out::println);
//        
//        results.stream()
//                .forEach(review -> {
//
//                    List<String> categories = review.getCategories()
//                            .stream()
//                            .map(Category::getName)
//                            .toList();
//
//                    List<String> extractGameName = GameUtils.extractGameNames(categories);
//                    extractGameName.forEach(System.out::println);
//                });
//    }
}
