package com.keresman.dao;

import com.keresman.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    int createUser(User user) throws Exception;

    void updateUserWithID(int id, User data) throws Exception;

    void deleteUserWithId(int id) throws Exception;

    boolean existsUserWithUsername(String username) throws Exception;
    
    boolean existsUserWithEmail(String email) throws Exception;
    
    Optional<User> selectUserWithId(int id) throws Exception;

    Optional<User> selectUserWithUsername(String username) throws Exception;

    List<User> selectUsers() throws Exception;

}
