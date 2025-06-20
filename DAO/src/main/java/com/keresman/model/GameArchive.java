package com.keresman.model;

import java.util.ArrayList;
import java.util.List;

public final class GameArchive {
    
    private List<Game> games;

    public GameArchive() {
    }
    
    public GameArchive(List<Game> games) {
    }

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
