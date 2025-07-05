package com.keresman.mapper;

import com.keresman.model.Report;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRowMapper implements RowMapper<Report> {

    @Override
    public Report map(ResultSet rs) throws SQLException {
        Report report = new Report();
        report.setReportId(rs.getInt("Id"));
        report.setTitle(rs.getString("Title"));
        report.setContent(rs.getString("Content"));
        return report;
    }
}
