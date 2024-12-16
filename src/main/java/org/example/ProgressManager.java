package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class ProgressManager {

    private Map<String, String> progressData = new HashMap<>();
    private Map<String, List<String>> achievements = new HashMap<>();
    private List<Map<String, String>> progressHistory = new ArrayList<>();


    public void  inputProgressData(String weight, String bmi, String attendance) {
        progressData.put("Weight", weight);
        progressData.put("BMI", bmi);
        progressData.put("Attendance", attendance);
    }

    public Map<String, String> getProgressData() {
        return progressData;
    }


    public void completeProgram(String achievement, String badge) {
        achievements.putIfAbsent(achievement, new ArrayList<>());
        achievements.get(achievement).add(badge);
    }

    public Map<String, List<String>> getAchievements() {
        return achievements;
    }


    public void recordProgressHistory(String date, String weight, String bmi, String attendance) {
        Map<String, String> record = new HashMap<>();
        record.put("Date", date);
        record.put("Weight", weight);
        record.put("BMI", bmi);
        record.put("Attendance", attendance);
        progressHistory.add(record);
    }

    public List<Map<String, String>> getProgressHistory() {
        return progressHistory;
    }

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
