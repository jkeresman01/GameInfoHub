package com.keresman.dal.sql;

import com.keresman.dal.ReportRepository;
import com.keresman.mapper.ReportRowMapper;
import com.keresman.mapper.RowMapper;
import com.keresman.model.Report;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLReportRepository implements ReportRepository {

    private static final String REPORT_ID = "ReportId";
    private static final String TITLE = "Title";
    private static final String CONTENT = "Content";
    private static final String USER_ID = "UserId";
    private static final String ARTICLE_ID = "ArticleId";

    private static final String SELECT_BY_ID = "{ CALL uspSelectReportById(?) }";
    private static final String INSERT_REPORT = "{ CALL uspInsertReport(?, ?, ?, ?, ?) }";
    private static final String SELECT_BY_ARTICLE_ID = "{ CALL uspSelectReportsByArticleId(?) }";
    private static final String SELECT_ALL = "{ CALL uspSelectAllReports }";
    private static final String DELETE_ALL = "{ CALL uspDeleteAllReports }";

    private final RowMapper<Report> reportRowMapper = new ReportRowMapper();

    @Override
    public int save(Report report, int userId, int articleId) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(INSERT_REPORT)) {

            stmt.setString(TITLE, report.getTitle());
            stmt.setString(CONTENT, report.getContent());
            stmt.setInt(USER_ID, userId);
            stmt.setInt(ARTICLE_ID, articleId);
            stmt.registerOutParameter(REPORT_ID, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(REPORT_ID);
        }
    }

    @Override
    public List<Report> findByArticleId(int articleId) throws Exception {
        List<Report> reports = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_ARTICLE_ID)) {

            stmt.setInt(ARTICLE_ID, articleId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reports.add(reportRowMapper.map(rs));
                }
            }
        }
        return reports;
    }

    @Override
    public List<Report> findAll() throws Exception {
        List<Report> reports = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reports.add(reportRowMapper.map(rs));
            }
        }
        return reports;
    }

    @Override
    public void deleteAll() throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL)) {

            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<Report> findById(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_ID)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(reportRowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }
}
