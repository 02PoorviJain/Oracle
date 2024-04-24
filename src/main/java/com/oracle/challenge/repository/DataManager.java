package com.oracle.challenge.repository;

import com.oracle.challenge.model.CustomerData;
import java.util.List;

public interface DataManager {
    void addCustomerData(String filePath);
    List<CustomerData> getCustomerDataList();
}
