package com.keresman.dal;

import com.keresman.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    void save(Genre genre);

    void updateById(int id, Genre genre);

    Optional<Genre> findById();

    List<Genre> findAll();

    void deleteAll() throws Exception;

}
