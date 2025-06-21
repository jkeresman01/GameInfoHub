package com.keresman.service;

import com.keresman.dal.GameRepository;
import com.keresman.model.Game;
import com.keresman.validator.Result;
import java.util.List;

public class GameService {

    private final GameRepository gameRepository;
    
    public GameService(GameRepository gameRepostitory) {
        this.gameRepository = gameRepostitory;
    }

    public Result<List<Game>> getAllGames() {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
