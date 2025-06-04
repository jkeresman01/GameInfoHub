package com.keresman.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Article {

    private int reviewId;
    private String title;
    private String link;
    private String description;
    private LocalDateTime pubDate;
    private String creator;
    private List<Category> categories = new ArrayList<>();
    private List<Game> games = new ArrayList<>();
    private String imageUrl;

    public Article() {
    }

    public Article(String title, String link, String description, LocalDateTime pubDate, String creator, String imageUrl) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.creator = creator;
        this.imageUrl = imageUrl;
    }

    public Article(int reviewId, String title, String link, String description, LocalDateTime pubDate, String creator, String imageUrl) {
        this.reviewId = reviewId;
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.creator = creator;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Review{" + "reviewId=" + reviewId + ", title=" + title + ", link=" + link + ", description=" + description + ", pubDate=" + pubDate + ", creator=" + creator + ", categories=" + categories + ", imageUrl=" + imageUrl + '}';
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
    
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }
    
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
