package com.oracle.challenge.service;

import com.oracle.challenge.queryexecuter.InMemoryQueryExecuter;
import com.oracle.challenge.queryexecuter.QueryExecuter;
import com.oracle.challenge.report.ConsoleResponseGenerator;
import com.oracle.challenge.report.ReportGenerator;
import com.oracle.challenge.repository.DataManager;
import com.oracle.challenge.repository.InMemoryDataManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenerateReportServiceTest {
    private GenerateReportService generateReportService;
    private DataManager dataManager;

    @BeforeEach
    public void setUp() {
        dataManager = new InMemoryDataManager();
        ReportGenerator reportGenerator = new ConsoleResponseGenerator();
        generateReportService = new GenerateReportService(reportGenerator);
    }

    @Test
    void generateReport() {
        String filePath = "src/main/resources/static/input.txt";
        dataManager.addCustomerData(filePath);
        QueryExecuter queryExecuter = new InMemoryQueryExecuter(dataManager);
        generateReportService.generateReport(queryExecuter);

    }

}
