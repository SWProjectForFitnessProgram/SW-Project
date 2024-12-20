package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.AdminService;
import org.example.Instructor;
import org.example.Main;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(MockitoJUnitRunner.class) // For JUnit 4

//@SpringBootTest
//@SpringJUnitConfig
public class AdminUserManagementTest {


    private List<Instructor> pendingInstructors;
    private String message;
    private Admin admin ;
    private Main app;

    @Mock
    private AdminService adminService;

    public AdminUserManagementTest(){
        app = new Main();
        admin = new Admin();
        this.adminService = Mockito.mock(AdminService.class);

    }



//------------------------------------------------------------------------------------
    //1
    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        Assert.assertTrue(admin.isLoggedIn());
    }
//1
    @Given("there are pending instructor accounts:")
    public void pendingInstructorAccounts(List<Map<String, String>> instructorsTable) {
        pendingInstructors = new ArrayList<>();
        for (Map<String, String> row : instructorsTable) {
            pendingInstructors.add(new Instructor(row.get("email"), row.get("password")));
        }
//Mockito.when(...) tells Mockito that we are defining the behavior for this specific method call.
        Mockito.when(adminService.getPendingInstructors()).thenReturn(pendingInstructors);
//        This line tells Mockito: "Whenever the getPendingInstructors() method is called on the
//         mocked adminService object, return the list of pendingInstructors that we have prepared."
    }

//2
    @Given("there are no pending instructor accounts")
    public void noPendingInstructorAccounts() {
        Mockito.when(adminService.getPendingInstructors()).thenReturn(new ArrayList<>());
    }

    @When("I click on {string} page")
    public void iClickedOnPage(String arg0) {
        List<Instructor> fetchedInstructors = adminService.getPendingInstructors();
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
        // Replace this with the actual logic to retrieve the displayed message
        // This might involve interacting with the UI (e.g., getting text from a web element)
        String actualMessage = admin.getDisplayedMessage();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the admin chooses {string}")
    public void theAdminChooses(String arg0) {
        if(arg0.equals("Approve Clients")){

        }
    }

    @Then("a queue of client accounts that signed up and need approval should be displayed")
    public void aQueueOfClientAccountsThatSignedUpAndNeedApprovalShouldBeDisplayed() {

    }
//    //3
//    @Given("the admin has selected the {string} option")
//    public void theAdminHasSelectedTheOption(String arg0) {
//        Assert.assertTrue(admin.monitorUserActivity);
//    }
//
//    @When("the admin views the instructor engagement report")
//    public void theAdminViewsTheInstructorEngagementReport() {
//        Mockito.when(adminService.getUserActivityReport()).thenReturn(createSampleUserActivityReport());
//
//    }
//
//    @Then("the system should display statistics including:")
//    public void theSystemShouldDisplayStatisticsIncluding() {
//    }
}
