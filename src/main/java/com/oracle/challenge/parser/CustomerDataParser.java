package com.oracle.challenge.parser;

import com.oracle.challenge.model.CustomerData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataParser {
    public List<CustomerData> parseCustomerDataFromFile(String filePath) {

        List<CustomerData> customerDataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    long customerId = Long.parseLong(parts[0]);
                    long contractId = Long.parseLong(parts[1]);
                    String geoZone = parts[2];
                    String teamCode = parts[3];
                    String projectCode = parts[4];
                    String buildDuration = parts[5];

                    CustomerData customerData = new CustomerData(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
                    customerDataList.add(customerData);
                } else {
                    System.err.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerDataList;
    }
}
