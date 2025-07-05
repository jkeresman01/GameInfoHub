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

    private void handleInitializationError(Exception ex) {
        Logger.getLogger(ArticlesPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
        System.exit(1);
    }

    private void initTable() throws Exception {
        tblReports.setRowHeight(25);
        tblReports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblReports.setAutoCreateRowSorter(true);

        Result<List<Report>> allReports = reportService.getAllReports();

        if (allReports.isSuccess()) {
            reportTableModel = new ReportTableModel(allReports.getData().get());
            tblReports.setModel(reportTableModel);
        } else {
            MessageUtils.showErrorMessage("Failed to Load Reports", allReports.getMessage());
        }
    }

    @Override
    public void tblReportsMouseClicked(MouseEvent evt) {
        int selectedRow = tblReports.getSelectedRow();
        selectedReportId = (int) reportTableModel.getValueAt(selectedRow, 0);

        Result<Report> reportById = reportService.getReportById(selectedReportId);

        if (reportById.isSuccess() && reportById.getData().isPresent()) {
            Report report = reportById.getData().get();
            tfTitle.setText(report.getTitle());
            tfContent.setText(report.getContent());
        } else {
            tfTitle.setText("");
            tfContent.setText("");
            MessageUtils.showErrorMessage("Error", reportById.getMessage());
        }
    }

    @Override
    public void formComponentShown(ComponentEvent evt) {
        Result<List<Report>> allReports = reportService.getAllReports();

        if (allReports.isSuccess()) {
            reportTableModel = new ReportTableModel(allReports.getData().get());
            tblReports.setModel(reportTableModel);
        } else {
            MessageUtils.showErrorMessage("Failed to Load Reports", allReports.getMessage());
        }
    }

}
