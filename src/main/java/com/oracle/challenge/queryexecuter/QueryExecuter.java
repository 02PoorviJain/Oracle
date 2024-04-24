package com.oracle.challenge.queryexecuter;

import java.util.List;
import java.util.Map;

public interface QueryExecuter {
    Map<Long, Long> getUniqueCustomerIdsPerContract();

    Map<String, Long> getUniqueCustomerIdsPerGeoZone();

    Map<String, Double> getAverageBuildDurationPerGeoZone();

    Map<String, List<Long>> getUniqueCustomerIdsListPerGeoZone();
}
