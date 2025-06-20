package com.keresman.model;

public class Game implements Comparable<Game>{

    private int gameId;
    private String name;

    public Game() {
    }

    public Game(int gameId, String name) {
        this.gameId = gameId;
        this.name = name;
    }
    
    public Game(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "ID: " + gameId + ", " + name;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.gameId;
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
        return this.gameId == other.gameId;
    }

    @Override
    public int compareTo(Game o) {
       return name.compareTo(o.getName());
    }
}
