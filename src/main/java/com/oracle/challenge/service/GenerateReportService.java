package com.oracle.challenge.service;

import com.oracle.challenge.queryexecuter.QueryExecuter;
import com.oracle.challenge.report.ReportGenerator;


public class GenerateReportService {
    private final ReportGenerator reportGenerator;

    public GenerateReportService(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void generateReport(QueryExecuter queryExecuter) {
        reportGenerator.generateReport(queryExecuter);
        System.out.println("Report generated successfully");
    }
}
