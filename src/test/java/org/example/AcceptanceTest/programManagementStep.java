package org.example.AcceptanceTest;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class programManagementStep {
    private static List<Program> programList;
    private static ProgramService programService;
    private static boolean isSetUpDone = false; // flag;
    private Map<String, String> programDetails;
    private String title;
    private Program programToUpdate;
    private boolean InstructorLoggedIn;

    @Before
    public static void setup()
    {
        // Initialize the ProgramService and the program list ""once"" before all tests in this class
        if(!isSetUpDone)
        {
            isSetUpDone = true;
            programService = new ProgramService();
            programList = new ArrayList<>();

            // Add mock data to the programService and programList
            // Create Resources first
            Content mockResources = new Content("https://youtu.be/f3zOrYCwquE", "https://unsplash.com/s/photos/gym", "https://www.everydayhealth.com/fitness/guide/");
            Schedule mockSchedule = new Schedule(new String[]{"Sunday", "Tuesday", "Thursday"}, "5:00 Pm - 7:00 Pm", "Online");

            Program mockProgram = new Program(
                    "Get Fit & Moving Challenge",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "29.99 $"
            );
            programList.add(mockProgram);
            programService.addProgram(mockProgram);
            Client client;
            client = new Client("Alice", "alice@example.com", 25);
            Instructor instructor = new Instructor("John Doe", "johndoe@example.com", 30);
            mockProgram.enrollClient(client);
            instructor.addnewProgram(mockProgram);
            client.enrollProgram(mockProgram);
            System.out.println("Set Up is completed for the mock data");

            mockProgram.getSchedule().setScheduleType("Full");
            mockProgram.getSchedule().setTime("5:00 pm - 7:00 pm");
            mockProgram.getSchedule().setDays(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
            mockProgram.getSchedule().getDays();

        }
}


    public programManagementStep() {

    }

    @Given("the instructor is logged in")
    public void theInstructorIsLoggedIn() {
        InstructorLoggedIn = true;
        System.out.println("The instructor is logged in for all Scenarios\n");
    }

    @When("the following details are provided")
    public void theFollowingDetailsAreProvided(io.cucumber.datatable.DataTable dataTable) {
        programDetails = dataTable.asMap(String.class, String.class);
        if (InstructorLoggedIn) {
            Content content = new Content(
                    programDetails.get("Images"),
                    programDetails.get("Documentation"),
                    programDetails.get("Video Tutorials")
            );

            Schedule schedule = new Schedule(
                    programDetails.get("Days").split(","), // days are comma-separated
                    programDetails.get("Time"),
                    programDetails.get("Schedule Type")
            );

            Program program = new Program(
                    programDetails.get("Program title"),
                    programDetails.get("Duration"),
                    programDetails.get("Difficulty level"),
                    programDetails.get("Goals"),
                    content,
                    schedule,
                    programDetails.get("Price")
            );
            programList.add(program);
            programService.addProgram(program);

            System.out.println("Program created successfully: " + program.getTitle());

        } else {
            System.out.println("Instructor is not logged in");
        }
        programService.displayAllPrograms();
    }

    @Then("the program is created with the specified details {string}")
    public void theProgramIsCreatedWithTheSpecifiedDetails(String programTitle) {
        Program program = programService.findProgramByTitle(programTitle);
        assertNotNull("The program with title ' " + programTitle + " ' wasn't found!", program);

        assertEquals("The program title doesn't match.", programTitle, program.getTitle());
        System.out.println("Program verified successfully: " + program.getTitle());
    }

    @When("a fitness program with the title {string} exists")
    public void aFitnessProgramWithTheTitleExists(String programTitle) {
        programToUpdate = programService.findProgramByTitle(programTitle);
        assertNotNull("Program to update was not found!", programToUpdate);
        title = programToUpdate.getTitle();

    }

    @When("the instructor updates the program with the following details")
    public void theInstructorUpdatesTheProgramWithTheFollowingDetails(io.cucumber.datatable.DataTable dataTable) {
        programDetails = dataTable.asMap(String.class, String.class);
        if (programToUpdate != null) {
            // Update Resources
            Content updatedContent = new Content(
                    programDetails.get("Images"),
                    programDetails.get("Documentation"),
                    programDetails.get("Video Tutorials")
            );

            Schedule updatedSchedule = new Schedule(
                    programDetails.get("Days").split(","),
                    programDetails.get("Time"),
                    programDetails.get("Schedule Type")
            );
            programToUpdate.setProgramTitle(programDetails.get("Program title"));
            programToUpdate.setDuration(programDetails.get("Duration"));
            programToUpdate.setDifficultyLevel(programDetails.get("Difficulty level"));
            programToUpdate.setGoals(programDetails.get("Goals"));
            programToUpdate.setContent(updatedContent);
            programToUpdate.setSchedule(updatedSchedule);
            programToUpdate.setPrice(programDetails.get("Price"));

            programService.updateProgram(programToUpdate);
//            programService.displayAllPrograms();
        }
    }

    @Then("the program is updated successfully with the new details")
    public void theProgramIsUpdatedSuccessfullyWithTheNewDetails() {
        assertNotNull("Updated program should exist", programToUpdate);

        assertEquals("The program title wasn't updated.", programDetails.get("Program title"), programToUpdate.getTitle());
        assertEquals("The schedule type wasn't updated.", programDetails.get("Schedule Type"), programToUpdate.getSchedule().getScheduleType());
        System.out.println("Program updated successfully: " + programToUpdate.getTitle());
    }

    @When("a fitness program with the title {string} doesn't exist")
    public void aFitnessProgramWithTheTitleDoesnTExist(String programTitle) {
        System.out.println("the 3rd Scenario\n");
        title = programTitle;

        programToUpdate = programService.findProgramByTitle(programTitle);
        assertNull("Program should not exist!", programToUpdate);
    }
    @Then("the system displays an error message indicating that the program does not exist")
    public void theSystemDisplaysAnErrorMessageIndicatingThatTheProgramDoesNotExist() {
        assertNull("Program should not exist!", programToUpdate);
        System.out.println("The Program Title: '" + title + "'  Doesn't Exist! ");
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

        // Get actual status and message from programService
        String actualStatus = programService.getDeletionStatus();
        String actualMessage = programService.getDeletionMessage();

        // Assert expected and actual results
        if (expectedStatus.equals("Success")) {

            Program deletedProgram = programList.stream()
                    .filter(p -> p.getTitle().equals(title))
                    .findFirst()
                    .orElse(null);
            assertNull("Program should be deleted successfully!", deletedProgram);
            System.out.println(actualMessage);
        } else {
            System.out.println(actualMessage);
        }
        assertEquals(expectedStatus, actualStatus);
        assertEquals(expectedMessage, actualMessage);
    }


}