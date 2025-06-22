package com.keresman.dal;

import com.keresman.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    int save(User user) throws Exception;

    void updateById(int id, User data) throws Exception;

    void deleteById(int id) throws Exception;
    
    void deleteAll() throws Exception;

    boolean existsByUsername(String username) throws Exception;

    boolean existsByEmail(String email) throws Exception;

    Optional<User> findById(int id) throws Exception;

    Optional<User> findByUsername(String username) throws Exception;

    List<User> findAll() throws Exception;

    void activateById(int id) throws Exception;

    void deactivateById(int id) throws Exception;
}
