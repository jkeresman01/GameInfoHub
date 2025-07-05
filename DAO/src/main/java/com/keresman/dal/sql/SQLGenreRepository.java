package com.keresman.dal.sql;

import com.keresman.dal.GenreRepository;
import com.keresman.mapper.GenreRowMapper;
import com.keresman.model.Genre;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLGenreRepository implements GenreRepository {

    private static final String GENRE_ID = "GenreId";
    private static final String NAME = "Name";

    private static final String CREATE_GENRE = "{ CALL uspCreateGenre (?, ?) }";
    private static final String UPDATE_GENRE = "{ CALL uspUpdateGenreWithId (?, ?) }";
    private static final String SELECT_GENRE_BY_ID = "{ CALL uspSelectGenreWithId (?) }";
    private static final String SELECT_ALL_GENRES = "{ CALL uspSelectAllGenres }";
    private static final String DELETE_ALL_GENRES = "{ CALL uspDeleteAllGenres }";

    private final GenreRowMapper genreRowMapper = new GenreRowMapper();

    @Override
    public int save(Genre genre) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_GENRE)) {
            stmt.setString(NAME, genre.getName());
            stmt.registerOutParameter(GENRE_ID, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(GENRE_ID);
        }
    }

    @Override
    public void updateById(int id, Genre genre) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_GENRE)) {
            stmt.setInt(GENRE_ID, id);
            stmt.setString(NAME, genre.getName());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Genre> findById(int id) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_GENRE_BY_ID)) {
            stmt.setInt(GENRE_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(genreRowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Genre> findAll() throws Exception {
        List<Genre> genres = new ArrayList<>();
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_GENRES); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                genres.add(genreRowMapper.map(rs));
            }
        }
        return genres;
    }

    @Override
    public void deleteAll() throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_GENRES)) {
            stmt.executeUpdate();
        }
    }
}
