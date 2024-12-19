package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.AdminService;
import org.example.Instructor;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class AdminUserManagementTest {
    private String message;
    @MockBean
    private AdminService adminService;

    private Admin admin;

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        // Simulate admin login logic (replace with actual logic in a real-world scenario)
        // For this test, we'll assume the admin is already logged in
        admin = new Admin();
        // ... (Logic to simulate successful login)
    }

    @Given("there are pending instructor accounts:")
    public void pendingInstructorAccounts(List<Map<String, String>> instructorsTable) {
        List<Instructor> pendingInstructors = new ArrayList<>();
        for (Map<String, String> row : instructorsTable) {
            pendingInstructors.add(new Instructor(row.get("email"), row.get("name")));
        }
        Mockito.when(adminService.getPendingInstructors()).thenReturn(pendingInstructors);
    }

    @Given("there are no pending instructor accounts")
    public void noPendingInstructorAccounts() {
        Mockito.when(adminService.getPendingInstructors()).thenReturn(Collections.emptyList());
    }

    @When("I click on \"Approve Instructors\" page")
    public void iClickedOnPage() {
        List<Instructor> fetchedInstructors = adminService.getPendingInstructors();
        if (fetchedInstructors.isEmpty()) {
            message = "No pending instructor accounts";
        } else {
            // Handle the case where there are pending instructors
            // (e.g., display them in a UI)
        }
    }

    @Then("I should see a list of pending instructor accounts:")
    public void iShouldSeeAListOfPendingInstructorAccounts(List<Map<String, String>> expectedInstructorsTable) {
        // ... (Logic to verify the displayed list of pending instructors)
    }

    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String expectedMessage) {
        String actualMessage = admin.getDisplayedMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}