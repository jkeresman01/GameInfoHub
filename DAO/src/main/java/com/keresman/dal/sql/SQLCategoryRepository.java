package com.keresman.dal.sql;

import com.keresman.dal.CategoryRepostitory;
import com.keresman.mapper.CategoryRowMapper;
import com.keresman.mapper.RowMapper;
import com.keresman.model.Category;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SQLCategoryRepository implements CategoryRepostitory {

    private static final String CATEGORY_ID = "CategoryId";
    private static final String NAME = "Name";

    private static final String CREATE_CATEGORY = "{ CALL uspCreateCategory (?, ?) }";
    private static final String UPDATE_CATEGORY = "{ CALL uspUpdateCategoryWithId (?, ?) }";
    private static final String SELECT_BY_ID = "{ CALL uspSelectCategoryWithId (?) }";
    private static final String SELECT_ALL = "{ CALL uspSelectAllCategories }";
    private static final String DELETE_ALL = "{ CALL uspDeleteAllCategories }";

    private final RowMapper<Category> rowMapper = new CategoryRowMapper();

    @Override
    public int save(Category category) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_CATEGORY)) {
            stmt.setString(NAME, category.getName());
            stmt.registerOutParameter(CATEGORY_ID, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(CATEGORY_ID);
        }
    }

    @Override
    public void updateById(int id, Category category) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_CATEGORY)) {
            stmt.setInt(CATEGORY_ID, id);
            stmt.setString(NAME, category.getName());
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Category> findById(int id) throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_ID)) {
            stmt.setInt(CATEGORY_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(rowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() throws Exception {
        List<Category> categories = new ArrayList<>();
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                categories.add(rowMapper.map(rs));
            }
        }
        return categories;
    }

    @Override
    public void deleteAll() throws Exception {
        DataSource ds = DataSourceSingleton.getInstance();
        try (Connection con = ds.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL)) {
            stmt.executeUpdate();
        }
    }

}
