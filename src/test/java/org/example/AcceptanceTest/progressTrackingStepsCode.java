package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Client;
import org.example.Instructor;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class progressTrackingStepsCode {
    private Instructor instructor;
    private Map<String, Client> clients;
    private String displayedMessage; // For messages displayed to the instructor
    private String receivedMessage; // For messages received by clients
    @Given("the instructor is logged in")
    public void theInstructorIsLoggedIn() {
        instructor = new Instructor("Test Instructor", "test@email.com", 30); // Example instructor
        assertNotNull(instructor); // Check if instructor is created
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

    @Then("the instructor should see {string}'s completion rate as {int}%")
    public void theInstructorShouldSeeSCompletionRateAs(String clientName, int expectedRate) {
        Client client = clients.get(clientName);
        double actualRate = client.getCompletionRate();
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
        assertEquals(expectedAttendance, actualAttendance, 0.01);
    }

    @When("the instructor sends a motivational reminder to {string}")
    public void theInstructorSendsAMotivationalReminderTo(String clientName) {
        Client client = clients.get(clientName);
        if (client != null) {
            String messag = "Keep pushing, Charlie! You've got this!"; // Hardcoded for this scenario
            client.receiveMessage(messag);
            receivedMessage = messag;
        }
    }

    @Then("{string} should receive the message {string}")
    public void shouldReceiveTheMessage(String clientName, String expectedMessage) {
        Client client = clients.get(clientName);
        assertEquals(expectedMessage, client.getReceivedMessage());
    }

}
