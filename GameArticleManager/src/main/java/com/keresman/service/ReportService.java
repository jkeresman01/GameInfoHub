package com.keresman.service;

import com.keresman.dal.ReportRepository;
import com.keresman.model.Report;
import com.keresman.validator.Result;

import java.util.List;
import java.util.Optional;

public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Result<Report> getReportById(int id) {
        try {
            Optional<Report> report = reportRepository.findById(id);
            return report.map(Result::success)
                    .orElseGet(() -> Result.error("Report with ID [%d] not found.".formatted(id)));
        } catch (Exception e) {
            return Result.error("Failed to fetch report with ID [%d].".formatted(id));
        }
    }

    public Result<List<Report>> getAllReports() {
        try {
            List<Report> reports = reportRepository.findAll();
            return Result.success(reports);
        } catch (Exception e) {
            return Result.error("Failed to fetch reports.");
        }
    }

    public Result<List<Report>> getReportsByArticleId(int articleId) {
        try {
            List<Report> reports = reportRepository.findByArticleId(articleId);
            return Result.success(reports);
        } catch (Exception e) {
            return Result.error("Failed to fetch reports for Article ID [%d].".formatted(articleId));
        }
    }

    public Result<Void> createReport(Report report, int userId, int articleId) {
        try {
            reportRepository.save(report, userId, articleId);
            return Result.success();
        } catch (Exception e) {
            return Result.error("Failed to create report.");
        }
    }

    public Result<Void> deleteAllReports() {
        try {
            reportRepository.deleteAll();
            return Result.success();
        } catch (Exception e) {
            return Result.error("Failed to delete all reports.");
        }
    }
}
