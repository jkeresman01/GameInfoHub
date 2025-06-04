package com.keresman;

import com.keresman.model.Article;
import com.keresman.parser.rss.ReviewsParser;
import com.keresman.utilities.GameUtils;
import java.util.List;

public class Application {

    public static void main(String args[]) throws Exception {
        List<Article> results = ReviewsParser.parse();

//        results.stream()
//                .map(review -> review.getCategories())
//                .distinct()
//                .forEach(System.out::println);
        results.stream()
                .forEach(review -> {
                    List<String> extractGameName = GameUtils.extractGameNames(review.getCategories());
                    extractGameName.forEach(System.out::println);
                });
    }
}
