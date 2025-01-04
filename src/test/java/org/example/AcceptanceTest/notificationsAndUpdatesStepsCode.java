package org.example.AcceptanceTest;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class notificationsAndUpdatesStepsCode {
    private static Instructor instructor;
    private Schedule updatedSchedule;
    private static List<Client> clintList;
    private static Program program;
    private static boolean flag = false;
    private double newPrice;

    @BeforeAll
    public static void setUp()
    {
        if(!flag)
        {
            instructor = new Instructor("Ali","Ali@gmail.com",32);
            Content mockResources = new Content("https://youtu.be/f3zOrYCwquE", "https://unsplash.com/s/photos/gym", "https://www.everydayhealth.com/fitness/guide/");
            Schedule mockSchedule = new Schedule(new String[]{"Sunday", "Tuesday", "Thursday"}, "5:00 Pm - 7:00 Pm", "Online");

            Program mockprogram = new Program(
                    "Get Fit & Moving Challenge",
                    "30 days",
                    "Beginners",
                    "Weight Loss, Full Body",
                    mockResources,
                    mockSchedule,
                    "29.99 $"
            );
            mockprogram.enrollClient(new Client("Tala"));
            mockprogram.enrollClient(new Client("Ghyadaa"));
            mockprogram.enrollClient(new Client("Taqwa"));
            clintList = new ArrayList<>();
            clintList.add(new Client("Tala"));
            clintList.add(new Client("Taqwa"));
            clintList.add(new Client("Ghayda'"));
            clintList.add(new Client("Samer"));
            clintList.add(new Client("Zain"));
            program = mockprogram;
            instructor.addnewProgram(program);
            System.out.println(instructor.getName());
            flag = true;
        }
        else {
            System.out.println("No Instructor is created !");
        }    }

    @Given("the instructor has an existing program {string} schedule")
    public void theInstructorHasAnExistingProgramSchedule(String ProgramName) {
        List<Program> programList = new ArrayList<>();
        programList = instructor.getPrograms();
        for(Program program1 : programList)
        {
            if(program1.getTitle().equals(ProgramName))
            {
                if(program1.getSchedule() != null ) {
                    System.out.println("The program ' " + program1.getTitle() + " ' found :)");
                }
                break;
            }
        }


    }
    @When("the instructor updates the program schedule with the following details:")
    public void the_instructor_updates_the_program_schedule_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> scheduleDetailsList = dataTable.asMaps(String.class, String.class);

        Map<String, String> scheduleDetails = scheduleDetailsList.get(0);
        String[] days = scheduleDetails.get("Days").split(",\\s*");

        updatedSchedule = new Schedule(days, scheduleDetails.get("Time"),scheduleDetails.get("Schedule Type"));
        program.setSchedule(updatedSchedule);
    }
    @Then("notifications about the updated schedule should be sent to all enrolled clients")
    public void notifications_about_the_updated_schedule_should_be_sent_to_all_enrolled_clients() {
        for(Client client : program.getClientsEnrolled())
        {
            client.setNotification(updatedSchedule.toString());
            assertTrue(client.hasRecievedNotification());

        }
    }
    @When("the instructor creates a new program with the following details:")
    public void the_instructor_creates_a_new_program_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> programDetails = dataTable.asMap(String.class,String.class);
        program = new Program();
        program.setProgramTitle(programDetails.get("Program Title"));
        program.setDuration(programDetails.get("Duration"));
        program.setDifficultyLevel(programDetails.get("Difficulty Level"));
        program.setGoals(programDetails.get("Goals"));
        program.setPrice(programDetails.get("Price"));

    }
    @When("the program includes schedules with the following details:")
    public void the_program_includes_schedules_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> scheduleDetailsList = dataTable.asMaps(String.class, String.class);

        Map<String, String> scheduleDetails = scheduleDetailsList.get(0);
        String[] days = scheduleDetails.get("Days").split(",\\s*");
        Schedule schedule = new Schedule(days, scheduleDetails.get("Time"),scheduleDetails.get("Schedule Type"));
        program.setSchedule(schedule);
    }
    @Then("notifications about the new program should be sent to all registered clients")
    public void notifications_about_the_new_program_should_be_sent_to_all_registered_clients() {

        for(Client client : clintList)
        {
            client.setNotification("A new Program is now in the System with the following details: \n" + program.toString());
            assertTrue(client.hasRecievedNotification());
        }
    }
    private double convertPriceStringToDouble(String price) {
        // Remove non-digit characters (except the decimal point)
        String numericPart = price.replaceAll("[^\\d.]", "");
        // Parse the cleaned string to a double
        return Double.parseDouble(numericPart);
    }
    @When("the instructor creates a special offer Discount {double} for an existing program {string}")
    public void theInstructorCreatesASpecialOfferDiscountForAnExistingProgram(double offer, String programName) {
        double oldPrice = convertPriceStringToDouble(program.getPrice());
        newPrice = offer*oldPrice;
        program.setPrice(newPrice + " $");

    }
    @Then("notifications about the special offer should be sent to all registered clients")
    public void notifications_about_the_special_offer_should_be_sent_to_all_registered_clients() {
        assertEquals(program.getPrice(), newPrice + " $");
    }


}
