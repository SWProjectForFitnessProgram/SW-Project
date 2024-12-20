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

    void addArticle(Article article);

    void approveArticle(Article article);

    void rejectRecipe(Recipe recipe);

    void addComplaint(Complaint complaint);

    void addTip(HealthTip tip);

    void approveTip(HealthTip tip);

    void resolveComplaint(Complaint complaint);

    void addRecipe(Recipe recipe);

    void rejectArticle(Article article);
}
