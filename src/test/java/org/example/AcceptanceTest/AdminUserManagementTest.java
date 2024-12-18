package org.example.AcceptanceTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.Main;

import java.util.List;
import java.util.Map;

public class AdminUserManagementTest {

    Admin admin = new Admin();
    Main app;
    public AdminUserManagementTest(){
        app = new Main();
    }
    @Given("the admin has selected the {string} option")
    public void the_admin_has_selected_the_option(String string) {
        // Write code here that turns the phrase above into concrete actions
        if(string.equals("new instructor request")){


        }else if(string.equals("admin")){

        }

    }
    @When("the admin chooses an account to approve")
    public void the_admin_chooses_an_account_to_approve() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("the system should send a message to the instructor informing them that the account has been approved successfully")
    public void the_system_should_send_a_message_to_the_instructor_informing_them_that_the_account_has_been_approved_successfully() {
        // Write code here that turns the phrase above into concrete actions

    }



    @When("the admin enters a non-valid account ID")
    public void theAdminEntersANonValidAccountID() {

    }

    @Then("the system should display a message informing the admin that the ID entered is not valid")
    public void theSystemShouldDisplayAMessageInformingTheAdminThatTheIDEnteredIsNotValid() {
    }

    @When("the admin enters a valid account ID")
    public void theAdminEntersAValidAccountID() {
    }

    @Then("the system should send a message to the client informing them that the account has been approved successfully")
    public void theSystemShouldSendAMessageToTheClientInformingThemThatTheAccountHasBeenApprovedSuccessfully() {
    }

    @And("the updated data is valid")
    public void theUpdatedDataIsValid() {
    }

    @Then("the system should update the instructor's information successfully")
    public void theSystemShouldUpdateTheInstructorSInformationSuccessfully() {
    }

    @And("the updated data is invalid")
    public void theUpdatedDataIsInvalid() {
    }

    @Then("the system should display a message informing the admin that the update operation was rejected")
    public void theSystemShouldDisplayAMessageInformingTheAdminThatTheUpdateOperationWasRejected() {
    }

    @Then("the system should update the client's information successfully")
    public void theSystemShouldUpdateTheClientSInformationSuccessfully() {
    }

    @When("the admin chooses a valid account ID")
    public void theAdminChoosesAValidAccountID() {
    }

    @Then("the system should remove the instructor account from the database")
    public void theSystemShouldRemoveTheInstructorAccountFromTheDatabase() {
    }

    @When("the admin chooses an invalid account ID")
    public void theAdminChoosesAnInvalidAccountID() {
    }

    @Then("the system should display a message informing the admin that the ID entered is invalid")
    public void theSystemShouldDisplayAMessageInformingTheAdminThatTheIDEnteredIsInvalid() {
    }

    @When("the admin views activity reports")
    public void theAdminViewsActivityReports() {
    }

    @Then("the system should display statistics including:")
    public void theSystemShouldDisplayStatisticsIncluding() {
        DataTable table = null;
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        // Iterate through the table and print the data for verification
        for (Map<String, String> row : rows) {
            System.out.println("Metric: " + row.get("Metric"));
            System.out.println("Description: " + row.get("Description"));
        }

        // Here, you can add assertions to verify that the system displays the correct data
        for (Map<String, String> row : rows) {
            String metric = row.get("Metric");
            String description = row.get("Description");

            // Example verification logic (replace with actual application logic)
            if (metric.equals("Total Active Users")) {
                System.out.println("Verifying: " + description);
            }
            // Add other cases as needed
        }
    }

    @When("the admin views the instructor engagement report")
    public void theAdminViewsTheInstructorEngagementReport() {
    }

    @When("the admin views the client engagement report")
    public void theAdminViewsTheClientEngagementReport() {
    }
}
