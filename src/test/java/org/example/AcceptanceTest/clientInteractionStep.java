package org.example.AcceptanceTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;


import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class clientInteractionStep {

    private static Program program;
    private static Client client;
    static Instructor instructor;
    String message;
    String feedback;
    private final ProgressManager progressManager = new ProgressManager();


    @And("the instructor has an active program {string} with enrolled clients")
    public void theInstructorHasAnActiveProgramWithEnrolledClients(String programName) {        // Write code here that turns the phrase above into concrete actions
        Content mockContent = new Content("https://youtu.be/f3zOrYCwquE","https://unsplash.com/s/photos/gym","https://www.everydayhealth.com/fitness/guide/");
        Schedule mockSchedule = new Schedule(new String[]{"Monday","Wednesday"},"12:00 Pm - 2:00 Pm","in person");
        mockContent.setVideoTutorial("https://youtu.be/f3zOrYCwquE");
        mockContent.setDocumentation("https://unsplash.com/s/photos/gym");
        mockContent.setImages("https://www.everydayhealth.com/fitness/guide/");
        Content content= new Content(mockContent);

        program = new Program(
                programName,
                "60 days",
                "Beginners",
                "Weight Loss, Full Body",
                mockContent,
                mockSchedule,
                "39.99 $"
        );
        client = new Client("tala", "tala@example.com",20);
        instructor = new Instructor("John Doe", "johndoe@example.com",30);

//        System.out.println(client.getName());
        program.enrollClient(client);
//        System.out.println(instructor.getProgramTitle());
        instructor.addnewProgram(program);
        client.enrollProgram(program);
//        client.enrollProgram(program);
    }
    @When("the instructor selects a client {string} and sends a personalized message {string}")
    public void theInstructorSelectsAAndSendsA(String specifiedClientName, String specifiedMessage) {
        // Write code here that turns the phrase above into concrete actions
        Client specifiedClient = program.getClientsEnrolled().stream()
                .filter(client -> client.getName().equals(specifiedClientName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Client not found: " + specifiedClientName));

        message = "Hi " + specifiedClientName + ", " + specifiedMessage;
        instructor.sendMessageToClient(specifiedClient, message);
        System.out.println("Instructor sent a personalized message: " + message);
    }
    @Then("the client should receive the personalized message")
    public void the_client_should_receive_the_personalized_message() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(client.hasReceivedMessage(message));
    }

    @And("the instructor has an active program {string} with a discussion forum")
    public void theInstructorHasAnActiveProgramWithADiscussionForum(String programName)
    {
        Content mockContent = new Content("https://youtu.be/f3zOrYCwquE","https://unsplash.com/s/photos/gym","https://www.everydayhealth.com/fitness/guide/");
        Schedule mockSchedule = new Schedule(new String[]{"Monday","Wednesday"},"12:00 Pm - 2:00 Pm","in person");

        program = new Program(
                programName,
                "60 days",
                "Beginners",
                "Weight Loss, Full Body",
                mockContent,
                mockSchedule,
                "39.99 $"
        );
        client = new Client("tala", "tala@example.com",20);
        instructor = new Instructor("John Doe", "johndoe@example.com",30);

//        System.out.println(client.getName());
        program.enrollClient(client);
//        System.out.println(instructor.getProgramTitle());
        instructor.addnewProgram(program);
        client.enrollProgram(program);
    }
    @When("the instructor posts a message to the forum")
    public void the_instructor_posts_a_message_to_the_forum() {
        // Write code here that turns the phrase above into concrete actions
        String title = "Weekly Motivation";
        message = "Stay consistent, and you will see results!";
        client.receiveMessage(message);
        instructor.postForumMessage(program, title, message);
    }
    @Then("all enrolled clients should see the message on the forum")
    public void all_enrolled_clients_should_see_the_message_on_the_forum() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(client.hasReceivedMessage(message));
    }

    @And("the instructor has access to a client's progress report for {string}")
    public void theInstructorHasAccessToAClientSProgressReportFor(String clientName) {
        Map<String, String> progressData = progressManager.getProgressData();
        if (progressData == null) {
            throw new IllegalArgumentException("Progress data not found for client: " + clientName);
        }

    }
    @When("the instructor provides feedback to the client")
    public void the_instructor_provides_feedback_to_the_client() {
        // Write code here that turns the phrase above into concrete actions
        feedback = "Great progress this week! Try increasing your cardio sessions to 20 minutes.";
        instructor.provideFeedbackToClient(client, feedback);
    }
    @Then("the client should receive the feedback")
    public void the_client_should_receive_the_feedback() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(client.hasReceivedFeedback(feedback));

    }


}