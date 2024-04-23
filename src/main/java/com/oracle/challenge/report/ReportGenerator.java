package com.oracle.challenge.report;

import com.oracle.challenge.queryexecuter.IQueryExecuter;
import com.oracle.challenge.queryexecuter.QueryManager;

public interface ReportStrategy {
    //ToDo It can be renamed as IReportGenerator
    void generateReport(IQueryExecuter queryExecuter);
}
