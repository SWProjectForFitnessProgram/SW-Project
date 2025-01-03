package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.Before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SigninAndSingupStepTest {
    private static Main app;
    private static Admin admin;
    private static InstructorRepository instructorRepository;
    private static ClientRepository clientRepository;
    private static String signUpMessage;
    private String emailMessage;

    @Before
    public void setup() {
        signUpMessage = "";
        instructorRepository = new InstructorRepository();
        clientRepository = new ClientRepository();
        admin = new Admin(instructorRepository, clientRepository);
        app = new Main();
//        admin.approveAdminLogin();
//        assertTrue(admin.isLoggedIn());
    }


    @Given("no account exists with email {string}")
    public void noAccountExistsWithEmail(String string) {
        assertFalse(admin.isSignedIn(string));
    }

    @When("the instructor signs up with:")
    public void theInstructorSignsUpWith(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> instructorDetails = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> details : instructorDetails) {
            String email = details.get("Email");
            String password = details.get("Password");
            String name = details.get("Name");

            boolean success = admin.signUpInstructor(email, password, name);
            if (success) {
                signUpMessage = "Your account is pending admin approval.";
            } else {
                signUpMessage = "Email already exists.";
            }
        }}
    @Then("the account should be created as pending approval with:")
    public void theAccountShouldBeCreatedAsPendingApprovalWith(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedDetails = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> expected : expectedDetails) {
            String email = expected.get("Email");
            String password = expected.get("Password");
            String name = expected.get("Name");
            String expectedStatus = expected.get("Status");

            Instructor instructor = admin.getInstructorRepository().findInstructorByEmail(email);
            assertNotNull("Instructor account was not created!", instructor);
            assertEquals("Password mismatch!", password, instructor.getPassword());
            assertEquals("Name mismatch!", name, instructor.getName());
            assertEquals("Status mismatch!", expectedStatus, instructor.getStatus().toString());
        }
    }
    @Then("the system should display the message {string}")
    public void theSystemShouldDisplayTheMessage(String string) {
        assertEquals("Message mismatch!",signUpMessage, string);
    }




}
