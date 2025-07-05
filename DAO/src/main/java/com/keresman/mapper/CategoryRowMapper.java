package com.keresman.mapper;

import com.keresman.model.Category;
import java.sql.ResultSet;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category map(ResultSet resultSet) throws Exception {
        return new Category(
                resultSet.getInt("Id"),
                resultSet.getString("Name")
        );
    }

}
