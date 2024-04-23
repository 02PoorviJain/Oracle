package com.oracle.challenge.report;

import com.oracle.challenge.queryexecuter.QueryExecuter;

public interface ReportGenerator {
    void generateReport(QueryExecuter queryExecuter);
}
