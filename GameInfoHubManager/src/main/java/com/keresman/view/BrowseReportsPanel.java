package com.keresman.view;

import com.keresman.dal.ReportRepository;
import com.keresman.dal.RepositoryFactory;
import com.keresman.model.Report;
import com.keresman.service.ReportService;
import com.keresman.utilities.MessageUtils;
import com.keresman.validator.Result;
import com.keresman.view.designer.BrowseReportsPanelDesigner;
import com.keresman.view.model.ReportTableModel;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

public class BrowseReportsPanel extends BrowseReportsPanelDesigner {

  private static final int REPORTS_TABLE_ROW_HEIGHT = 25;

  private ReportService reportService;
  private ReportTableModel reportTableModel;
  private int selectedReportId;

  public BrowseReportsPanel() {
    super();
    init();
  }

  private void init() {
    try {
      initService();
      initTable();
    } catch (Exception ex) {
      handleInitializationError(ex);
    }
  }

  private void initService() throws Exception {
    reportService = new ReportService(RepositoryFactory.getInstance(ReportRepository.class));
  }

  private void initTable() throws Exception {
    setupTableUI();
    loadReportsToTable();
  }

  private void setupTableUI() {
    tblReports.setRowHeight(REPORTS_TABLE_ROW_HEIGHT);
    tblReports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tblReports.setAutoCreateRowSorter(true);
  }

  private void loadReportsToTable() {
    Result<List<Report>> result = reportService.getAllReports();

    if (result.isSuccess()) {
      List<Report> reports = result.getData().orElse(List.of());
      reportTableModel = new ReportTableModel(reports);
      tblReports.setModel(reportTableModel);
    } else {
      showError("Failed to Load Reports", result.getMessage());
    }
  }

  @Override
  public void tblReportsMouseClicked(MouseEvent evt) {
    if (!hasSelectedRow()) {
      return;
    }
    loadSelectedReport();
  }

  private boolean hasSelectedRow() {
    return tblReports.getSelectedRow() != -1;
  }

  private void loadSelectedReport() {
    selectedReportId = getSelectedReportId();
    Result<Report> result = reportService.getReportById(selectedReportId);

    if (result.isSuccess()) {
      result.getData().ifPresent(this::populateForm);
    } else {
      resetForm(result.getMessage());
    }
  }

  private int getSelectedReportId() {
    int selectedRow = tblReports.getSelectedRow();
    return (int) reportTableModel.getValueAt(selectedRow, 0);
  }

  private void populateForm(Report report) {
    tfTitle.setText(report.getTitle());
    tfContent.setText(report.getContent());
  }

  private void resetForm(String message) {
    clearForm();
    showError("Error", message);
  }

  private void clearForm() {
    tfTitle.setText("");
    tfContent.setText("");
  }

  private void showError(String title, String message) {
    MessageUtils.showErrorMessage(title, message);
  }

  @Override
  public void formComponentShown(ComponentEvent evt) {
    loadReportsToTable();
  }

  private void handleInitializationError(Exception ex) {
    Logger.getLogger(BrowseReportsPanel.class.getName()).log(Level.SEVERE, null, ex);
    showError("Unrecoverable error", "Cannot initiate the form");
    System.exit(1);
  }
}
