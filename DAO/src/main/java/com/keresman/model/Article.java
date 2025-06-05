package com.keresman.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Article {

    private int articleId;
    private String title;
    private String link;
    private String description;
    private LocalDateTime publishedDateTime;
    private List<Category> categories = new ArrayList<>();
    private List<Game> games = new ArrayList<>();
    private String picturePath;

    public Article() {
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
        return "Article{" + "title=" + title + ", games=" + games + '}';
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

}
