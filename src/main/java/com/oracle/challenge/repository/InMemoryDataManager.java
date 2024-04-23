package com.oracle.challenge.repository;

import com.oracle.challenge.model.CustomerData;

import java.util.ArrayList;
import java.util.List;

public class InputDataManager {
    private final List<CustomerData> list = new ArrayList<>();

    public void addCustomerData(CustomerData customerData){
        list.add(customerData);
    }
    
    public List<CustomerData> getCustomerDataList(){
        return list;
    }
}
