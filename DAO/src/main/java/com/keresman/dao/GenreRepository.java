package com.keresman.dao;

import com.keresman.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    int save(Genre genre) throws Exception;

    void updateById(int id, Genre genre) throws Exception;

    void deleteById(int id) throws Exception;

    Optional<Genre> findById(int id) throws Exception;

    Optional<Genre> findByName(String name) throws Exception;

    List<Genre> findAll() throws Exception;

    boolean existsByName(String name) throws Exception;
}
