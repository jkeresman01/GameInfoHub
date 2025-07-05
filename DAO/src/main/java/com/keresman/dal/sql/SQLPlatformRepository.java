package com.keresman.dal.sql;

import com.keresman.dal.PlatformRepository;
import com.keresman.mapper.PlatformRowMapper;
import com.keresman.mapper.RowMapper;
import com.keresman.model.Platform;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLPlatformRepository implements PlatformRepository {

    private static final String PLATFORM_ID = "PlatformId";
    private static final String NAME = "Name";

    private static final String CREATE_PLATFORM = "{ CALL uspCreatePlatform (?, ?) }";
    private static final String UPDATE_PLATFORM = "{ CALL uspUpdatePlatformWithId (?, ?) }";
    private static final String SELECT_PLATFORM_BY_ID = "{ CALL uspSelectPlatformWithId (?) }";
    private static final String SELECT_ALL_PLATFORMS = "{ CALL uspSelectAllPlatforms }";
    private static final String DELETE_ALL_PLATFORMS = "{ CALL uspDeleteAllPlatforms }";

    private final RowMapper<Platform> platformRowMapper = new PlatformRowMapper();

    @Override
    public int save(Platform platform) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_PLATFORM)) {
            stmt.setString(NAME, platform.getName());
            stmt.registerOutParameter(PLATFORM_ID, Types.INTEGER);
            stmt.executeUpdate();
            return stmt.getInt(PLATFORM_ID);
        }
    }

    @Override
    public void updateById(int id, Platform platform) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_PLATFORM)) {
            stmt.setInt(PLATFORM_ID, id);
            stmt.setString(NAME, platform.getName());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Platform> findById(int id) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_PLATFORM_BY_ID)) {
            stmt.setInt(PLATFORM_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(platformRowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Platform> findAll() throws Exception {
        List<Platform> platforms = new ArrayList<>();
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_PLATFORMS); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                platforms.add(platformRowMapper.map(rs));
            }
        }
        return platforms;
    }

    @Override
    public void deleteAll() throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_PLATFORMS)) {
            stmt.executeUpdate();
        }
    }
}
