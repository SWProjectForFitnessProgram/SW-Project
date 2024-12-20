package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Client;
import org.example.Instructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class progressTrackingStepsCode {
    private Instructor instructor;
    private Map<String, Client> clients;
    private String displayedMessage; // For messages displayed to the instructor
    private String receivedMessage; // For messages received by clients

    @Before
    public void setUp()
    {
        instructor = new Instructor("Test Instructor", "test@email.com", 30);
        assertNotNull(instructor); // Check if instructor is created
        clients = new HashMap<>();

        // Create client data as a List of HashMaps

        List<Map<String, String>> clientDataList = new ArrayList<>();

        Map<String, String> aliceData = new HashMap<>();
        aliceData.put("Name", "Alice");
        aliceData.put("Workouts Completed", "7");
        aliceData.put("Total Workouts", "10");
        aliceData.put("Sessions Attended", "0");
        aliceData.put("Total Sessions", "0");
        clientDataList.add(aliceData);

        Map<String, String> bobData = new HashMap<>();
        bobData.put("Name", "Bob");
        bobData.put("Workouts Completed", "0");
        bobData.put("Total Workouts", "0");
        bobData.put("Sessions Attended", "8");
        bobData.put("Total Sessions", "12");
        clientDataList.add(bobData);

        Map<String, String> charlieData = new HashMap<>();
        charlieData.put("Name", "Charlie");
        charlieData.put("Workouts Completed", "3");
        charlieData.put("Total Workouts", "10");
        charlieData.put("Sessions Attended", "0");
        charlieData.put("Total Sessions", "0");
        clientDataList.add(charlieData);

        // Populate the clients map
        for (Map<String, String> clientData : clientDataList) {
            String clientName = clientData.get("Name");
            int workoutsCompleted = Integer.parseInt(clientData.get("Workouts Completed"));
            int totalWorkouts = Integer.parseInt(clientData.get("Total Workouts"));
            int sessionsAttended = Integer.parseInt(clientData.get("Sessions Attended"));
            int totalSessions = Integer.parseInt(clientData.get("Total Sessions"));

            Client client = new Client(clientName, "Fitness Program");
            client.setWorkoutsCompleted(workoutsCompleted, totalWorkouts);
            client.setSessionsAttended(sessionsAttended,totalSessions);
            clients.put(clientName, client);
        }
    }
    @Given("{string} has completed {int} out of {int} workouts in {string}")
    public void hasCompletedOutOfWorkoutsIn(String clientName, int doneWorkouts, int allWorkouts, String programName) {
        Client client = new Client(clientName, programName);
        client.setWorkoutsCompleted(doneWorkouts, allWorkouts);
        clients.put(clientName, client);
    }

    @When("the instructor views {string}'s progress report")
    public void theInstructorViewsSProgressReport(String clientName) {
        Client client = clients.get(clientName);
        if (client != null) {
            // In a real application, you would fetch the data. Here, we use the stored data.
            //For now, this is empty as the then steps do the work.
        } else {
            displayedMessage = "Client " + clientName + " is not enrolled in this program.";
        }
    }

    @Then("the instructor should see {string}'s completion rate as {double}%")
    public void theInstructorShouldSeeSCompletionRateAs(String clientName, double expectedRate) {
        Client client = clients.get(clientName);
        double actualRate = client.getCompletionRate();
        System.out.println("The Expected Rate in Completion rate for " + clientName + " is " + expectedRate + "%");
        System.out.println("The Actual Rate in Completion rate for " + clientName + " is " + actualRate + "%");

        assertEquals(expectedRate, actualRate, 0.01); // Delta for double comparison
    }

    @Given("{string} has attended {int} out of {int} sessions of {string}")
    public void hasAttendedOutOfSessionsOf(String clientName, int attended, int total, String programName) {
        Client client = new Client(clientName, programName);
        client.setSessionsAttended(attended, total);
        clients.put(clientName, client);
    }

    @Then("the instructor should see {string}'s attendance as {double} %")
    public void theInstructorShouldSeeSAttendanceAs(String clientName, double expectedAttendance) {
        Client client = clients.get(clientName);
        double actualAttendance = client.getAttendanceRate();
        System.out.println("The Expected Rate in Attendance rate for " + clientName + " is " + expectedAttendance +"%");
        System.out.println("The Actual Rate in Attendance rate for " + clientName + " is " + actualAttendance+"%");
        assertEquals(expectedAttendance, actualAttendance, 0.01);
    }

    @When("the instructor sends a motivational reminder to {string}")
    public void theInstructorSendsAMotivationalReminderTo(String clientName) {
        Client client = clients.get(clientName);
        if (client != null) {
            String messag = "Keep pushing, Charlie! You've got this!"; // Hardcoded for this scenario
            client.setReceivedMessage(messag);
            receivedMessage = messag;
        }
    }

    @Then("{string} should receive the message {string}")
    public void shouldReceiveTheMessage(String clientName, String expectedMessage) {
        Client client = clients.get(clientName);
        assertEquals(expectedMessage, client.getReceivedMessage());
        System.out.println(client.getReceivedMessage());

    }

}
