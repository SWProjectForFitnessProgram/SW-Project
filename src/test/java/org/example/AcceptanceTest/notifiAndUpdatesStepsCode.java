package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Client;
import org.example.Instructor;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class notifiAndUpdatesStepsCode {
    private Instructor instructor;
    private Map<String, Client> clients;
    private Map<String, String> notifications;
    private Set<String> eligibleClients;

    @Before
    public void setUp()
    {
        if(instructor == null)
        {
        instructor = new Instructor("Haya", "Haya@email.com", 27);
        assertNotNull(instructor); // Check if instructor is created
        clients = new HashMap<>();
        notifications = new HashMap<>();
        eligibleClients = new HashSet<>();

        clients.put("Alice", new Client("Alice", "Fitness Program"));
        clients.put("Bob", new Client("Bob", "Fitness Program"));
        clients.put("Charlie", new Client("Charlie", "Fitness Program"));


        // Create client data as a List of HashMaps

//        List<Map<String, String>> clientDataList = new ArrayList<>();

//        Map<String, String> aliceData = new HashMap<>();
//        aliceData.put("Name", "Alice");
//        aliceData.put("Workouts Completed", "7");
//        aliceData.put("Total Workouts", "10");
//        aliceData.put("Sessions Attended", "0");
//        aliceData.put("Total Sessions", "0");
//        clientDataList.add(aliceData);
//
//        Map<String, String> bobData = new HashMap<>();
//        bobData.put("Name", "Bob");
//        bobData.put("Workouts Completed", "0");
//        bobData.put("Total Workouts", "0");
//        bobData.put("Sessions Attended", "8");
//        bobData.put("Total Sessions", "12");
//        clientDataList.add(bobData);
//
//        Map<String, String> charlieData = new HashMap<>();
//        charlieData.put("Name", "Charlie");
//        charlieData.put("Workouts Completed", "3");
//        charlieData.put("Total Workouts", "10");
//        charlieData.put("Sessions Attended", "0");
//        charlieData.put("Total Sessions", "0");
//        clientDataList.add(charlieData);
//
//        // Populate the clients map
//        for (Map<String, String> clientData : clientDataList) {
//            String clientName = clientData.get("Name");
//            int workoutsCompleted = Integer.parseInt(clientData.get("Workouts Completed"));
//            int totalWorkouts = Integer.parseInt(clientData.get("Total Workouts"));
//            int sessionsAttended = Integer.parseInt(clientData.get("Sessions Attended"));
//            int totalSessions = Integer.parseInt(clientData.get("Total Sessions"));
//
//            Client client = new Client(clientName, "Fitness Program");
//            client.setWorkoutsCompleted(workoutsCompleted, totalWorkouts);
//            client.setSessionsAttended(sessionsAttended, totalSessions);
//            clients.put(clientName, client);
        }

        }

    @And("the instructor has an active program {string} with enrolled clients {string}, {string}, and {string}")
    public void theInstructorHasAnActiveProgramWithEnrolledClientsAnd(String programName, String firstClient, String secondClient, String thirdClient) {
        instructor.addProgram(programName, Arrays.asList(firstClient, secondClient, thirdClient));
        assertTrue(clients.containsKey(firstClient));
        assertTrue(clients.containsKey(secondClient));
        assertTrue(clients.containsKey(thirdClient));

    }

    @When("the instructor changes the {string} schedule from {string} to {string}")
    public void theInstructorChangesTheScheduleFromTo(String programName, String oldSchedule, String newSchedule) {

    }

    @Then("{string} should receive a notification: {string}")
    public void shouldReceiveANotification(String arg0, String arg1) {
    }

    @When("the instructor cancels the {string} session on {string}")
    public void theInstructorCancelsTheSessionOn(String arg0, String arg1) {
    }

    @When("the instructor announces a new program {string} starting on {string}")
    public void theInstructorAnnouncesANewProgramStartingOn(String arg0, String arg1) {
    }

    @When("the instructor announces a special offer: {string}")
    public void theInstructorAnnouncesASpecialOffer(String arg0) {
    }

    @Given("the instructor has a list of clients who are eligible for the offer")
    public void theInstructorHasAListOfClientsWhoAreEligibleForTheOffer() {
    }

    @And("the clients {string} and {string} are in the list")
    public void theClientsAndAreInTheList(String arg0, String arg1) {
    }

    @When("the instructor announces a special offer: {string} to the eligible clients")
    public void theInstructorAnnouncesASpecialOfferToTheEligibleClients(String arg0) {
    }

    @And("{string} should not receive a notification")
    public void shouldNotReceiveANotification(String arg0) {
    }
}
