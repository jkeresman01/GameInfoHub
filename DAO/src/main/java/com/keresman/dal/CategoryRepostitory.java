package com.keresman.dal;

import com.keresman.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepostitory {

    void save() throws Exception;

    void updateById(int id, Category category) throws Exception;

    Optional<Category> findById(int id) throws Exception;

    List<Category> findAll() throws Exception;

    void deleteAll() throws Exception;

}
