package com.keresman.dal;

import com.keresman.model.Report;
import java.util.List;
import java.util.Optional;

public interface ReportRepository {

  int save(Report report, int userId, int articleId) throws Exception;

  List<Report> findByArticleId(int articleId) throws Exception;

  List<Report> findAll() throws Exception;

  Optional<Report> findById(int id) throws Exception;

  void deleteAll() throws Exception;
}
