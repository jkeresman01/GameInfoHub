package com.keresman.mapper;

import com.keresman.model.Gender;
import com.keresman.model.Role;
import com.keresman.model.User;
import java.sql.ResultSet;

public class UserRowMapper implements RowMapper<User> {

  @Override
  public User map(ResultSet resultSet) throws Exception {
    return new User(
        resultSet.getInt("Id"),
        resultSet.getString("Username"),
        resultSet.getString("PasswordHash"),
        resultSet.getString("FirstName"),
        resultSet.getString("LastName"),
        resultSet.getString("Email"),
        Role.from(resultSet.getString("RoleName")),
        Gender.from(resultSet.getString("GenderName")),
        resultSet.getBoolean("IsActive"),
        resultSet.getString("PicturePath"),
        resultSet.getTimestamp("CreatedAt").toLocalDateTime(),
        resultSet.getTimestamp("UpdatedAt").toLocalDateTime());
  }
}
