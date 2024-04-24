package com.oracle.challenge.queryexecuter;

import com.oracle.challenge.model.CustomerData;
import com.oracle.challenge.repository.DataManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryQueryExecuter implements QueryExecuter {

    private final DataManager inMemoryDataManager;

    // Constructor to initialize the QueryManager with input data
    public InMemoryQueryExecuter(DataManager inMemoryDataManager) {
        this.inMemoryDataManager = inMemoryDataManager;
    }

    // Method to get the number of unique customerIds for each contractId
    @Override
    public Map<Long, Long> getUniqueCustomerIdsPerContract() {
        return inMemoryDataManager.getCustomerDataList().stream()
                .collect(Collectors.groupingBy(CustomerData::getContractId, Collectors.mapping(CustomerData::getCustomerId, Collectors.counting())));
    }

    // Method to get the number of unique customerIds for each geoZone
    @Override
    public Map<String, Long> getUniqueCustomerIdsPerGeoZone() {
        return inMemoryDataManager.getCustomerDataList().stream()
                .collect(Collectors.groupingBy(CustomerData::getGeoZone, Collectors.mapping(CustomerData::getCustomerId, Collectors.counting())));
    }

    // Method to calculate the average build duration for each geoZone
    @Override
    public Map<String, Double> getAverageBuildDurationPerGeoZone() {
        return inMemoryDataManager.getCustomerDataList().stream()
                .collect(Collectors.groupingBy(CustomerData::getGeoZone, Collectors.averagingDouble(data -> parseBuildDuration(data.getBuildDuration()))));
    }

    // Helper method to parse build duration (assuming it's in seconds)
    private double parseBuildDuration(String duration) {
        return Double.parseDouble(duration.substring(0, duration.length() - 1));
    }

    // Method to collect unique customerIds for each geoZone
    @Override
    public Map<String, List<Long>> getUniqueCustomerIdsListPerGeoZone() {
        return inMemoryDataManager.getCustomerDataList().stream()
                .collect(Collectors.groupingBy(CustomerData::getGeoZone, Collectors.mapping(CustomerData::getCustomerId, Collectors.toList())));
    }
}
