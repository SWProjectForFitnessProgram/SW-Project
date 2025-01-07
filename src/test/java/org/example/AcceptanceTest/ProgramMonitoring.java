package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProgramMonitoring {
    private static Instructor instructor;
    private Schedule updatedSchedule;
    private static List<Client> clintList;
    private static Program mockprogram1,mockprogram2,mockprogram3,mockprogram4,mockprogram5,mockprogram6;
    private static boolean flag = false;
    private double newPrice;
    private String message;
    private static Admin admin;
    private static Main app;
    private static List<Map<String, Integer>> actualData;
    private static List<Program> programs;
    private static List<Map<String,String>> actualTable;
    @BeforeAll
    public static void setUp()
    {
        if(!flag)
        {
            InstructorRepository instructorRepository = new InstructorRepository();
            ClientRepository clientRepository = new ClientRepository();
            admin = new Admin(instructorRepository, clientRepository);
            app = new Main();
            actualData = new ArrayList<>();
            programs= new ArrayList<>();
            Content mockResources = new Content("https://youtu.be/f3zOrYCwquE", "https://unsplash.com/s/photos/gym", "https://www.everydayhealth.com/fitness/guide/");
            Schedule mockSchedule = new Schedule(new String[]{"Sunday", "Tuesday", "Thursday"}, "5:00 Pm - 7:00 Pm", "Online");
            actualTable = new ArrayList<>();
             mockprogram1 = new Program(
                    "Program A",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "35"
            );

             mockprogram1.setStartDate(convertStringToDate("2023-05-15"));
             mockprogram1.setEndtDate(convertStringToDate("2023-05-20"));

             mockprogram2 = new Program(
                    "Program B",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "30"
            );
            mockprogram2.setStartDate(convertStringToDate("2024-05-15"));
            mockprogram2.setEndtDate(convertStringToDate("2024-05-20"));

            mockprogram3 = new Program(
                    "Program C",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "30"
            );
            mockprogram3.setStartDate(convertStringToDate("2024-12-10"));
            mockprogram3.setEndtDate(convertStringToDate("2025-01-10"));


            mockprogram4 = new Program(
                    "Program D",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "70"
            );
            mockprogram4.setStartDate(convertStringToDate("2025-05-15"));
            mockprogram4.setEndtDate(convertStringToDate("2025-05-20"));

            mockprogram5 = new Program(
                    "Program E",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "80"
            );
            mockprogram5.setStartDate(convertStringToDate("2024-12-15"));
            mockprogram5.setEndtDate(convertStringToDate("2025-01-15"));

            mockprogram6 = new Program(
                    "Program F",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "20"
            );

            mockprogram1.enrollClient(new Client("Tala"));
            mockprogram1.enrollClient(new Client("Ghyadaa"));
            mockprogram1.enrollClient(new Client("Taqwa"));
            mockprogram1.enrollClient(new Client("Zain'"));

            mockprogram2.enrollClient(new Client("Tala"));
            mockprogram2.enrollClient(new Client("Ghyadaa"));
            mockprogram2.enrollClient(new Client("Taqwa"));
            mockprogram2.enrollClient(new Client("Zain"));
            mockprogram2.enrollClient(new Client("Samer"));

            mockprogram3.enrollClient(new Client("Ghyadaa"));
            mockprogram3.enrollClient(new Client("Ghyadaa"));
            mockprogram3.enrollClient(new Client("Taqwa"));

            mockprogram4.enrollClient(new Client("Taqwa"));
            mockprogram5.enrollClient(new Client("Ghayda'"));

            mockprogram5.enrollClient(new Client("Tala"));

//            mockprogram6.enrollClient(new Client("Tala"));
            admin.addProgram(mockprogram1);
            admin.addProgram(mockprogram2);
            admin.addProgram(mockprogram3);
            admin.addProgram(mockprogram4);
            admin.addProgram(mockprogram5);
//            admin.addProgram(mockprogram6);
            clintList = new ArrayList<>();
            clintList.add(new Client("Tala"));
            clintList.add(new Client("Taqwa"));
            clintList.add(new Client("Ghayda'"));
            clintList.add(new Client("Samer"));
            clintList.add(new Client("Zain"));

            flag = true;
        }
        else {
            System.out.println("No Program is created !");
        }
    }
    private static Date convertStringToDate(String dateString) {
        LocalDate myLocalDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        Date myDate = Date.from(myLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return myDate;
    }


    @Given("the admin is logged in")
    public void theAdminIsLoggedIn() {
        Assert.assertTrue(admin.isLoggedIn());

    }

    @When("the admin requests statistics on program enrollments")
    public void theAdminRequestsStatisticsOnProgramEnrollments() {
         actualData = admin.getProgramEnrollmentStatisticsAsTable();
    }
    @Then("the system displays the top {int} programs by enrollment")
    public void theSystemDisplaysTheTopProgramsByEnrollment(Integer topCount, io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedTable = dataTable.asMaps(String.class, String.class);
        List<Map<String, String>> actualTable = new ArrayList<>();
        for(Map<String,Integer> program : actualData) {
            for (Map.Entry<String, Integer> entry : program.entrySet()) {
                String programName = entry.getKey();
                Integer enrollmentCount = entry.getValue();

                Map<String, String> map = new HashMap<>();
                map.put("Program Name", programName);
                map.put("Enrollment Count", enrollmentCount.toString());
                actualTable.add(map);
            }
        }
        assertEquals("Program enrollment statistics do not match.", expectedTable, actualTable);

    }


    @When("the admin generates a revenue report for the last quarter")
    public void theAdminGeneratesARevenueReportForTheLastQuarter() {
        actualTable = admin.getRevenueReport();
    }




    @Then("the system generates and displays the revenue report")
    public void theSystemGeneratesAndDisplaysTheRevenueReport(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> expectedTable = dataTable.asMaps(String.class, String.class);
        assertEquals(actualTable,expectedTable);
    }

    @When("the admin views program statuses")
    public void theAdminViewsProgramStatuses() {
        actualTable = admin.getProgramStatusesAsTable();
    }
    @Then("the system displays a list of active and completed programs")
    public void theSystemDisplaysAListOfActiveAndCompletedPrograms(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> expectedTable = dataTable.asMaps(String.class, String.class);
        assertEquals(actualTable,expectedTable);
    }




}
