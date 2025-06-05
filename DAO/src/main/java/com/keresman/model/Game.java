package com.keresman.model;

public class Game {

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
        return "Game{" + "gameId=" + gameId + ", name=" + name + '}';
    }
}
