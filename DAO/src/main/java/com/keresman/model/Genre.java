package com.keresman.model;

public final class Genre implements Comparable<Genre> {

    private int genreId;
    private String name;

    public Genre() {
    }

    public Genre(int genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public Genre(String name) {
        this.name = name;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Genre o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
