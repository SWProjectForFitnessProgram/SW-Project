package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Before;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert.*;

public class SigninAndSingupStepTest {
    private Admin admin;
    private String signUpMessage;

   

    @Before
    public void setup() {
        System.out.println("Setting up test...");
        InstructorRepository instructorRepository = new InstructorRepository();
        ClientRepository clientRepository = new ClientRepository();
        admin = new Admin(instructorRepository, clientRepository); // Initialize admin
        System.out.println("Admin initialized: " + admin);
    }


    @Given("no account exists with email {string}")
    public void noAccountExistsWithEmail(String string) {
//        Assert.assertFalse(admin.isSignedIn(string));
    }

    @When("the instructor signs up with:")
    public void theInstructorSignsUpWith(io.cucumber.datatable.DataTable dataTable) {
//        List<Map<String, String>> instructorDetails = dataTable.asMaps(String.class, String.class);
//
//        for (Map<String, String> details : instructorDetails) {
//            String email = details.get("Email");
//            String password = details.get("Password");
//            String name = details.get("Name");
//
//            boolean success = admin.signUpInstructor(email, password, name);
//            if (success) {
//                signUpMessage = "Your account is pending admin approval.";
//            } else {
//                signUpMessage = "Email already exists.";
//            }
        }
    @Then("the account should be created as pending approval with:")
    public void theAccountShouldBeCreatedAsPendingApprovalWith(io.cucumber.datatable.DataTable dataTable) {
//        List<Map<String, String>> expectedDetails = dataTable.asMaps(String.class, String.class);

//        for (Map<String, String> expected : expectedDetails) {
//            String email = expected.get("Email");
//            String password = expected.get("Password");
//            String name = expected.get("Name");
//            String expectedStatus = expected.get("Status");
//
//            Instructor instructor = admin.getInstructorRepository().findInstructorByEmail(email);
//            Assert.assertNotNull("Instructor account was not created!", instructor);
//            Assert.assertEquals("Password mismatch!", password, instructor.getPassword());
//            Assert.assertEquals("Name mismatch!", name, instructor.getName());
//            Assert.assertEquals("Status mismatch!", expectedStatus, instructor.getStatus().toString());
//        }
    }
    @Then("the system should display the message {string}")
    public void theSystemShouldDisplayTheMessage(String string) {
//        Assert.assertEquals("Message mismatch!",signUpMessage, string);
    }


    @Given("a pending instructor account exists with email {string}")
    public void aPendingInstructorAccountExistsWithEmail(String arg0) {
    }
}
