package com.oracle.challenge.service;

import com.oracle.challenge.model.CustomerData;
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

        dataManager.addCustomerData(new CustomerData(2343225L, 2345L, "us_east", "RedTeam", "ProjectApple", "3445"));
        dataManager.addCustomerData(new CustomerData(1223456L, 2345L, "us_west", "BlueTeam", "ProjectBanana", "2211"));
        dataManager.addCustomerData(new CustomerData(3244332L, 2346L, "eu_west", "YellowTeam3", "ProjectCarrot", "4322"));
        dataManager.addCustomerData(new CustomerData(1233456L, 2345L, "us_west", "BlueTeam", "ProjectDate", "2221"));
        dataManager.addCustomerData(new CustomerData(3244132L, 2346L, "eu_west", "YellowTeam3", "ProjectEgg", "4122"));

        QueryExecuter queryExecuter = new InMemoryQueryExecuter(dataManager);
        generateReportService.generateReport(queryExecuter);

    }

}
