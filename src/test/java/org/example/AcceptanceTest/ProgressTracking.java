package org.example.AcceptanceTest;

import io.cucumber.java.be.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Client;
import org.example.Instructor;
import org.example.ProgressManager;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressTracking {
    private ProgressManager progressManager = new ProgressManager();
    private Map<String, String> progressData;
    private List<Map<String, String>> progressHistory;
    private Map<String, List<String>> achievements = new HashMap<>();
//    private Instructor instructor;
//    private Client client;
//    private String feedback;
//
//    public ProgressTracking()
//    {
//        instructor = new Instructor("Test Instructor in the client progress tracking","test@gmail.com",30);
//    }

    @Given("I am logged in and on the {string} page")
    public void iAmLoggedInAndOnThePage(String page) {
        System.out.println("Logged in and navigated to: " + page);
    }

    @When("I input my personal fitness data \\(weight, BMI, attendance)")
    public void iInputMyPersonalFitnessDataWeightBMIAttendance() {

        progressManager.inputProgressData("70kg", "24.5", "80%");


        progressData = progressManager.getProgressData();
        System.out.println("Fitness data input: " + progressData);
    }


    @Then("I should see my current fitness milestones updated \\(weight, BMI, attendance records)")
    public void iShouldSeeMyCurrentFitnessMilestonesUpdatedWeightBMIAttendanceRecords() {
        Assert.assertEquals("Weight mismatch", "70kg", progressData.get("Weight"));
        Assert.assertEquals("BMI mismatch", "24.5", progressData.get("BMI"));
        Assert.assertEquals("Attendance mismatch", "80%", progressData.get("Attendance"));
        System.out.println("Current fitness milestones: " + progressData);
    }

    @Given("I have completed a fitness program")
    public void iHaveCompletedAFitnessProgram() {
        progressManager.completeProgram("Completed 8-week program", "Fitness Achiever Badge");
        progressManager.completeProgram("BMI improvement", "Health Champion Badge");


        achievements = progressManager.getAchievements();
        System.out.println("Achievements: " + achievements);
    }


    @When("I view my progress")
    public void iViewMyProgress() {

        System.out.println("Viewing progress...");
    }

    @Then("I should see any achievements or badges earned for completing the program")
    public void iShouldSeeAnyAchievementsOrBadgesEarnedForCompletingTheProgram(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String achievement = row.get("Achievement");
            String expectedBadge = row.get("Badge");

            Assert.assertTrue("Achievement not found: " + achievement, achievements.containsKey(achievement));

            List<String> actualBadges = achievements.get(achievement);
            Assert.assertTrue("Badge mismatch for achievement: " + achievement, actualBadges.contains(expectedBadge));

            System.out.println(achievement + ": " + actualBadges);
        }
    }


    @Given("I have entered my fitness milestones \\(weight, BMI, attendance) at different times")
    public void iHaveEnteredMyFitnessMilestonesWeightBMIAttendanceAtDifferentTimes() {
        progressManager.recordProgressHistory("2024-10-01", "70kg", "24.5", "80%");
        progressManager.recordProgressHistory("2024-11-01", "68kg", "23.9", "85%");

        System.out.println("Fitness milestones entered at different times: " + progressManager.getProgressHistory());
    }


    @When("I check my progress history")
    public void iCheckMyProgressHistory() {
        System.out.println("Checking progress history...");
    }

    @Then("I should see a record of my previous fitness milestones, with clear indications of improvement or decline over time")
    public void iShouldSeeARecordOfMyPreviousFitnessMilestonesWithClearIndicationsOfImprovementOrDeclineOverTime(DataTable dataTable) {
        List<Map<String, String>> actualHistory = progressManager.getProgressHistory();

        for (Map<String, String> expectedRecord : dataTable.asMaps(String.class, String.class)) {
            String date = expectedRecord.get("Date");
            String expectedWeight = expectedRecord.get("Weight");
            String expectedBMI = expectedRecord.get("BMI");
            String expectedAttendance = expectedRecord.get("Attendance");

            Map<String, String> actualRecord = actualHistory.stream()
                    .filter(record -> record.get("Date").equals(date))
                    .findFirst()
                    .orElseThrow(() -> new AssertionError("No record found for date: " + date));

            Assert.assertEquals("Weight mismatch for date " + date, expectedWeight, actualRecord.get("Weight"));
            Assert.assertEquals("BMI mismatch for date " + date, expectedBMI, actualRecord.get("BMI"));
            Assert.assertEquals("Attendance mismatch for date " + date, expectedAttendance, actualRecord.get("Attendance"));

            System.out.println("Progress history for " + date + ": " + actualRecord);
        }
    }



    @Given("I have completed multiple programs and entered various fitness milestones")
    public void iHaveCompletedMultipleProgramsAndEnteredVariousFitnessMilestones() {
        achievements = Map.of(
                "Completed 8-week program", List.of("Fitness Achiever Badge"),
                "BMI improvement", List.of("Health Champion Badge")
        );
        System.out.println("Fitness program completed.");
    }

    @When("I check my overall progress summary")
    public void iCheckMyOverallProgressSummary() {

        System.out.println("Checking overall progress summary...");
    }

    @Then("I should see an overview of my fitness journey, including the total number of completed programs, achievements earned, and the change in my fitness milestones")
    public void iShouldSeeAnOverviewOfMyFitnessJourneyIncludingTheTotalNumberOfCompletedProgramsAchievementsEarnedAndTheChangeInMyFitnessMilestones(DataTable dataTable) {

        Map<String, String> summary = progressManager.generateSummary(3, 5, "3kg", "0.6");


        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String metric = row.get("Metric");
            String expectedValue = row.get("Value");

            String actualValue = summary.get(metric);
            Assert.assertEquals("Mismatch for metric: " + metric, expectedValue, actualValue);
            System.out.println(metric + ": " + actualValue);
        }
    }



}
