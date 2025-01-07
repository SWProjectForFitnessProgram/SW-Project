package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/**
 * Interface representing the administrative services provided by an admin.
 * Author: gaidaa
 */
public interface AdminService {
    /**
     * Retrieves a list of pending instructors awaiting approval.
     *
     * @return a list of pending {@link Instructor} objects.
     */
    //1
    List<Instructor> getPendingInstructors();
    /**
     * Retrieves a list of pending clients awaiting approval.
     *
     * @return a list of pending {@link Client} objects.
     */
    List<Client> getPendingClients();
//    void approveInstructor(Long id);
//    void approveClient(Long id);

    /**
     * Gets the repository of instructors.
     *
     * @return an instance of {@link InstructorRepository}.
     */
    InstructorRepository getInstructorRepository();
    /**
     * Retrieves all approved clients.
     *
     * @return a collection of {@link Client} objects.
     */
    Collection<Client> getClients();
    /**
     * Gets the repository of clients.
     *
     * @return an instance of {@link ClientRepository}.
     */
    ClientRepository getClientsRepository();


//    Object getUserActivityReport();
//    Map<Program, Double> getProgramEnrollmentStatistics();
    /**
     * Retrieves program enrollment statistics formatted as a table.
     *
     * @return a list of maps, where each map represents a row containing "Program Name" and "Enrollment Count".
     */
    List<Map<String, String>> getProgramEnrollmentStatisticsAsTable();

    /**
     * Generates a revenue report based on the specified time period.
     *
     * @param lastQuarter a string indicating the time period (e.g., "last quarter").
     * @return a list of maps, where each map contains "Program Name" and "Revenue".
     */
    List<Map<String, String>> generateRevenueReport(String lastQuarter);
    /**
     * Retrieves the statuses of all programs.
     *
     * @return a list of maps, where each map contains "Program Name" and "Status" (e.g., "Upcoming", "Active", "Completed").
     */
    List<Map<String, String>> getProgramStatuses();
    /**
     * Adds a new article to the system.
     *
     * @param article the {@link Article} to be added.
     */
    void addArticle(Article article);
    /**
     * Approves the specified article.
     *
     * @param article the {@link Article} to be approved.
     */
    void approveArticle(Article article);
    /**
     * Rejects the specified recipe.
     *
     * @param recipe the {@link Recipe} to be rejected.
     */
    void rejectRecipe(Recipe recipe);
    /**
     * Adds a new complaint to the system.
     *
     * @param complaint the {@link Complaint} to be added.
     */
    void addComplaint(Complaint complaint);
    /**
     * Adds a new health tip to the system.
     *
     * @param tip the {@link HealthTip} to be added.
     */
    void addTip(HealthTip tip);
    /**
     * Approves the specified health tip.
     *
     * @param tip the {@link HealthTip} to be approved.
     */
    void approveTip(HealthTip tip);
    /**
     * Resolves the specified complaint.
     *
     * @param complaint the {@link Complaint} to be resolved.
     */
    void resolveComplaint(Complaint complaint);
    /**
     * Adds a new recipe to the system.
     *
     * @param recipe the {@link Recipe} to be added.
     */
    void addRecipe(Recipe recipe);
    /**
     * Rejects the specified article.
     *
     * @param article the {@link Article} to be rejected.
     */
    void rejectArticle(Article article);
    /**
     * Retrieves all instructors from the system.
     *
     * @return a collection of {@link Instructor} objects.
     */
    Collection<Instructor> getInstructors();
}
