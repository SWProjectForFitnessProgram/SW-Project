package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class programManagementStepTest {
    private List<Program> programList;

    private boolean InstructorLoggedIn ;

    public programManagementStepTest() {
            programList = new ArrayList<>();
    }

    @Given("the instructor is logged in")
    public void theInstructorIsLoggedIn() {
        InstructorLoggedIn = true;
    }


    @When("the following details are provided")
    public void the_following_details_are_provided(io.cucumber.datatable.DataTable dataTable) {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
            // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
            // Double, Byte, Short, Long, BigInteger or BigDecimal.
            //
            Map<String,String> programDetails = dataTable.asMap(String.class, String.class);
            if(InstructorLoggedIn)
            {
                Program program = new Program(
                        programDetails.get("Program title"),
                        programDetails.get("Duration"),
                        programDetails.get("Difficulty level"),
                        programDetails.get("Goals"),
                        programDetails.get("Content"),
                        programDetails.get("Price")
                );
                programList.add(program);
            }
            else {
                System.out.println("Instructor is not logged in");
            }
        }



    @Then("the program is created with the specified details {string}")
    public void the_program_is_created_with_the_specified_details(String string) {
            {
                Program program = null;

                for (Program p : programList) {
                    if (p.getTitle() != null && p.getTitle().equals(string)) {
                        program = p;
                        break;
                    }
                }
                assertNotNull("The program which its program title is ' " + string + " ' wasn't found!", program);

            }
        }


    @Given("a fitness program with the title {string} exists")
    public void aFitnessProgramWithTheTitleExists(String arg0) {
    }

    @When("the instructor updates the program with the following details")
    public void theInstructorUpdatesTheProgramWithTheFollowingDetails() {
    }

    @Then("the program is updated successfully with the new details")
    public void theProgramIsUpdatedSuccessfullyWithTheNewDetails() {
    }
//
//    @Given("a fitness program with the title {string} does not exist")
//    public void aFitnessProgramWithTheTitleDoesNotExist(String arg0) {
//    }
//
//    @Then("the system displays an error message indicating that the program does not exist")
//    public void theSystemDisplaysAnErrorMessageIndicatingThatTheProgramDoesNotExist() {
//    }
//
//    @When("the instructor chooses to delete the program")
//    public void theInstructorChoosesToDeleteTheProgram() {
//    }
//
//    @Then("the program is deleted successfully")
//    public void theProgramIsDeletedSuccessfully() {
//    }
//
//
}
