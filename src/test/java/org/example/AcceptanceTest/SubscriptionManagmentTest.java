package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubscriptionManagmentTest {

    private SubscriptionService subscriptionService;
    private Client client;
    private Instructor instructor;

    @Before
    public void setup() {
        subscriptionService = new SubscriptionService();
    }

    //1
    @Given("the client {string} is registered with email {string} and password {string}")
    public void theClientIsRegisteredWithEmailAndPassword(String name, String email, String password) {
        client = new Client(name, email, password);
    }
    //1
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

    //1
    @Then("{string} subscription plan should be {string}")
    public void subscriptionPlanShouldBe(String personName, String expectedPlan) {
        SubscriptionPlan expected = SubscriptionPlan.valueOf(expectedPlan.toUpperCase());
        if (client != null && client.getName().equals(personName)) {
            assertEquals(expected, client.getSubscriptionPlan());
        } else if (instructor != null && instructor.getName().equals(personName)) {
            assertEquals(expected, instructor.getSubscriptionPlan());
        }

    }

    //2
    @Given("the instructor {string} is registered with email {string} and password {string}")
    public void theInstructorIsRegisteredWithEmailAndPassword(String instructorName, String email, String password) {
     instructor = new Instructor( email, password,instructorName);
    }
    //3
    @Given("the client {string} has a {string} subscription And He registered with email {string} and password {string}")
    public void theClientHasASubscriptionAndHeRegisteredWithEmailAndPassword(String name, String subscriptionPlan, String email, String password) {
        client = new Client(name);
        SubscriptionPlan plan = SubscriptionPlan.valueOf(subscriptionPlan.toUpperCase());
        client.setSubscriptionPlan(plan);
    }//3
    @When("I change {string}'s subscription to {string}")
    public void iChangeSSubscriptionTo(String name, String newPlan) {
        SubscriptionPlan plan = SubscriptionPlan.valueOf(newPlan.toUpperCase());
        if (client != null && client.getName().equals(name)) {
            subscriptionService.changeSubscription(client, plan);
        } else if (instructor != null && instructor.getName().equals(name)) {
            subscriptionService.changeSubscription(instructor, plan);
        }
    }//3
    @Then("{string}'s subscription plan should be {string}")
    public void sSubscriptionPlanShouldBe(String name, String newPlan) {
        SubscriptionPlan expected = SubscriptionPlan.valueOf(newPlan.toUpperCase());
        if (client != null && client.getName().equals(name)) {
            assertEquals(expected, client.getSubscriptionPlan());
        } else if (instructor != null && instructor.getName().equals(name   )) {
            assertEquals(expected, instructor.getSubscriptionPlan());
        }
    }


    @When("I view the available subscription plans")
    public void iViewTheAvailableSubscriptionPlans() {
        
    }

    @Then("I should see {string} and {string} plans listed")
    public void iShouldSeeAndPlansListed(String plan1, String plan2) {
        assertTrue(subscriptionService.getAvailablePlans().contains(SubscriptionPlan.valueOf(plan1.toUpperCase())));
        assertTrue(subscriptionService.getAvailablePlans().contains(SubscriptionPlan.valueOf(plan2.toUpperCase())));
    }
}
