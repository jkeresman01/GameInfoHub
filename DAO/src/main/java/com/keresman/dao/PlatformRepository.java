package com.keresman.dao;

import com.keresman.model.Platform;
import java.util.List;
import java.util.Optional;

public interface PlatformRepository {

    int save(Platform platform) throws Exception;

    void updateById(int id, Platform platform) throws Exception;

    void deleteById(int id) throws Exception;

    Optional<Platform> findById(int id) throws Exception;

    Optional<Platform> findByName(String name) throws Exception;

    List<Platform> findAll() throws Exception;

    boolean existsByName(String name) throws Exception;
}
