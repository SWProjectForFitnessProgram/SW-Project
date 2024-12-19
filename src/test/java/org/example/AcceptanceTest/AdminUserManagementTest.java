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

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class AdminUserManagementTest {
    private AdminService adminService;
    private List<Instructor> pendingInstructors;
    private String message;
    private Admin admin ;
    private Main app;



    public AdminUserManagementTest(){
        app = new Main();
        admin = new Admin();
        this.adminService = Mockito.mock(AdminService.class);

    }



//------------------------------------------------------------------------------------
    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        Assert.assertTrue(admin.isLoggedIn());
    }

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

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


}
