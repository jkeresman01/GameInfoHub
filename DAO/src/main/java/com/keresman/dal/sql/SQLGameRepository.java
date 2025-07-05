package com.keresman.dal.sql;

import com.keresman.dal.GameRepository;
import com.keresman.mapper.GameRowMapper;
import com.keresman.model.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SQLGameRepository implements GameRepository {

    private static final String GAME_ID = "GameId";
    private static final String NAME = "Name";
    private static final String RELEASE_DATE = "ReleaseDate";
    private static final String PLATFORM_ID = "PlatformId";
    private static final String GENRE_ID = "GenreId";

    private static final String CREATE = "{ CALL uspCreateGame (?, ?, ?) }";
    private static final String UPDATE = "{ CALL uspUpdateGameWithId (?, ?, ?) }";
    private static final String DELETE = "{ CALL uspDeleteGameWithId (?) }";
    private static final String SELECT_ALL = "{ CALL uspSelectAllGames }";
    private static final String SELECT_BY_ID = "{ CALL uspSelectGameWithId (?) }";
    private static final String SELECT_BY_PLATFORM = "{ CALL uspSelectGamesByPlatformId (?) }";
    private static final String SELECT_BY_GENRE = "{ CALL uspSelectGamesByGenreId (?) }";
    private static final String DELETE_ALL = "{ CALL uspDeleteAllGames }";

    private static final String ADD_GENRE = "{ CALL uspAddGenreToGame (?, ?) }";
    private static final String ADD_PLATFORM = "{ CALL uspAddPlatformToGame (?, ?) }";
    private static final String ADD_DEVELOPER = "{ CALL uspAddDeveloperToGame (?, ?) }";

    private static final String REMOVE_GENRES = "{ CALL uspRemoveGenresFromGame (?) }";
    private static final String REMOVE_PLATFORMS = "{ CALL uspRemovePlatformsFromGame (?) }";
    private static final String REMOVE_DEVELOPERS = "{ CALL uspRemoveDevelopersFromGame (?) }";

    private final GameRowMapper gameRowMapper = new GameRowMapper();

    @Override
    public int save(Game game) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(CREATE)) {

            stmt.setString(NAME, game.getName());
            stmt.setObject(RELEASE_DATE, game.getReleaseDate());
            stmt.registerOutParameter(GAME_ID, Types.INTEGER);
            stmt.executeUpdate();

            int gameId = stmt.getInt(GAME_ID);
            addLinks(con, game, gameId);
            return gameId;
        }
    }

    @Override
    public void updateById(int id, Game game) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(UPDATE)) {

            stmt.setInt(GAME_ID, id);
            stmt.setString(NAME, game.getName());
            stmt.setObject(RELEASE_DATE, game.getReleaseDate());
            stmt.executeUpdate();

            clearLinks(con, id);
            addLinks(con, game, id);
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(DELETE)) {
            stmt.setInt(GAME_ID, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Game> findById(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(SELECT_BY_ID)) {

            stmt.setInt(GAME_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(gameRowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Game> findAll() throws Exception {
        List<Game> games = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                games.add(gameRowMapper.map(rs));
            }
        }
        return games;
    }

    @Override
    public List<Game> findByPlatformId(int platformId) throws Exception {
        List<Game> games = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(SELECT_BY_PLATFORM)) {

            stmt.setInt(PLATFORM_ID, platformId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(gameRowMapper.map(rs));
                }
            }
        }
        return games;
    }

    @Override
    public List<Game> findByGenreId(int genreId) throws Exception {
        List<Game> games = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(SELECT_BY_GENRE)) {

            stmt.setInt(GENRE_ID, genreId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    games.add(gameRowMapper.map(rs));
                }
            }
        }
        return games;
    }

    @Override
    public void deleteAll() throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection();
             CallableStatement stmt = con.prepareCall(DELETE_ALL)) {
            stmt.executeUpdate();
        }
    }

    private void addLinks(Connection con, Game game, int gameId) throws Exception {
        try (CallableStatement stmt = con.prepareCall(ADD_GENRE)) {
            for (var genre : game.getGenres()) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, genre.getGenreId());
                stmt.executeUpdate();
            }
        }

        try (CallableStatement stmt = con.prepareCall(ADD_PLATFORM)) {
            for (var platform : game.getPlatforms()) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, platform.getPlatformId());
                stmt.executeUpdate();
            }
        }

        try (CallableStatement stmt = con.prepareCall(ADD_DEVELOPER)) {
            for (var developer : game.getDevelopers()) {
                stmt.setInt(1, gameId);
                stmt.setInt(2, developer.getDeveloperId());
                stmt.executeUpdate();
            }
        }
    }

    private void clearLinks(Connection con, int gameId) throws Exception {
        try (CallableStatement stmt = con.prepareCall(REMOVE_GENRES)) {
            stmt.setInt(1, gameId);
            stmt.executeUpdate();
        }
        try (CallableStatement stmt = con.prepareCall(REMOVE_PLATFORMS)) {
            stmt.setInt(1, gameId);
            stmt.executeUpdate();
        }
        try (CallableStatement stmt = con.prepareCall(REMOVE_DEVELOPERS)) {
            stmt.setInt(1, gameId);
            stmt.executeUpdate();
        }
    }
}
