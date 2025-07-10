package com.keresman.mapper;

import com.keresman.model.Platform;
import java.sql.ResultSet;

public class PlatformRowMapper implements RowMapper<Platform> {

  @Override
  public Platform map(ResultSet rs) throws Exception {
    return new Platform(rs.getInt("Id"), rs.getString("Name"));
  }
}
