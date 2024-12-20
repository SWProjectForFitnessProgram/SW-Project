package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.Main;

public class ProgramMonitoring {
    private Admin admin ;
    private Main app;
    public ProgramMonitoring() {
        admin = new Admin();
        app = new Main();
    }


    @Given("the admin has selected the {string} option")
    public void theAdminHasSelectedTheOption(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the admin views most popular programs")
    public void theAdminViewsMostPopularPrograms() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the system should display a list of programs ordered by enrollment")
    public void theSystemShouldDisplayAListOfProgramsOrderedByEnrollment() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
