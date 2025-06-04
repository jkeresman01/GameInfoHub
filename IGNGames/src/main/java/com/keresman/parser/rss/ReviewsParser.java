package com.keresman.parser.rss;

import com.keresman.factory.ParserFactory;
import com.keresman.factory.URLConnectionFactory;
import com.keresman.model.Article;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class ReviewsParser {

//    private static final String RSS_URL = "https://www.gameinformer.com/reviews.xml";
//    private static final String RSS_URL = "https://www.pcgamesn.com/mainrss.xml";
    private static final String RSS_URL = "https://www.vg247.com/feed";
    private static final String ATTRIBUTE_URL = "url";
    private static final String EXT = ".jpg";
    private static final String DIR = "assets";

    private ReviewsParser() {
    }

    public static List<Article> parse() throws Exception {
        List<Article> reviews = new ArrayList<>();

        HttpURLConnection connection = URLConnectionFactory.getHttpUrlConnection(RSS_URL);

        try (InputStream is = connection.getInputStream()) {
            XMLEventReader xMLEventReader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();

            Article review = null;
            StartElement startElement = null;

            while (xMLEventReader.hasNext()) {
                XMLEvent xmlEvent = xMLEventReader.nextEvent();

                switch (xmlEvent.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        startElement = xmlEvent.asStartElement();
                        String qualifiedName = startElement.getName().getLocalPart();
                        tagType = TagType.from(qualifiedName);

                        if (tagType.isPresent() && tagType.get().equals(TagType.ITEM)) {
                            review = new Article();
                            reviews.add(review);
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = xmlEvent.asCharacters();
                        String data = characters.getData().trim();

                        if (tagType.isPresent() && review != null && !data.isEmpty()) {
                            switch (tagType.get()) {
                                case TITLE -> review.setTitle(data);
                                case LINK -> review.setLink(data);
                                case DESCRIPTION -> review.setDescription(data);
                                case PUB_DATE -> review.setPubDate(data);
                                case CREATOR -> review.setCreator(data);
                                case CATEGORY -> review.getCategories().add(data);
                            }
                        }
                        break;
                }

            }
        }

        return reviews;
    }

    private enum TagType {
        ITEM("item"),
        CONTENT("content"),
        TITLE("title"),
        LINK("link"),
        DESCRIPTION("description"),
        ENCLOSURE("enclosure"),
        PUB_DATE("pubDate"),
        CATEGORY("category"),
        CREATOR("creator");

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
