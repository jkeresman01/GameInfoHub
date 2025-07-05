package com.keresman.dal.sql;

import com.keresman.dal.DeveloperRepository;
import com.keresman.model.Developer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLDeveloperRepository implements DeveloperRepository {

    private static final String ID = "Id";
    private static final String NAME = "Name";

    private static final String CREATE_DEVELOPER = "{ CALL uspCreateDeveloper (?, ?) }";
    private static final String UPDATE_DEVELOPER = "{ CALL uspUpdateDeveloperWithId (?, ?) }";
    private static final String SELECT_DEVELOPER_BY_ID = "{ CALL uspSelectDeveloperWithId (?) }";
    private static final String SELECT_ALL_DEVELOPERS = "{ CALL uspSelectAllDevelopers }";
    private static final String DELETE_ALL_DEVELOPERS = "{ CALL uspDeleteAllDevelopers }";

    @Override
    public int save(Developer developer) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_DEVELOPER)) {

            stmt.setString(1, developer.getName());
            stmt.registerOutParameter(2, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(2);
        }
    }

    @Override
    public void updateById(int id, Developer developer) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_DEVELOPER)) {

            stmt.setInt(1, id);
            stmt.setString(2, developer.getName());

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Developer> findById(int id) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_DEVELOPER_BY_ID)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Developer dev = new Developer(rs.getInt(ID), rs.getString(NAME));
                    return Optional.of(dev);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Developer> findAll() throws Exception {
        List<Developer> developers = new ArrayList<>();
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_DEVELOPERS); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                developers.add(new Developer(rs.getInt(ID), rs.getString(NAME)));
            }
        }
        return developers;
    }

    @Override
    public void deleteAll() throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_DEVELOPERS)) {

            stmt.executeUpdate();
        }
    }
}
