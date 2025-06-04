package com.keresman.parser.rss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReviewsParser {

    public class Article {

    }

    private static final String RSS_URL = "https://slobodnadalmacija.hr/feed";
    private static final String ATTRIBUTE_URL = "url";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    private ReviewsParser() {
    }

    public static List<Article> parse() {
        List<Article> articles = new ArrayList<>();
        
        
        
        return articles;
    }

    private enum TagType {
        ITEM("item"),
        TITLE("title"),
        LINK("link"),
        DESCRIPTION("description"),
        ENCLOSURE("enclosure"),
        PUB_DATE("pubDate");

        private final String name;

        private TagType(String name) {
            this.name = name;
        }
        
        private static Optional<TagType> from(String name) {
            return Arrays.stream(values())
                    .filter(value -> value.name.equals(name))
                    .findFirst();
        }
    }
}
