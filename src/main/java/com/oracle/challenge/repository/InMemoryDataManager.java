package com.oracle.challenge.repository;

import com.oracle.challenge.model.CustomerData;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDataManager implements DataManager {
    private final List<CustomerData> list = new ArrayList<>();

    @Override
    public void addCustomerData(CustomerData customerData) {
        list.add(customerData);
    }

    @Override
    public List<CustomerData> getCustomerDataList() {
        return list;
    }
}
