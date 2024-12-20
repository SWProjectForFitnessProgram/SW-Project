package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class progressTrackingStepsCode {
    @Given("{string} has completed {int} out of {int} workouts in {string}")
    public void hasCompletedOutOfWorkoutsIn(String arg0, int arg1, int arg2, String arg3) {
    }

    @When("the instructor views {string}'s progress report")
    public void theInstructorViewsSProgressReport(String arg0) {
    }

    @Then("the instructor should see {string}'s completion rate as {int}%")
    public void theInstructorShouldSeeSCompletionRateAs(String arg0, int arg1) {
    }

    @Given("{string} has attended {int} out of {int} sessions of {string}")
    public void hasAttendedOutOfSessionsOf(String arg0, int arg1, int arg2, String arg3) {
    }

    @Then("the instructor should see {string}'s attendance as {double}%")
    public void theInstructorShouldSeeSAttendanceAs(String arg0, int arg1, int arg2) {
    }

    @Given("{string} has completed only {int} out of {int} workouts in {string}")
    public void hasCompletedOnlyOutOfWorkoutsIn(String arg0, int arg1, int arg2, String arg3) {
    }

    @When("the instructor sends a motivational reminder to {string}")
    public void theInstructorSendsAMotivationalReminderTo(String arg0) {
    }

    @Then("{string} should receive the message {string}")
    public void shouldReceiveTheMessage(String arg0, String arg1) {
    }
}
