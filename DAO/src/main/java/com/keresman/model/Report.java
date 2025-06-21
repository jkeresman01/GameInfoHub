package com.keresman.model;

public final class Report implements Comparable<Report> {

    private int reportId;
    private String title;
    private String content;

    public Report() {
    }

    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Report(int reportId, String title, String content) {
        this.reportId = reportId;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Report{" + "reportId=" + reportId + ", title=" + title + ", content=" + content + '}';
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.reportId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Report other = (Report) obj;
        return this.reportId == other.reportId;
    }

    @Override
    public int compareTo(Report o) {
        return Integer.compare(reportId, o.reportId);
    }
}
