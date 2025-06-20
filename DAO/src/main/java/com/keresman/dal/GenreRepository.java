package com.keresman.dal;

import com.keresman.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {

    void save();

    void updateById();

    Optional<Genre> findById();

    List<Genre> findAll();
}
