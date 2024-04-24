package com.oracle.challenge.report;

import com.oracle.challenge.queryexecuter.QueryExecuter;

import java.util.List;
import java.util.Map;

public class ConsoleResponseGenerator implements ReportGenerator {

    @Override
    public void generateReport(QueryExecuter queryExecuter) {

        // Retrieve report data from QueryManager
        Map<Long, Long> uniqueCustomerIdsPerContract = queryExecuter.getUniqueCustomerIdsPerContract();
        Map<String, Long> uniqueCustomerIdsPerGeoZone = queryExecuter.getUniqueCustomerIdsPerGeoZone();
        Map<String, Double> averageBuildDurationPerGeoZone = queryExecuter.getAverageBuildDurationPerGeoZone();
        Map<String, List<Long>> uniqueCustomerIdsListPerGeoZone = queryExecuter.getUniqueCustomerIdsListPerGeoZone();

        // Print report data to console
        System.out.println("Unique Customer IDs per Contract:");
        if (null != uniqueCustomerIdsPerContract) {
            uniqueCustomerIdsPerContract.forEach((contractId, count) -> System.out.println("Contract ID: " + contractId + ", Count: " + count));
            System.out.println();
        } else {
            System.out.println("NULL");
        }

        if (null != uniqueCustomerIdsPerContract) {
            System.out.println("Unique Customer IDs per Geo zone:");
            uniqueCustomerIdsPerGeoZone.forEach((geoZone, count) -> System.out.println("Geo zone: " + geoZone + ", Count: " + count));
            System.out.println();
        } else {
            System.out.println("NULL");
        }

        if (null != averageBuildDurationPerGeoZone) {
            System.out.println("Average Build Duration per Geo zone:");
            averageBuildDurationPerGeoZone.forEach((geoZone, averageDuration) -> System.out.println("Geo zone: " + geoZone + ", Average Duration: " + averageDuration));
            System.out.println();
        } else {
            System.out.println("NULL");
        }

        if (null != uniqueCustomerIdsListPerGeoZone) {
            System.out.println("Unique Customer IDs List per Geo zone:");
            uniqueCustomerIdsListPerGeoZone.forEach((geoZone, customerIdList) -> System.out.println("Geo zone: " + geoZone + ", Customer IDs: " + customerIdList));
        } else {
            System.out.println("NULL");
        }
    }
}
