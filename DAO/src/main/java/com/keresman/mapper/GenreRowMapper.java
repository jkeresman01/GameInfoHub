package com.keresman.mapper;

import com.keresman.model.Genre;
import java.sql.ResultSet;

public class GenreRowMapper implements RowMapper<Genre> {

  @Override
  public Genre map(ResultSet rs) throws Exception {
    return new Genre(rs.getInt("Id"), rs.getString("Name"));
  }
}
