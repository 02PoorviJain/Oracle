package com.oracle.challenge.service;

import com.oracle.challenge.model.CustomerData;
import com.oracle.challenge.parser.CustomerDataParser;
import com.oracle.challenge.queryexecuter.InMemoryQueryExecuter;
import com.oracle.challenge.queryexecuter.QueryExecuter;
import com.oracle.challenge.report.ConsoleResponseGenerator;
import com.oracle.challenge.report.ReportGenerator;
import com.oracle.challenge.repository.DataManager;
import com.oracle.challenge.repository.InMemoryDataManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateReportServiceTest {
    private GenerateReportService generateReportService;
    private DataManager dataManager;
    private CustomerDataParser customerDataParser;

    @BeforeEach
    public void setUp() {
        dataManager = new InMemoryDataManager();
        customerDataParser = new CustomerDataParser();
        ReportGenerator reportGenerator = new ConsoleResponseGenerator();
        generateReportService = new GenerateReportService(reportGenerator);
    }

    @Test
    void generateReport() {
        String filePath = "src/main/resources/static/input.txt";
        List<CustomerData> customerData = customerDataParser.parseCustomerDataFromFile(filePath);
        dataManager.addCustomerData(customerData);
        QueryExecuter queryExecuter = new InMemoryQueryExecuter(dataManager);
        generateReportService.generateReport(queryExecuter);

    }

}
