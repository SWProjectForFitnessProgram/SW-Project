package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface AdminService {
    List<Instructor> getPendingInstructors();
    List<Client> getPendingClient();
    Object getUserActivityReport();
    Map<Program, Double> getProgramEnrollmentStatistics();

    List<Map<String, String>> getProgramEnrollmentStatisticsAsTable();


    List<Map<String, String>> generateRevenueReport(String lastQuarter);

    List<Map<String, String>> getProgramStatuses();
}
