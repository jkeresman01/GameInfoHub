package com.keresman.model;

public final class Report {

    private int reportId;
    private String title;
    private String content;

    public Report() {
    }

    public Report(int reportId, String title, String content) {
        this.reportId = reportId;
        this.title = title;
        this.content = content;
    }

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
