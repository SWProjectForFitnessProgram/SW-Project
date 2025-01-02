package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.BeforeClass;

import static org.example.UserStatus.Pending;

public class SubscriptionManagmentTest {
    private User user;
    private User.SubscriptionPlan subscriptionPlan;
    private SubscriptionService subscriptionService = new SubscriptionService();

    @BeforeClass
    public void setup() {
//
//        contentService = new Admin();
    }



    @Given("the client {string} is registered")
    public void theClientIsRegistered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I assign the {string} subscription plan to Alice")
    public void iAssignTheSubscriptionPlanToAlice(String planName) {
        if (planName.equals("Basic")) {
            subscriptionPlan = User.SubscriptionPlan.BASIC;
        } else if (planName.equals("Premium")) {
            subscriptionPlan = User.SubscriptionPlan.PREMIUM;
        }
        user.setSubscription(subscriptionPlan);
    }
    @Then("Alice's subscription plan should be {string}")
    public void aliceSSubscriptionPlanShouldBe(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("the instructor {string} is registered")
    public void theInstructorIsRegistered(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I assign the {string} subscription plan to Bob")
    public void iAssignTheSubscriptionPlanToBob(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Bob's subscription plan should be {string}")
    public void bobSSubscriptionPlanShouldBe(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the client {string} has a {string} subscription")
    public void theClientHasASubscription(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I change Charlie's subscription to {string}")
    public void iChangeCharlieSSubscriptionTo(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Charlie's subscription plan should be {string}")
    public void charlieSSubscriptionPlanShouldBe(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I view the available subscription plans")
    public void iViewTheAvailableSubscriptionPlans() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should see {string} and {string} plans listed")
    public void iShouldSeeAndPlansListed(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }






}
