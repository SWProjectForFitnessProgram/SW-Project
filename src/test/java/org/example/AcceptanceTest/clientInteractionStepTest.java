package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class clientInteractionStepTest {
    Program program;
    Client client;
    Instructor instructor;
    String message;

    @Before
    public void setup() {
        program = new Program("Fitness Program", "30 days", "Beginner", "Weight Loss", "Workout Plan", "19.99 $");
        client = new Client("Alice", "alice@example.com",25);
        instructor = new Instructor("John Doe", "johndoe@example.com",30);
        program.enrollClient(client);
        instructor.setProgram(program);

    }
    @Given("an instructor is logged in")
    public void an_instructor_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
//        instructorLoggedIn = true;
//        System.out.println("Instructor is logged in");
        instructor = new Instructor("John Doe", "johndoe@example.com",30);
        instructor.setLoggedIn(true);

    }
    @Given("the instructor has an active program with enrolled clients")
    public void the_instructor_has_an_active_program_with_enrolled_clients() {
        // Write code here that turns the phrase above into concrete actions
        program = new Program("Fitness Program", "30 days", "Beginner", "Weight Loss", "Workout Plan", "19.99 $");
        client = new Client("Alice", "alice@example.com",25);
        System.out.println(client.getName());
        program.enrollClient(client);
        System.out.println(instructor.getProgramTitle());
        instructor.setProgram(program);
    }
    @When("the instructor selects a client and sends a personalized message")
    public void the_instructor_selects_a_client_and_sends_a_personalized_message() {
        // Write code here that turns the phrase above into concrete actions
         message = "Hi " + client.getName() + ", keep up the good work!";
        instructor.sendMessageToClient(client, message);
        System.out.println("Instructor sent a personalized message: " + message);    }
    @Then("the client should receive the personalized message")
    public void the_client_should_receive_the_personalized_message() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(client.hasReceivedMessage(message));
    }

//    @Given("the instructor has an active program with a discussion forum")
//    public void the_instructor_has_an_active_program_with_a_discussion_forum() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("the instructor posts a message to the forum")
//    public void the_instructor_posts_a_message_to_the_forum() {
//        // Write code here that turns the phrase above into concrete actions
////        String title = "Weekly Motivation";
////        String content = "Stay consistent, and you will see results!";
////        instructor.postForumMessage(program, title, content);
//    }
//    @Then("all enrolled clients should see the message on the forum")
//    public void all_enrolled_clients_should_see_the_message_on_the_forum() {
//        // Write code here that turns the phrase above into concrete actions
//        verify(program).addForumMessage(title, content);
//
//    }
//
//    @Given("the instructor has access to a client's progress report")
//    public void the_instructor_has_access_to_a_client_s_progress_report() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("the instructor provides feedback to the client")
//    public void the_instructor_provides_feedback_to_the_client() {
//        // Write code here that turns the phrase above into concrete actions
//        String feedback = "Great progress this week! Try increasing your cardio sessions to 20 minutes.";
//        instructor.provideFeedbackToClient(client, feedback);
//    }
//    @Then("the client should receive the feedback")
//    public void the_client_should_receive_the_feedback() {
//        // Write code here that turns the phrase above into concrete actions
//        assertTrue(client.hasReceivedFeedback(feedback));
//
//    }
//
}
