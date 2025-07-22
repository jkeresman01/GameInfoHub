package com.keresman.dal;

import com.keresman.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

  int save(Genre genre) throws Exception;

  void updateById(int id, Genre genre) throws Exception;

  Optional<Genre> findById(int id) throws Exception;

  List<Genre> findAll() throws Exception;

  void deleteAll() throws Exception;
}
