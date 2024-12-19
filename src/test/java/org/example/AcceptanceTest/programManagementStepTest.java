package org.example.AcceptanceTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Main;
import org.example.Program;
import org.example.ProgramService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class programManagementStepTest {
    private List<Program> programList;
    private Map<String, String> programDetails;
    private String title;
    private Program programToUpdate;
    private boolean InstructorLoggedIn;

    private ProgramService programService;
    Main app;
    @Before
    public void setup() {
        // Initialize the ProgramService and the program list
        programService = new ProgramService();
        programList = new ArrayList<>();

        // Add mock data to the programService and programList
        List<Program> testPrograms = new ArrayList<>();
        testPrograms.add(new Program("Get Fit & Moving Challenge", "30 days", "Beginners", "Weight Loss, Full Body", "https://youtu.be/f3zOrYCwquE", "29.99 $"));
        testPrograms.forEach(program -> {
            programService.addProgram(program);
            programList.add(program);
        });

        System.out.println("Mock data added to ProgramService and programList.");
    }

    public programManagementStepTest() {
        app = new Main();

    }

    @Given("the instructor is logged in")
    public void theInstructorIsLoggedIn() {
        InstructorLoggedIn = true;
        System.out.println("the first Scenario\n");
    }

    @When("the following details are provided")
    public void theFollowingDetailsAreProvided(io.cucumber.datatable.DataTable dataTable) {
        programDetails = dataTable.asMap(String.class, String.class);
//        title = programDetails.get("Program title");
//        System.out.println(title);
        if (InstructorLoggedIn) {
            Program program = new Program(
                    programDetails.get("Program title"),
                    programDetails.get("Duration"),
                    programDetails.get("Difficulty level"),
                    programDetails.get("Goals"),
                    programDetails.get("Content"),
                    programDetails.get("Price")
            );
            programList.add(program); // Add the created program to the list
        } else {
            System.out.println("Instructor is not logged in");
        }
//        programService.displayAllPrograms();
    }

    @Then("the program is created with the specified details {string}")
    public void theProgramIsCreatedWithTheSpecifiedDetails(String programTitle) {
        Program program = null;
        for (Program p : programList) {
            if (p.getTitle() != null && p.getTitle().equals(programTitle)) {
                program = p;
                break;
            }
        }
        assertNotNull("The program with title ' " + programTitle + " ' wasn't found!", program);
    }

    @When("a fitness program with the title {string} exists")
    public void aFitnessProgramWithTheTitleExists(String programTitle) {
        System.out.println("the 2nd Scenario\n");

        // Find the program in the list based on the title passed from Gherkin scenario
        programToUpdate = programList.stream()
                .filter(p -> p.getTitle().equals(programTitle))  // Match the title
                .findFirst()   // Get the first program that matches
                .orElse(null); // If no match, programToUpdate will be null

        // Assert that the program is found
        assertNotNull("Program to update was not found in programList!", programToUpdate);
        if (programToUpdate != null) {
            title = programToUpdate.getTitle();  // Store the title of the program
        }
//        programService.displayAllPrograms();
//        boolean exists = programService.searchIfExists(programList, programTitle);
////        System.out.println(programToUpdate);
//       // assertNotNull("Program to update was not found!", exists ? programToUpdate : null);
//        if (exists) {
//            programToUpdate = programList.stream()
//                    .filter(p -> p.getTitle().equals(programTitle))
//                    .findFirst()
//                    .orElse(null);
//            assertNotNull("Program to update was not found in programList!", programToUpdate);
//            title = programToUpdate.getTitle();
//        } else {
//            title = null;
//        }
    }

    @When("the instructor updates the program with the following details")
    public void theInstructorUpdatesTheProgramWithTheFollowingDetails(io.cucumber.datatable.DataTable dataTable) {
        if (programToUpdate != null) {
            programDetails = dataTable.asMap(String.class, String.class);
            // Update the program details
            programToUpdate.setDuration(programDetails.get("Duration"));
            programToUpdate.setDifficultyLevel(programDetails.get("Difficulty level"));
            programToUpdate.setGoals(programDetails.get("Goals"));
            programToUpdate.setContent(programDetails.get("Content"));
            programToUpdate.setPrice(programDetails.get("Price"));
        }
        programService.displayAllPrograms();
    }

    @Then("the program is updated successfully with the new details")
    public void theProgramIsUpdatedSuccessfullyWithTheNewDetails() {
        assertNotNull("Updated program should have Duration", programToUpdate.getDuration());
        assertNotNull("Updated program should have Difficulty Level", programToUpdate.getDifficultyLevel());
        assertNotNull("Updated program should have Goals", programToUpdate.getGoals());
        assertNotNull("Updated program should have Content", programToUpdate.getContent());
        assertNotNull("Updated program should have Price", programToUpdate.getPrice());
    }

    @When("a fitness program with the title {string} doesn't exist")
    public void aFitnessProgramWithTheTitleDoesnTExist(String programTitle) {
        System.out.println("the 3rd Scenario\n");
        title = programTitle;
        // Check that the program does not exist
        boolean exists = programService.searchIfExists(programList, programTitle);
        assertNull("Program should not exist!", exists ? programToUpdate : null);
    }

    @Then("the system displays an error message indicating that the program does not exist")
    public void theSystemDisplaysAnErrorMessageIndicatingThatTheProgramDoesNotExist() {
        assertNull("Program should not exist!", programToUpdate);
        System.out.println("The Program Title: '" + title + "'  Doesn't Exist :)");
    }

    @When("the instructor attempts to delete the program with title {string}")
    public void theInstructorAttemptsToDeleteTheProgramWithTitle(String programTitle) {
        programService.deleteProgram(programTitle);

    }

    @Then("the program deletion result is:")
    public void theProgramDeletionResultIs(DataTable dataTable) {
        // Get expected status and message from DataTable
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        String expectedStatus = rows.get(0).get("Status");
        String expectedMessage = rows.get(0).get("Message");

        // Get actual status and message from programService (assuming methods exist)
        String actualStatus = programService.getDeletionStatus();
        String actualMessage = programService.getDeletionMessage();

        // Assert expected and actual results
        if (expectedStatus.equals("Success")) {
            // Check if program is actually deleted (optional)
            Program deletedProgram = programList.stream()
                    .filter(p -> p.getTitle().equals(title))
                    .findFirst()
                    .orElse(null);
            assertNull("Program should be deleted successfully!", deletedProgram);
        } else {
            // Program deletion failed, check for expected message
        }
        assertEquals(expectedStatus, actualStatus);
        assertEquals(expectedMessage, actualMessage);
    }


//
//    @Given("a fitness program with the title {string} does not exist")
//    public void aFitnessProgramWithTheTitleDoesNotExist(String arg0) {
//    }
//
//    @Then("the system displays an error message indicating that the program does not exist")
//    public void theSystemDisplaysAnErrorMessageIndicatingThatTheProgramDoesNotExist() {
//    }
//
//    @When("the instructor chooses to delete the program")
//    public void theInstructorChoosesToDeleteTheProgram() {
//    }
//
//    @Then("the program is deleted successfully")
//    public void theProgramIsDeletedSuccessfully() {
//    }
//
//
}