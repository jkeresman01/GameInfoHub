package com.keresman.dal;

import com.keresman.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepostitory {

    void save();

    void updateById();

    Optional<Category> findById();

    List<Category> findAll();
}
