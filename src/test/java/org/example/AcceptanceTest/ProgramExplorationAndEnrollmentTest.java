package org.example.AcceptanceTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.ProgramManager;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ProgramExplorationAndEnrollmentTest {

    private String currentSection;
    private String selectedProgram;
    private Map<String, String> programDetails;
    private List<Map<String, String>> programsList;
    private ProgramManager programManager = new ProgramManager();

    @Given("I navigate to the {string} section")
    public void iNavigateToTheSection(String section) {
        currentSection = section;
        System.out.println("Navigated to section: " + section);
    }



    @When("I filter programs by difficulty level {string}")
    public void iFilterProgramsByDifficultyLevel(String difficulty) {
        programsList = programManager.filterByDifficulty(difficulty);
        System.out.println("Filtered by difficulty: " + difficulty);
    }


    @Then("I should see a list of programs with difficulty level {string}")
    public void iShouldSeeAListOfProgramsWithDifficultyLevel(String difficulty) {
        Assert.assertTrue("No programs found for difficulty level: " + difficulty,
                programsList.stream().allMatch(program -> program.get("Difficulty").equals(difficulty)));
        programsList.forEach(program -> System.out.println("Program: " + program.get("Name")));
    }


    @When("I filter programs by focus area {string}")
    public void iFilterProgramsByFocusArea(String focusArea) {
        programsList = programManager.filterByFocusArea(focusArea);
        System.out.println("Filtered by focus area: " + focusArea);
    }

    @Then("I should see a list of programs focused on {string}")
    public void iShouldSeeAListOfProgramsFocusedOn(String focusArea) {
        Assert.assertTrue("No programs found for focus area: " + focusArea,
                programsList.stream().allMatch(program -> program.get("Focus Area").equals(focusArea)));
        programsList.forEach(program -> System.out.println("Program: " + program.get("Name")));
    }

    @Given("I select a program named {string}")
    public void iSelectAProgramNamed(String programName) {
        selectedProgram = programName;
        programDetails = programManager.getProgramDetails(programName);
        Assert.assertNotNull("Program not found: " + programName, programDetails);
        System.out.println("Selected program: " + programName);
    }


    @When("I click on {string}")
    public void iClickOn(String action) {
        System.out.println("Action performed: " + action);
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String message) {
        Assert.assertEquals("Confirmation message mismatch", "You have successfully enrolled", message);
        System.out.println(message);
    }

    @Then("I should see the schedule for the program {string}")
    public void iShouldSeeTheScheduleForTheProgram(String programName) {
        Assert.assertEquals("Schedule mismatch for program: " + programName,
                programDetails.get("Schedule"), "Monday, Wednesday");
        System.out.println("Schedule: " + programDetails.get("Schedule"));
    }

    @Then("I should see the following program details:")
    public void iShouldSeeTheFollowingProgramDetails(DataTable dataTable) {
        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String field = row.get("Field");
            String expectedValue = row.get("Value");
            String actualValue = programDetails.get(field);

            Assert.assertEquals("Mismatch for field: " + field, expectedValue, actualValue);
            System.out.println(field + ": " + actualValue);
        }
    }


}
