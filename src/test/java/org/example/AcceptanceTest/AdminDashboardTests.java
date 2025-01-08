package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static org.example.UserStatus.*;
import static org.junit.Assert.assertTrue;

public class AdminDashboardTests {


    private static List<Instructor> pendingInstructors;
    private static List<Client> pendingClients;
    private String message;
    private static Admin admin;
    private static Main app;


    @Before
    public static void setup() {
        InstructorRepository instructorRepository = new InstructorRepository();
        ClientRepository clientRepository = new ClientRepository();
        admin = new Admin(instructorRepository, clientRepository);
        app = new Main();
        pendingInstructors = new ArrayList<>();
        pendingClients = new ArrayList<>();
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
            Instructor instructor = new Instructor(row.get("email"), row.get("password"), Pending);
            admin.getInstructors().add(instructor); //add to the repository
            pendingInstructors.add(instructor);
        }
//        pendingInstructors = admin.getPendingInstructors();
        Assert.assertFalse("There should be pending instructors", pendingInstructors.isEmpty());
    }

    //1//3
    @When("I click on {string} page")
    public void iClickedOnPage(String arg0) {
        if (arg0.equals("Approve Client")) {
            List<Client> fetchedClients = admin.getPendingClients();
            if (fetchedClients.isEmpty()) {
                message = "No pending client accounts";
            } else {
                pendingClients = fetchedClients;
            }

        } else if (arg0.equals("Approve Instructor")) {
            List<Instructor> fetchedInstructors = admin.getPendingInstructors();
            if (fetchedInstructors.isEmpty()) {
                message = "No pending instructor accounts";
            } else {
                pendingInstructors = fetchedInstructors;
            }
        }
    }

    //1
    @Then("I should see a list of pending instructor accounts:")
    public void iShouldSeeAListOfPendingInstructorAccounts(List<Map<String, String>> expectedInstructorsTable) {
        Assert.assertNotNull(pendingInstructors);
        Assert.assertEquals(expectedInstructorsTable.size(), pendingInstructors.size());
    }

    //2
    @Given("there are no pending instructor accounts")
    public void noPendingInstructorAccounts() {
        assertTrue("There is pending Instructor accounts", admin.getPendingInstructors().isEmpty());
    }

    //2
    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String expectedMessage) {
        String actualMessage = null;
        if (expectedMessage.equals("No pending client accounts")) {
            if (admin.getPendingClients().isEmpty()) {
                actualMessage = "No pending client accounts";
            }
        } else if (expectedMessage.equals("No pending instructor accounts")) {
            if (admin.getPendingInstructors().isEmpty()) {
                actualMessage = "No pending instructor accounts";
            }
        }
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    //3
    @And("there are pending Client accounts:")
    public void thereArePendingClientAccounts(List<Map<String, String>> clientsTable) {
        for (Map<String, String> row : clientsTable) {
            Client client = new Client(row.get("email"), row.get("password"), Pending);
            admin.getClients().add(client); //add to the repository
            pendingClients.add(client);
        }
//        pendingInstructors = admin.getPendingInstructors();
        Assert.assertFalse("There should be pending instructors", pendingClients.isEmpty());
    }

    //3
    @Then("I should see a list of pending Client accounts:")
    public void iShouldSeeAListOfPendingClientAccounts(List<Map<String, String>> expectedClientsTable) {
        Assert.assertNotNull(pendingClients);
        Assert.assertEquals(expectedClientsTable.size(), pendingClients.size());

    }

    //4
    @And("there are no pending client accounts")
    public void thereAreNoPendingClientAccounts() {
        Assert.assertTrue("There is pending Client accounts", admin.getPendingClients().isEmpty());
    }

    @And("the following instructor exists:")
    public void theFollowingInstructorExists(List<Map<String, String>> instructorsTable) {
        for (Map<String, String> row : instructorsTable) {
            Instructor instructor = new Instructor(row.get("Email"), row.get("Password"), row.get("Name"));
            admin.getInstructors().add(instructor);

        }
    }

    @When("I update the instructor account with:")
    public void iUpdateTheInstructorAccountWith(List<Map<String, String>> updatedInstructorsTable) {
        for (Map<String, String> row : updatedInstructorsTable) {
            assertTrue("there is no such account", admin.getInstructorRepository().updateInstructor(row.get("Email"), row.get("Password"), row.get("Name")));
        }
    }


    @Then("the instructor account should be updated with:")
    public void theInstructorAccountShouldBeUpdatedWith(List<Map<String, String>> expectedInstructorsTable) {
        for (Map<String, String> row : expectedInstructorsTable) {
            Instructor updatedInstructor = admin.getInstructorRepository().findInstructorByEmail(row.get("Email"));
            Assert.assertNotNull("Instructor not found", updatedInstructor);
            Assert.assertEquals("Incorrect password", row.get("Password"), updatedInstructor.getPassword());
            Assert.assertEquals("Incorrect name", row.get("Name"), updatedInstructor.getName());
        }
    }


    @Given("the following client exists:")
    public void theFollowingClientExists(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> clientDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : clientDetails) {
            String email = row.get("Email");
            String password = row.get("Password");
            String name = row.get("Name");
            Client client = new Client(email, password, name);
            admin.getClientsRepository().addClient(client);
        }
    }

    @When("I update the client account with:")
    public void iUpdateTheClientAccountWith(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> clientDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : clientDetails) {
            String email = row.get("Email");
            String newPassword = row.get("Password");
            String newName = row.get("Name");
            assertTrue(admin.getClientsRepository().updateClient(email, newPassword, newName));

        }
    }

    @Then("the client account should be updated with:")
    public void theClientAccountShouldBeUpdatedWith(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> clientDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : clientDetails) {
            String email = row.get("Email");
            String password = row.get("Password");
            String name = row.get("Name");
            admin.getClientsRepository().findClientByEmail(email);

        }
    }

    //7
    @When("I deactivate the instructor account with email {string}")
    public void iDeactivateTheInstructorAccountWithEmail(String email) {
        Instructor instructor = admin.getInstructorRepository().findInstructorByEmail(email);
        if (instructor != null) {
            instructor.setStatus(UserStatus.Deactivated);
        } else {
            throw new IllegalArgumentException("Instructor with email " + email + " not found.");
        }
    }

    @Then("the instructor account should be marked as deactivated:")
    public void theInstructorAccountShouldBeMarkedAsDeactivated(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expDeactInstructors = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : expDeactInstructors) {
            String email = row.get("Email");
            Instructor instructor = admin.getInstructorRepository().findInstructorByEmail(email); // Locate the instructor
            if (instructor != null) {
                boolean expectedActiveStatus = Boolean.parseBoolean(row.get("Active"));
                Assert.assertEquals("Instructor active status mismatch for email: " + email,
                        expectedActiveStatus, instructor.isApproved());
            } else {
                throw new IllegalArgumentException("Instructor with email " + email + " not found.");
            }
        }
    }


    @When("I deactivate the client account with email {string}")
    public void iDeactivateTheClientAccountWithEmail(String email) {
        Client client = admin.getClientsRepository().findClientByEmail(email);
        if (client != null) {
            client.setStatus(UserStatus.Deactivated);
        } else {
            throw new IllegalArgumentException("Instructor with email " + email + " not found.");
        }
    }

    @Then("the client account should be marked as deactivated:")
    public void theClientAccountShouldBeMarkedAsDeactivated(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expDeactInstructors = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : expDeactInstructors) {
            String email = row.get("Email");
            Client client = admin.getClientsRepository().findClientByEmail(email); // Locate the instructor
            if (client != null) {
                boolean expectedActiveStatus = Boolean.parseBoolean(row.get("Active"));
                Assert.assertEquals("Instructor active status mismatch for email: " + email,
                        expectedActiveStatus, client.isActive());
            } else {
                throw new IllegalArgumentException("Instructor with email " + email + " not found.");
            }
        }
    }

    @Given("the admin has selected the {string} option")
    public void theAdminHasSelectedTheOption(String string) {
        admin.setSelectedOption(string);
        for(int i=0;i<10;i++){
            Instructor inst = new Instructor("test@email", "test", Approved);
            admin.getInstructors().add(inst);
            Client client = new Client("test@email", "test", Approved);
            admin.getClients().add(client);
        }
        for(int i=0;i<5;i++){
            Instructor inst = new Instructor("test@email", "test", Deactivated);
            admin.getInstructors().add(inst);
            Client client = new Client("test@email", "test", Deactivated);
            admin.getClients().add(client);
        }

        assertTrue(admin.getSelectedOption().equals(string));
    }

    @When("the admin views activity reports")
    public void theAdminViewsActivityReports() {

        if(admin.getSelectedOption().equals("monitor user activity")) {
            admin.generateUserActivityReport();
        }
        else
            throw new IllegalArgumentException("Invalid option selected: " + admin.getSelectedOption());

    }

    @Then("the system should display statistics including:")
    public void theSystemShouldDisplayStatisticsIncluding(io.cucumber.datatable.DataTable dataTable) {

    }
    @Test
    public void approveAllPendingInstructors() {
        for (Instructor instructor : pendingInstructors) {
            instructor.setStatus(UserStatus.Approved);
        }
        Assert.assertTrue("All instructors should be approved",
                pendingInstructors.stream().allMatch(i -> i.getStatus() == UserStatus.Approved));
    }
    @Test
    public void approveAllPendingClients() {
        for (Client client : pendingClients) {
            client.setStatus(UserStatus.Approved);
        }
        Assert.assertTrue("All clients should be approved",
                pendingClients.stream().allMatch(c -> c.getStatus() == UserStatus.Approved));
    }

    @Test
    public void addInstructorWithInvalidEmail() {
        String invalidEmail = "invalid-email";
        try {
            Instructor instructor = new Instructor(invalidEmail, "password123", UserStatus.Pending);
            admin.getInstructors().add(instructor);
            Assert.fail("Should not allow invalid email format");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid email format: " + invalidEmail, e.getMessage());
        }
    }
    @Test
    public void updateNonexistentInstructor() {
        String email = "nonexistent-instructor@email.com";
        boolean updated = admin.getInstructorRepository().updateInstructor(email, "newPass", "newName");
        Assert.assertFalse("Update should fail for nonexistent account", updated);
    }
    @Test
    public void updateNonexistentClient() {
        String email = "nonexistent-client@email.com";
        boolean updated = admin.getClientsRepository().updateClient(email, "newPass", "newName");
        Assert.assertFalse("Update should fail for nonexistent account", updated);
    }

}

