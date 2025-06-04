package com.keresman.parser.rss;

import com.keresman.factory.ParserFactory;
import com.keresman.factory.URLConnectionFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.events.XMLEvent;

public class ReviewsParser {

    public class Article {

    }

    private static final String RSS_URL = "https://slobodnadalmacija.hr/feed";
    private static final String ATTRIBUTE_URL = "url";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    private ReviewsParser() {
    }

    public static List<Article> parse() throws Exception {
        List<Article> articles = new ArrayList<>();

        HttpURLConnection connection = URLConnectionFactory.getHttpUrlConnection(RSS_URL);

        try(InputStream is = connection.getInputStream()){
            XMLEventReader xMLEventReader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            
            while (xMLEventReader.hasNext()) {
                XMLEvent xmlEvent = xMLEventReader.nextEvent();
                
                
                
            }
        }
        
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
