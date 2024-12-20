package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.AdminService;
import org.example.Main;
import org.junit.Assert;
import org.mockito.Mockito;

public class ProgramMonitoring {
    private Admin admin ;
    private final Main app;

    private AdminService monitoringService;
    private String reportResult;
    public ProgramMonitoring() {
        admin = new Admin();
        app = new Main();
        this.monitoringService = Mockito.mock(AdminService.class);
    }


    @Given("the admin is logged in")
    public void theAdminIsLoggedIn() {
        Assert.assertTrue(admin.isLoggedIn());

    }
    @When("the admin requests statistics on program enrollments")
    public void theAdminRequestsStatisticsOnProgramEnrollments() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("the system displays the top {int} programs by enrollment")
    public void theSystemDisplaysTheTopProgramsByEnrollment(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }


    @When("the admin generates a revenue report for the last quarter")
    public void theAdminGeneratesARevenueReportForTheLastQuarter() {

    }

    @Then("the system generates and displays the revenue report")
    public void theSystemGeneratesAndDisplaysTheRevenueReport() {

    }

    @When("the admin views program statuses")
    public void theAdminViewsProgramStatuses() {

    }

    @Then("the system displays a list of active and completed programs")
    public void theSystemDisplaysAListOfActiveAndCompletedPrograms() {
    }
}
