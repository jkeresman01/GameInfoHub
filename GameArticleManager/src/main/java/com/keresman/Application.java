package com.keresman;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.keresman.model.Article;
import com.keresman.parser.rss.GameArticleParser;
import com.keresman.utilities.SwingUtils;
import com.keresman.view.WelcomeScreen;
import java.awt.EventQueue;
import java.util.List;

public class Application {

    public static void main(String args[]) throws Exception {
        SwingUtils.setLookAndFeel(new FlatMacDarkLaf());
        List<Article> parseResult = GameArticleParser.parse();
        parseResult.forEach(System.out::println);
        EventQueue.invokeLater(() -> new WelcomeScreen().setVisible(true));

    }
//        List<Article> results = GameArticleParser.parse();
//        results.stream()
//                .limit(10)
//                .forEach(System.out::println);
////        results.stream()
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
//                }
//                );
//    }
}
