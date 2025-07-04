package com.keresman.dal;

import com.keresman.model.Report;
import java.util.List;
import java.util.Optional;

public interface ReportRepository {

    void save(Report report) throws Exception;

    void updateById(int id, Report report) throws Exception;

    Optional<Report> findById() throws Exception;

    List<Report> findAll() throws Exception;
}
