package com.keresman.dal;

import com.keresman.model.Category;
import com.keresman.model.Developer;
import java.util.List;
import java.util.Optional;

public interface DeveloperRepository {

    int save(Developer developer) throws Exception;

    void updateById(int id, Developer developer) throws Exception;

    Optional<Developer> findById(int id) throws Exception;

    List<Developer> findAll() throws Exception;

    void deleteAll() throws Exception;
}
