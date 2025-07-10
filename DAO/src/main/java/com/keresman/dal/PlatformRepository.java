package com.keresman.dal;

import com.keresman.model.Platform;
import java.util.List;
import java.util.Optional;

public interface PlatformRepository {

  int save(Platform platform) throws Exception;

  void updateById(int id, Platform platform) throws Exception;

  Optional<Platform> findById(int id) throws Exception;

  List<Platform> findAll() throws Exception;

  void deleteAll() throws Exception;
}
