package com.oracle.challenge.repository;

import com.oracle.challenge.model.CustomerData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDataManager implements DataManager {
    private final List<CustomerData> customerDataList = new ArrayList<>();

    @Override
    public void addCustomerData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] col = line.split(",");
                if (col.length == 6) {
                    long customerId = Long.parseLong(col[0]);
                    long contractId = Long.parseLong(col[1]);
                    String geoZone = col[2];
                    String teamCode = col[3];
                    String projectCode = col[4];
                    String buildDuration = col[5];

                    CustomerData customerData = new CustomerData(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
                    customerDataList.add(customerData);
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CustomerData> getCustomerDataList() {
        return customerDataList;
    }
}
