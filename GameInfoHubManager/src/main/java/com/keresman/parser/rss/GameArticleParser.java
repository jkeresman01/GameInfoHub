package com.keresman.parser.rss;

import com.keresman.factory.ParserFactory;
import com.keresman.factory.URLConnectionFactory;
import com.keresman.model.Article;
import com.keresman.model.Category;
import com.keresman.model.Game;
import com.keresman.service.WikiDataService;
import com.keresman.utilities.FileUtils;
import com.keresman.utilities.GameUtils;
import com.keresman.utilities.HtmlUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class GameArticleParser {

  private static final String RSS_URL = "https://www.vg247.com/feed";
  private static final String ATTRIBUTE_URL = "url";
  private static final String EXT = ".jpg";
  private static final String DIR = "assets";

  private GameArticleParser() {}

  public static List<Article> parse() throws Exception {
    List<Article> reviews = new ArrayList<>();

    HttpURLConnection connection = URLConnectionFactory.getHttpUrlConnection(RSS_URL);

    try (InputStream is = connection.getInputStream()) {
      XMLEventReader xMLEventReader = ParserFactory.createStaxParser(is);

      Optional<TagType> tagType = Optional.empty();

      Article article = null;
      StartElement startElement = null;

      while (xMLEventReader.hasNext()) {
        XMLEvent xmlEvent = xMLEventReader.nextEvent();

        switch (xmlEvent.getEventType()) {
          case XMLStreamConstants.START_ELEMENT:
            startElement = xmlEvent.asStartElement();
            String qualifiedName = startElement.getName().getLocalPart();
            String prefix = startElement.getName().getPrefix();

            if ("media".equals(prefix) && "content".equals(qualifiedName)) {
              // this is <media:content>
              handleContent(article, startElement);
            } else {
              tagType = TagType.from(qualifiedName);

              if (tagType.isPresent() && tagType.get().equals(TagType.ITEM)) {
                article = new Article();
                reviews.add(article);
              }
            }
            break;
          case XMLStreamConstants.CHARACTERS:
            Characters characters = xmlEvent.asCharacters();
            String data = characters.getData().trim();

            if (tagType.isPresent() && article != null && !data.isEmpty()) {
              switch (tagType.get()) {
                case TITLE -> article.setTitle(data);
                case LINK -> article.setLink(data);
                case DESCRIPTION -> article.setDescription(HtmlUtils.stripHtml(data));
                case PUB_DATE -> article.setPublishedDateTime(
                    LocalDateTime.parse(data, DateTimeFormatter.RFC_1123_DATE_TIME));
                case CATEGORY -> handleCategory(article, data);
                case CONTENT -> handleContent(article, startElement);
              }
            }
            break;
        }
      }
    }

    return reviews;
  }

  private static void handleCategory(Article article, String data) {
    article.addCategory(new Category(data));

    Optional<String> extractGameName = GameUtils.extractGameName(data);

    if (extractGameName.isPresent()) {
      Optional<Game> enrichedGame = WikiDataService.enrichGameInfo(data);
      enrichedGame.ifPresent(article::addGame);
    }
  }

  private static void handleContent(Article article, StartElement startElement) {
    Attribute urlAttribute = startElement.getAttributeByName(new QName(ATTRIBUTE_URL));
    if (urlAttribute != null) {
      handlePicture(article, urlAttribute.getValue());
    }
  }

  private static void handlePicture(Article article, String pictureUrl) {
    try {
      String ext = pictureUrl.substring(pictureUrl.lastIndexOf("."));
      if (ext.length() > 4) {
        ext = EXT;
      }

      String pictureName = UUID.randomUUID() + ext;
      String localPicturePath = DIR + File.separator + pictureName;

      FileUtils.copyFromUrl(pictureUrl, localPicturePath);
      article.setPicturePath(localPicturePath);
    } catch (IOException ex) {
      Logger.getLogger(GameArticleParser.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private enum TagType {
    ITEM("item"),
    CONTENT("media:content"),
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
      return Arrays.stream(values()).filter(value -> value.name.equals(name)).findFirst();
    }
  }
}
