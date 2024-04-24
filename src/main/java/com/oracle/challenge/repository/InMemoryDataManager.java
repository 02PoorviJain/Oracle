package com.oracle.challenge.repository;

import com.oracle.challenge.model.CustomerData;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataManager implements DataManager {

    private List<CustomerData> customerDataList = new ArrayList<>();

    @Override
    public void addCustomerData(List<CustomerData> customerDataList) {
        this.customerDataList = customerDataList;
    }

    @Override
    public List<CustomerData> getCustomerDataList() {
        return customerDataList;
    }
}
