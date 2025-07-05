package com.keresman.dal.sql;

import com.keresman.dal.FavoriteGamesRepository;
import com.keresman.mapper.GameRowMapper;
import com.keresman.mapper.RowMapper;
import com.keresman.model.Game;
import com.keresman.model.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SQLFavoriteGamesRepository implements FavoriteGamesRepository {

    private static final String USER_ID = "UserId";
    private static final String GAME_ID = "GameId";

    private static final String INSERT_FAVORITE_GAME = "{ CALL uspInsertFavoriteGame(?, ?) }";
    private static final String SELECT_BY_USER_ID = "{ CALL uspSelectFavoriteGamesByUserId(?) }";
    private static final String SELECT_BY_GAME_ID = "{ CALL uspSelectFavoriteGamesByGameId(?) }";
    private static final String SELECT_ALL = "{ CALL uspSelectAllFavoriteGames }";
    private static final String DELETE_ALL = "{ CALL uspDeleteAllFavoriteGames }";

    private final RowMapper<Game> gameRowMapper = new GameRowMapper();

    @Override
    public void save(Game game, User user) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(INSERT_FAVORITE_GAME)) {

            stmt.setInt(USER_ID, user.getId());
            stmt.setInt(GAME_ID, game.getGameId());

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Game> findByUserId(int id) throws Exception {
        List<Game> games = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_USER_ID)) {

            stmt.setInt(USER_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(gameRowMapper.map(rs));
                }
            }
        }
        return games;
    }

    @Override
    public List<Game> findByGameId(int id) throws Exception {
        List<Game> games = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_GAME_ID)) {

            stmt.setInt(GAME_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(gameRowMapper.map(rs));
                }
            }
        }
        return games;
    }

    @Override
    public List<Game> findAll() throws Exception {
        List<Game> games = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                games.add(gameRowMapper.map(rs));
            }
        }
        return games;
    }

    @Override
    public void deleteAll() throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL)) {

            stmt.executeUpdate();
        }
    }
}
