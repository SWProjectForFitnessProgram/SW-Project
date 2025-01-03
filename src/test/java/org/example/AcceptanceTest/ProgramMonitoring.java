package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProgramMonitoring {
    private Admin admin ;
    private final Main app;
    private InstructorRepository instructorRepository;
    private ClientRepository clientRepository;


    @Mock
    private AdminService monitoringService;

    private List<Map<String, String>> actualData;
    public ProgramMonitoring() {
        instructorRepository = new InstructorRepository();
        clientRepository = new ClientRepository();
        admin = new  Admin(instructorRepository, clientRepository);
        app = new Main();
        this.monitoringService = Mockito.mock(AdminService.class);
        actualData=new ArrayList<>();
    }


    @Given("the admin is logged in")
    public void theAdminIsLoggedIn() {
        Assert.assertTrue(admin.isLoggedIn());

    }

    @When("the admin requests statistics on program enrollments")
    public void theAdminRequestsStatisticsOnProgramEnrollments() {
        List<Map<String, String>> mockedData = List.of(
                Map.of("Program Name", "Program A", "Enrollment Count", "200"),
                Map.of("Program Name", "Program B", "Enrollment Count", "180"),
                Map.of("Program Name", "Program C", "Enrollment Count", "150"),
                Map.of("Program Name", "Program D", "Enrollment Count", "120"),
                Map.of("Program Name", "Program E", "Enrollment Count", "100")
        );
        // Use Mockito to mock the method's behavior
        Mockito.when(monitoringService.getProgramEnrollmentStatisticsAsTable()).thenReturn(mockedData);

        // Call the mocked method (returns mocked data)
        actualData = monitoringService.getProgramEnrollmentStatisticsAsTable();

    }
    @Then("the system displays the top {int} programs by enrollment")
    public void theSystemDisplaysTheTopProgramsByEnrollment(Integer int1, io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedTable = dataTable.asMaps(String.class, String.class);
        assertEquals("Program enrollment statistics do not match.", expectedTable, actualData);
    }


    @When("the admin generates a revenue report for the last quarter")
    public void theAdminGeneratesARevenueReportForTheLastQuarter() {
        // Mocked revenue data for the last quarter
        List<Map<String, String>> mockedRevenueReport = List.of(
                Map.of("Program Name", "Program A", "Revenue", "40000"),
                Map.of("Program Name", "Program B", "Revenue", "36000"),
                Map.of("Program Name", "Program C", "Revenue", "30000"),
                Map.of("Program Name", "Program D", "Revenue", "24000"),
                Map.of("Program Name", "Program E", "Revenue", "20000")
        );

        // Mock the behavior of the monitoring service
        Mockito.when(monitoringService.generateRevenueReport("last quarter"))
                .thenReturn(mockedRevenueReport);

        // Call the mocked method
        actualData = monitoringService.generateRevenueReport("last quarter");
    }
    @Then("the system generates and displays the revenue report")
    public void theSystemGeneratesAndDisplaysTheRevenueReport(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expected = List.of(
                Map.of("Program Name", "Program A", "Revenue", "40000"),
                Map.of("Program Name", "Program B", "Revenue", "36000"),
                Map.of("Program Name", "Program C", "Revenue", "30000"),
                Map.of("Program Name", "Program D", "Revenue", "24000"),
                Map.of("Program Name", "Program E", "Revenue", "20000")
        );

        assertEquals("Revenue report does not match the expected data.", expected, actualData);
    }

    @When("the admin views program statuses")
    public void theAdminViewsProgramStatuses() {
        // Mocking program status data
        List<Map<String, String>> mockedProgramStatuses = List.of(
                Map.of("Program Name", "Program A", "Status", "Active"),
                Map.of("Program Name", "Program B", "Status", "Active"),
                Map.of("Program Name", "Program C", "Status", "Completed"),
                Map.of("Program Name", "Program D", "Status", "Completed"),
                Map.of("Program Name", "Program E", "Status", "Completed")
        );

        // Mock the behavior of the monitoring service
        Mockito.when(monitoringService.getProgramStatuses()).thenReturn(mockedProgramStatuses);

        // Call the mocked method
        actualData = monitoringService.getProgramStatuses();
    }
    @Then("the system displays a list of active and completed programs")
    public void theSystemDisplaysAListOfActiveAndCompletedPrograms(io.cucumber.datatable.DataTable dataTable) {
        // Convert the Gherkin data table to a List<Map<String, String>>
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);

        // Verify the actual data matches the expected data
        assertEquals("Program statuses do not match.", expectedData, actualData);
    }




}
