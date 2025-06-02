package com.keresman.dao;

import com.keresman.model.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    int save(Review review) throws Exception;

    void updateById(int id, Review review) throws Exception;

    void deleteById(int id) throws Exception;

    Optional<Review> findById(int id) throws Exception;

    List<Review> findByGameId(int gameId) throws Exception;

    List<Review> findAll() throws Exception;
}
