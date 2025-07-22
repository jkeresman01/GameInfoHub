package com.keresman.view.model;

import com.keresman.model.Report;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReportTableModel extends AbstractTableModel {

  private static final String[] COLUMNS = {"Id", "Title", "Content"};

  private List<Report> reports;

  public ReportTableModel(List<Report> reports) {
    setReports(reports);
  }

  @Override
  public int getRowCount() {
    return reports.size();
  }

  @Override
  public int getColumnCount() {
    return COLUMNS.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Report report = reports.get(rowIndex);
    return switch (columnIndex) {
      case 0 -> report.getReportId();
      case 1 -> report.getTitle();
      case 2 -> report.getContent();
      default -> null;
    };
  }

  public void setReports(List<Report> reports) {
    this.reports = reports;
    fireTableDataChanged();
  }

  @Override
  public String getColumnName(int column) {
    return COLUMNS[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    if (columnIndex == 0) {
      return Integer.class;
    }
    return super.getColumnClass(columnIndex);
  }
}
