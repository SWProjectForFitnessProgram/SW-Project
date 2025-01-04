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
    InstructorRepository instructorRepository = new InstructorRepository();

    ClientRepository clientRepository = new ClientRepository();
    private Admin admin = new Admin(instructorRepository, clientRepository);
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
        Assert.assertFalse(admin.isSignedIn(string));
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
        }
    }
    @Then("the account should be created as pending approval with:")
    public void theAccountShouldBeCreatedAsPendingApprovalWith(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedDetails = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> expected : expectedDetails) {
            String email = expected.get("Email");
            String password = expected.get("Password");
            String name = expected.get("Name");
            String expectedStatus = expected.get("Status");

            Instructor instructor = admin.getInstructorRepository().findInstructorByEmail(email);
            Assert.assertNotNull("Instructor account was not created!", instructor);
            Assert.assertEquals("Password mismatch!", password, instructor.getPassword());
            Assert.assertEquals("Name mismatch!", name, instructor.getName());
            Assert.assertEquals("Status mismatch!", expectedStatus, instructor.getStatus().toString());
        }
    }
    @Then("the system should display the message {string}")
    public void theSystemShouldDisplayTheMessage(String string) {
        Assert.assertEquals("Message mismatch!",signUpMessage, string);
    }


    @Given("a pending instructor account exists with email {string}")
    public void aPendingInstructorAccountExistsWithEmail(String arg0) {
    }

    @When("the admin approves the account for email {string}")
    public void theAdminApprovesTheAccountForEmail(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @Then("the account status should be updated to {string}")
    public void theAccountStatusShouldBeUpdatedTo(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @Then("the instructor should receive an email saying {string}")
    public void theInstructorShouldReceiveAnEmailSaying(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }



    @Given("an account exists with email {string}")
    public void anAccountExistsWithEmail(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }



    @Given("an approved instructor account exists with email {string} and password {string}")
    public void anApprovedInstructorAccountExistsWithEmailAndPassword(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @When("the instructor signs in with:")
    public void theInstructorSignsInWith(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
    }
    @Then("the instructor should be signed in successfully.")
    public void theInstructorShouldBeSignedInSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }


    @Given("an approved client account exists with email {string} and password {string}")
    public void anApprovedClientAccountExistsWithEmailAndPassword(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @When("the client signs in with:")
    public void theClientSignsInWith(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
    }
    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }



    @Given("an admin account exists with email {string} and password {string}")
    public void anAdminAccountExistsWithEmailAndPassword(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
    @When("the admin signs in with:")
    public void theAdminSignsInWith(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
    }
    @Then("the admin should be signed in successfully.")
    public void theAdminShouldBeSignedInSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }


}
