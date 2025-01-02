package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import static org.example.UserStatus.Pending;
import static org.junit.Assert.assertTrue;

public class AdminUserManagementTest {


    private static List<Instructor> pendingInstructors;
    private String message;
    private static Admin admin;
    private static Main app;


    @BeforeClass
    public static void setup() {
        InstructorRepository instructorRepository = new InstructorRepository();
        ClientRepository clientRepository = new ClientRepository();
        admin = new Admin(instructorRepository, clientRepository);
        app = new Main();
        pendingInstructors = new ArrayList<>();
    }

    //------------------------------------------------------------------------------------
    //1
    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        admin.approveAdminLogin();
        assertTrue(admin.isLoggedIn());
    }

    //1
    @Given("there are pending instructor accounts:")
    public void pendingInstructorAccounts(List<Map<String, String>> instructorsTable) {
        for (Map<String, String> row : instructorsTable) {
            Instructor instructor = new Instructor(row.get("email"), row.get("password") , Pending);
            admin.getInstructorRepository().add(instructor); //add to the repository
            pendingInstructors.add(instructor);
        }
//        pendingInstructors = admin.getPendingInstructors();
        Assert.assertFalse("There should be pending instructors", pendingInstructors.isEmpty());
    }

    //1
    @Given("there are no pending instructor accounts")
    public void noPendingInstructorAccounts() {
        assertTrue("There is pending Instructor accounts",admin.getPendingInstructors().isEmpty());
    }

    @When("I click on {string} page")
    public void iClickedOnPage(String arg0) {
        List<Instructor> fetchedInstructors = admin.getPendingInstructors();
        if (fetchedInstructors.isEmpty()) {
            message = "No pending instructor accounts";
        } else {
            pendingInstructors = fetchedInstructors;
        }

    }

    @Then("I should see a list of pending instructor accounts:")
    public void iShouldSeeAListOfPendingInstructorAccounts(List<Map<String, String>> expectedInstructorsTable) {
        Assert.assertNotNull(pendingInstructors);
        Assert.assertEquals(expectedInstructorsTable.size(), pendingInstructors.size());
    }


    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String expectedMessage) {

        String actualMessage = admin.getDisplayedMessage();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the admin chooses {string}")
    public void theAdminChooses(String arg0) {
//        if (arg0.equals("Approve Clients")) {
//
//        }
    }

    @Then("a queue of client accounts that signed up and need approval should be displayed")
    public void aQueueOfClientAccountsThatSignedUpAndNeedApprovalShouldBeDisplayed() {

    }

    @Given("the admin has selected the {string} option")
    public void theAdminHasSelectedTheOption(String arg0) {

    }

    @When("the admin views activity reports")
    public void theAdminViewsActivityReports() {

    }

    @Then("the system should display statistics including:")
    public void theSystemShouldDisplayStatisticsIncluding() {

    }

    @When("the admin views the instructor engagement report")
    public void theAdminViewsTheInstructorEngagementReport() {

    }

    @When("the admin views the client engagement report")
    public void theAdminViewsTheClientEngagementReport() {
    }
}

