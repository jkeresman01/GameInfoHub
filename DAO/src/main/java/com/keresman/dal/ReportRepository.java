package com.keresman.dal;

import com.keresman.model.Report;
import java.util.List;

public interface ReportRepository {

    int save(Report report, int userId, int articleId) throws Exception;

    List<Report> findByArticleId(int articleId) throws Exception;

    List<Report> findAll() throws Exception;

    void deleteAll() throws Exception;

}
