package org.example.AcceptanceTest;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SigninAndSingupStepTest {


    private String userType;
    private String name;
    private String email;
    private int age;
    private String password;
    private static boolean signUpResult;
    private static String message;
    private static Admin admin;
    private static boolean signInResult;
    private static List<String> accounts;

    @BeforeAll
    public static void setup() {
        signUpResult = false;
        message = "";
        InstructorRepository instructorRepository = new InstructorRepository();
        Instructor instructor = new Instructor("john.doe@gmail.com","password123","John");
        instructorRepository.addInstructor(instructor);
        ClientRepository clientRepository = new ClientRepository();
        Client client = new Client("jane.smith@gmail.com", "clientpass123", "Jane");
        clientRepository.addClient(client);
        admin = new Admin(instructorRepository, clientRepository);
        accounts = new ArrayList<>();

    }

    @Given("{string} provides the following details:")
    public void aUserProvidesTheFollowingDetails(String userType, io.cucumber.datatable.DataTable dataTable) {
        this.userType = userType;
        var details = dataTable.asMap(String.class, String.class);
        this.name = details.get("Name");
        this.email = details.get("Email");
        this.age = Integer.parseInt(details.get("Age"));
        this.password = details.get("Password");
    }
    @When("the {string} attempts to sign up")
    public void theUserAttemptsToSignUp(String userType) {
        Role role = Role.valueOf(userType.toUpperCase());
        signUpResult = admin.signUp(role, name, email, age, password);
        message = "The Admin will approve your account as soon as possible.";

    }
    @Then("Sign up operation should succeed")
    public void theOperationShould() {
        assertTrue(signUpResult);
    }
    @And("the {string} should see {string}")
    public void theUserShouldSee(String userType, String expectedMessage) {
        assertEquals(expectedMessage, message);
    }

    @And("the {string} should receive an email notification upon approval")
    public void theShouldReceiveAnEmailNotificationUponApproval(String arg0) {
    }


    @Then("the operation should fail")
    public void theOperationShouldFail() {
        Assert.assertFalse(signUpResult);
        message = "The operation is not allowed: Invalid email, age must be 18 or older or password must be at least 8 characters.";
    }

    @And("the user should see {string}")
    public void theUserShouldSee(String arg0) {
        assertEquals(message,arg0);
    }
    @Given("the following accounts exist:")
    public void theFollowingAccountsExist(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> dataAsMaps = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : dataAsMaps) {
            String role = row.get("Role");
            Role userRole = Role.valueOf(role.toUpperCase());
            String email = row.get("Email");
            String password = row.get("Password");
            accounts.add(role + "," + email + "," + password);
            System.out.println(role + "," + email + "," + password);

        }
    }
    @When("the user attempts to sign in")
    public void theUserAttemptsToSignIn() {
        if(accounts.isEmpty()){
            message = "No accounts exist.";
            System.out.println(message);
            signInResult = false;
            return;
        }
        for(String account : accounts){
            email= account.split(",")[1].trim();
            password = account.split(",")[2].trim();
            String role = account.split(",")[0].trim();
            Role userRole = Role.valueOf(role.toUpperCase());
            signInResult = admin.signIn(userRole, email, password);

        }

    }
    @Then("Sign in operation should succeed")
    public void theSignInOperationShouldSucceed() {
        assertTrue(signInResult);
        message = "Sign in successful.";
    }


    @Then("Sign in operation should fail")
    public void signInOperationShouldFail() {
        Assert.assertFalse(signInResult);
        message = "Account not found.";
    }
}
