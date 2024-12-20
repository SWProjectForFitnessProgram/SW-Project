package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Admin;
import org.example.AdminService;
import org.example.Instructor;
import org.example.Main;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

public class ProgramMonitoring {
    private Admin admin ;
    private final Main app;
    @Mock
    private AdminService monitoringService;

    private List<Map<String, String>> actualData;
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
        actualData = monitoringService.getProgramEnrollmentStatisticsAsTable();
        Mockito.when(monitoringService.getProgramEnrollmentStatisticsAsTable()).thenReturn(actualData);

    }
    @Then("the system displays the top {int} programs by enrollment")
    public void theSystemDisplaysTheTopProgramsByEnrollment(Integer int1, io.cucumber.datatable.DataTable dataTable) {

    }


    @When("the admin generates a revenue report for the last quarter")
    public void theAdminGeneratesARevenueReportForTheLastQuarter() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("the system generates and displays the revenue report")
    public void theSystemGeneratesAndDisplaysTheRevenueReport(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @When("the admin views program statuses")
    public void theAdminViewsProgramStatuses() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("the system displays a list of active and completed programs")
    public void theSystemDisplaysAListOfActiveAndCompletedPrograms(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }




}
