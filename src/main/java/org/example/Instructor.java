package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Instructor in the system, who can manage programs, interact with clients,
 * and handle subscription plans and status within the platform.
 *
 * @author Tala Alhendi
 */
public class Instructor {
    // Fields
    String name; // Name of the instructor
    boolean LoggedIn; // Status indicating if the instructor is logged in
    private List<Program> programs; // List of programs managed by the instructor
    int Age; // Age of the instructor
    private Long id; // Unique identifier for the instructor
    String email; // Email address of the instructor
    String password; // Password for the instructor's account
    private SubscriptionPlan subscriptionPlan; // Subscription plan associated with the instructor
    private UserStatus status; // Current status of the instructor (e.g., Approved, Pending)

    /**
     * Constructor to initialize an instructor with name, email, and age.
     * @param name Name of the instructor.
     * @param mail Email of the instructor.
     * @param Age Age of the instructor.
     */
    public Instructor(String name, String mail, int Age)  {
        this.name = name;
        this.email = mail;
        this.Age = Age;
        programs = new ArrayList<>();
    }

    /**
     * Constructor to initialize an instructor with email, password, and status.
     * @param email Email of the instructor.
     * @param password Password for the instructor's account.
     * @param status Current user status.
     */
    public Instructor(String email, String password, UserStatus status) {
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor to initialize an instructor with email, password, and name.
     * @param email Email of the instructor.
     * @param password Password for the instructor's account.
     * @param name Name of the instructor.
     */
    public Instructor(String email, String password, String name) {
        this.email = email;
        this.password = password;
        programs = new ArrayList<>();
        this.name = name;
    }

    /**
     * Constructor to initialize an instructor with detailed information.
     * @param email Email of the instructor.
     * @param password Password for the instructor's account.
     * @param name Name of the instructor.
     * @param Age Age of the instructor.
     * @param status Current user status.
     */
    public Instructor(String email, String password, String name, Integer Age, UserStatus status) {
        this.email = email;
        this.password = password;
        programs = new ArrayList<>();
        this.name = name;
        this.Age = Age;
        this.status = status;
    }

    /**
     * Retrieves the list of programs managed by the instructor.
     * @return List of programs.
     */
    public List<Program> getPrograms() {
        return programs;
    }

    /**
     * Sets the list of programs for the instructor.
     * @param programs List of programs to be set.
     */
    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    /**
     * Adds a new program to the instructor's list if it doesn't already exist.
     * @param program Program to be added.
     */
    public void addnewProgram(Program program) {
        if (!programs.contains(program)) {
            programs.add(program);
        } else {
            System.out.println("The program ' " + program.getTitle() + " '" + "you want to add already exist :)");
        }
    }

    /**
     * Sets the name of the instructor.
     * @param instructorName New name for the instructor.
     */
    public void setName(String instructorName) {
        this.name = instructorName;
    }

    /**
     * Retrieves the name of the instructor.
     * @return Name of the instructor.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user status of the instructor.
     * @param status New user status.
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    /**
     * Retrieves the current user status of the instructor.
     * @return Current user status.
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * Checks if the instructor's status is approved.
     * @return True if approved, false otherwise.
     */
    public boolean isApproved() {
        return status == UserStatus.Approved;
    }

    /**
     * Approves the instructor's status.
     */
    public void approve() {
        this.status = UserStatus.Approved;
    }

    /**
     * Sets the unique identifier for the instructor.
     * @param id New unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the unique identifier of the instructor.
     * @return Unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sends a message to a client.
     * @param client Client to receive the message.
     * @param message Message to be sent.
     */
    public void sendMessageToClient(Client client, String message) {
        client.setMessage(message);
    }

    /**
     * Posts a message to the forum of a program.
     * @param program Program where the message will be posted.
     * @param title Title of the forum message.
     * @param content Content of the forum message.
     */
    public void postForumMessage(Program program, String title, String content) {
        program.addForumMessage(title, content);
    }

    /**
     * Provides feedback to a client.
     * @param client Client to receive the feedback.
     * @param feedback Feedback content.
     */
    public void provideFeedbackToClient(Client client, String feedback) {
        client.receiveFeedback(feedback);
    }

    /**
     * Retrieves the email address of the instructor.
     * @return Email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a new password for the instructor.
     * @param newPassword New password.
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * Retrieves the password of the instructor.
     * @return Password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the subscription plan of the instructor.
     * @return Subscription plan.
     */
    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    /**
     * Sets a new subscription plan for the instructor.
     * @param subscriptionPlan New subscription plan.
     */
    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    /**
     * Sets the logged-in status of the instructor.
     * @param b New logged-in status.
     */
    public void setLoggedIn(boolean b) {
        LoggedIn = true;
    }
}
