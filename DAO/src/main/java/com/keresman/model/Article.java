package com.keresman.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "articles")
@XmlAccessorType(XmlAccessType.FIELD)
public final class Article implements Comparable<Article> {

    public static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @XmlElement(name = "articleid")
    private int articleId;

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "publisheddatetime")
    @XmlJavaTypeAdapter(ArticlePublishedDateAdapter.class)
    private LocalDateTime publishedDateTime;

    @XmlElementWrapper
    @XmlElement(name = "category")
    private List<Category> categories = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name = "game")
    private List<Game> games = new ArrayList<>();

    @XmlElement(name = "picturePath")
    private String picturePath;

    public Article() {
    }

    public Article(int articleId, String title) {
        this.articleId = articleId;
        this.title = title;
    }

    public Article(
            String title,
            String link,
            String description,
            LocalDateTime publishedDateTime,
            String picturePath
    ) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.publishedDateTime = publishedDateTime;
        this.picturePath = picturePath;
    }

    public Article(
            int articleId,
            String title,
            String link,
            String description,
            LocalDateTime publishedDateTime,
            String picturePath
    ) {
        this.articleId = articleId;
        this.title = title;
        this.link = link;
        this.description = description;
        this.publishedDateTime = publishedDateTime;
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        String shortTitle = title != null && title.length() > 60
                ? title.substring(0, 60) + "..."
                : title;
        
        return "Article: " + shortTitle;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPublishedDateTime() {
        return publishedDateTime;
    }

    public void setPublishedDateTime(LocalDateTime publishedDateTime) {
        this.publishedDateTime = publishedDateTime;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public int compareTo(Article o) {
        return Integer.compare(articleId, o.articleId);
    }

}
