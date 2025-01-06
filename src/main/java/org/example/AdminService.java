package org.example;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface AdminService {
    //1
    List<Instructor> getPendingInstructors();
    List<Client> getPendingClients();
//    void approveInstructor(Long id);
//    void approveClient(Long id);


    InstructorRepository getInstructorRepository();

    Collection<Client> getClients();

    ClientRepository getClientsRepository();


//    Object getUserActivityReport();
//    Map<Program, Double> getProgramEnrollmentStatistics();

//    List<Map<String, Double>> getProgramEnrollmentStatisticsAsTable();


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

    Collection<Instructor> getInstructors();
}
