package com.keresman.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game implements Comparable<Game> {

    private int gameId;
    private String name;

    private LocalDate releaseDate;
    private List<Genre> genres = new ArrayList<>();
    private List<Developer> developers = new ArrayList<>();
    private List<Platform> platforms = new ArrayList<>();

    public Game() {
    }

    public Game(int gameId, String name) {
        this.gameId = gameId;
        this.name = name;
    }

    public Game(String name) {
        this.name = name;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void addPlatform(Platform platform) {
        this.platforms.add(platform);
    }

    @Override
    public int compareTo(Game o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return "Game{"
                + "name='" + name + '\''
                + ", releaseDate=" + releaseDate
                + ", genres=" + genres
                + ", developers=" + developers
                + ", platforms=" + platforms
                + '}';
    }
}
