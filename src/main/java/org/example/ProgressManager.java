package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 * Manages user progress data, achievements, and history in a fitness program.
 *
 * Author: Taqwa Odeh
 */
public class ProgressManager {
    /**
     * Stores the current progress data (e.g., weight, BMI, attendance).
     */
    private Map<String, String> progressData = new HashMap<>();
    /**
     * Stores the achievements and their corresponding badges.
     */
    private Map<String, List<String>> achievements = new HashMap<>();
    /**
     * Stores the history of progress updates.
     */
    private List<Map<String, String>> progressHistory = new ArrayList<>();

    /**
     * Inputs the user's progress data (weight, BMI, and attendance).
     *
     * @param weight     The user's current weight.
     * @param bmi        The user's current BMI.
     * @param attendance The user's attendance percentage.
     */
    public void  inputProgressData(String weight, String bmi, String attendance) {
        progressData.put("Weight", weight);
        progressData.put("BMI", bmi);
        progressData.put("Attendance", attendance);
    }
    /**
     * Retrieves the current progress data.
     *
     * @return A map containing the progress data (weight, BMI, and attendance).
     */
    public Map<String, String> getProgressData() {
        return progressData;
    }

    /**
     * Records the completion of a program and assigns a badge for the achievement.
     *
     * @param achievement The achievement name (e.g., "Completed 8-week program").
     * @param badge       The badge associated with the achievement.
     */
    public void completeProgram(String achievement, String badge) {
        achievements.putIfAbsent(achievement, new ArrayList<>());
        achievements.get(achievement).add(badge);
    }
    /**
     * Retrieves the achievements and their corresponding badges.
     *
     * @return A map where the key is the achievement name and the value is a list of badges.
     */
    public Map<String, List<String>> getAchievements() {
        return achievements;
    }

    /**
     * Records a snapshot of the user's progress history on a specific date.
     *
     * @param date       The date of the record.
     * @param weight     The weight at the time of the record.
     * @param bmi        The BMI at the time of the record.
     * @param attendance The attendance percentage at the time of the record.
     */
    public void recordProgressHistory(String date, String weight, String bmi, String attendance) {
        Map<String, String> record = new HashMap<>();
        record.put("Date", date);
        record.put("Weight", weight);
        record.put("BMI", bmi);
        record.put("Attendance", attendance);
        progressHistory.add(record);
    }
    /**
     * Retrieves the user's progress history.
     *
     * @return A list of maps where each map represents a progress record with date, weight, BMI, and attendance.
     */
    public List<Map<String, String>> getProgressHistory() {
        return progressHistory;
    }
    /**
     * Generates a summary of the user's overall fitness progress.
     *
     * @param totalPrograms      The total number of completed programs.
     * @param achievementsEarned The total number of achievements earned.
     * @param weightLost         The total weight lost by the user.
     * @param bmiReduction       The total reduction in BMI.
     * @return A map containing the progress summary details.
     */
    public Map<String, String> generateSummary(int totalPrograms, int achievementsEarned, String weightLost, String bmiReduction) {
        Map<String, String> summary = new HashMap<>();
        summary.put("Total Programs", String.valueOf(totalPrograms));
        summary.put("Achievements Earned", String.valueOf(achievementsEarned));
        summary.put("Weight Lost", weightLost);
        summary.put("BMI Reduction", bmiReduction);

        System.out.println("Progress Summary: " + summary);
        return summary;
    }


}
