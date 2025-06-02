package com.keresman.dao;

import com.keresman.model.Developer;
import java.util.List;
import java.util.Optional;

public interface DeveloperRepository {

    int save(Developer developer) throws Exception;

    void updateById(int id, Developer developer) throws Exception;

    void deleteById(int id) throws Exception;

    Optional<Developer> findById(int id) throws Exception;

    Optional<Developer> findByName(String name) throws Exception;

    List<Developer> findAll() throws Exception;

    boolean existsByName(String name) throws Exception;
}
