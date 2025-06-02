package com.keresman.dao;

import com.keresman.model.Game;
import com.keresman.model.Platform;
import java.util.List;

public interface GamePlatformRepository {

    void save(int gameId, int platformId) throws Exception;

    void delete(int gameId, int platformId) throws Exception;

    List<Platform> findPlatformsByGameId(int gameId) throws Exception;

    List<Game> findGamesByPlatformId(int platformId) throws Exception;
}
