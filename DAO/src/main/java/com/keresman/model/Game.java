package com.keresman.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
public final class Game implements Comparable<Game> {

    @XmlElement(name = "gameId")
    private int gameId;

    @XmlElement(name = "name")
    private String name;

    private LocalDate releaseDate;

    @XmlElementWrapper
    @XmlElement(name = "category")
    private List<Genre> genres = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name = "category")
    private List<Developer> developers = new ArrayList<>();

    @XmlElementWrapper
    @XmlElement(name = "category")
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        return Objects.equals(this.name, other.name);
    }
}
