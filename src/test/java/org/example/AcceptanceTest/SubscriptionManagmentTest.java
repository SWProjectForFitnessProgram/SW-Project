package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.BeforeClass;

import static org.example.UserStatus.Pending;
import static org.junit.Assert.assertEquals;

public class SubscriptionManagmentTest {
    private SubscriptionService subscriptionService;
    private Client client;
    private Instructor instructor;

    @Before
    public void setup() {
        subscriptionService = new SubscriptionService();
    }


    @Given("the client {string} is registered with email {string} and password {string}")
    public void theClientIsRegisteredWithEmailAndPassword(String name, String email, String password) {
        client = new Client(name, email, password);
    }

    @When("I assign the {string} subscription plan to {string}")
    public void iAssignTheSubscriptionPlanTo(String subscriptionPlan, String personName) {
        SubscriptionPlan plan = SubscriptionPlan.valueOf(subscriptionPlan.toUpperCase());
        if(client != null && client.getName().equals(personName)) {
            subscriptionService.assignSubscription(client, plan);
        }
        else if (instructor != null && instructor.getName().equals(personName)) {
            subscriptionService.assignSubscription(instructor, plan);
        }
    }


    @Then("{string} subscription plan should be {string}")
    public void subscriptionPlanShouldBe(String personName, String expectedPlan) {
        SubscriptionPlan expected = SubscriptionPlan.valueOf(expectedPlan.toUpperCase());
        if (client != null && client.getName().equals(personName)) {
            assertEquals(expected, client.getSubscriptionPlan());
        } else if (instructor != null && instructor.getName().equals(personName)) {
            assertEquals(expected, instructor.getSubscriptionPlan());
        }

    }


    @Given("the instructor {string} is registered with email {string} and password {string}")
    public void theInstructorIsRegisteredWithEmailAndPassword(String instructorName, String arg1, String arg2) {
    }
}
