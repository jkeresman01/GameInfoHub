package com.keresman.mapper;

import com.keresman.model.Developer;
import com.keresman.model.Game;
import com.keresman.model.Genre;
import com.keresman.model.Platform;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameRowMapper implements RowMapper<Game> {

    @Override
    public Game map(ResultSet rs) throws SQLException {
        Game game = new Game();
        game.setGameId(rs.getInt("Id"));
        game.setName(rs.getString("Name"));

        java.sql.Date sqlDate = rs.getDate("ReleaseDate");
        if (sqlDate != null) {
            game.setReleaseDate(sqlDate.toLocalDate());
        }

        String genresStr = rs.getString("Genres");
        if (genresStr != null && !genresStr.isBlank()) {
            List<Genre> genres = Arrays.stream(genresStr.split(","))
                    .map(String::trim)
                    .map(name -> new Genre(0, name))
                    .collect(Collectors.toList());
            genres.forEach(game::addGenre);
        }

        String platformsStr = rs.getString("Platforms");
        if (platformsStr != null && !platformsStr.isBlank()) {
            List<Platform> platforms = Arrays.stream(platformsStr.split(","))
                    .map(String::trim)
                    .map(name -> new Platform(0, name))
                    .collect(Collectors.toList());
            platforms.forEach(game::addPlatform);
        }

        String developersStr = rs.getString("Developers");
        if (developersStr != null && !developersStr.isBlank()) {
            List<Developer> developers = Arrays.stream(developersStr.split(","))
                    .map(String::trim)
                    .map(name -> new Developer(0, name))
                    .collect(Collectors.toList());
            developers.forEach(game::addDeveloper);
        }

        return game;
    }
}
