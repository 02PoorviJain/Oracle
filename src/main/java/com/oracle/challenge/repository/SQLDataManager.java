package com.oracle.challenge.repository;

import com.oracle.challenge.model.CustomerData;
import java.util.List;

public class SQLDataManager implements DataManager {
    //private SqlClient sqlClient;

    @Override
    public void addCustomerData(CustomerData customerData) {
        //Can execute sql query here.
        // sqlClient.execute(addQuery);
    }

    @Override
    public List<CustomerData> getCustomerDataList() {
        return null;
    }
}
