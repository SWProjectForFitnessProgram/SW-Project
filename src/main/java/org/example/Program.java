package org.example;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Program class represents a fitness program that clients can enroll in.
 * It includes details about the program such as its title, duration, difficulty level, goals,
 * schedule, content, price, and other related information.
 *
 * @author Tala Alhendi
 */
public class Program {
    List<Client> clientsEnrolled;
    String programTitle;
    String duration;
    String difficultyLevel;
    String goals;
    String price;
    private Content content;
    private Schedule schedule;
    Date startDate;
    Date endDate;
    private Instructor instructor;

    /**
     * Default constructor for the Program class.
     * Initializes a predefined fitness program with default values.
     * The program includes basic information such as title, duration, difficulty level, goals,
     * multimedia content, schedule, and price. It also prepares the enrollment list
     * for clients.
     */
    public Program()
    {
        programTitle = "Get Fit & Moving Challenge";
        duration = "30 days";
        difficultyLevel = "Beginners";
        goals = "Weight Loss, Full Body";
        content = new Content("https://youtu.be/f3zOrYCwquE","https://unsplash.com/s/photos/gym","https://www.everydayhealth.com/fitness/guide/");
        schedule = new Schedule(new String[] {"Sunday","Tuesday","Thursday"},"5:00 Pm - 7:00 Pm","Online");
        price = "29.99 $";
        clientsEnrolled = new ArrayList<>();
    }
    /**
     * Constructor for the Program class that initializes a custom fitness or educational program.
     * The program is defined by its title, duration, difficulty level, goals, multimedia content,
     * schedule, and price. It also initializes the list of enrolled clients.
     *
     * @param title the title of the program
     * @param duration the duration of the program (e.g., "4 weeks", "6 months")
     * @param difficultyLevel the difficulty level of the program (e.g., "Beginner", "Intermediate")
     * @param goals the goals of the program (e.g., "Weight Loss", "Skill Development")
     * @param content the multimedia content associated with the program (e.g., videos, images, tutorials)
     * @param schedule the schedule for the program, which includes days, time, and schedule type
     * @param price the price of the program
     */
    public Program(String title, String duration, String difficultyLevel, String goals,
                   Content content, Schedule schedule, String price)
    {
        this.programTitle = title;
        this.duration = duration;
        this.difficultyLevel  = difficultyLevel;
        this.goals = goals;
        this.content = content;
        this.schedule = schedule;
        this.price = price;
        clientsEnrolled = new ArrayList<>();
    }
    /**
     * Setters*/
    public void setSchedule(Schedule schedule)
    {
        this.schedule = schedule;
    }
    /**
     * Retrieves the schedule associated with the program.
     *
     */
    public Schedule getSchedule()
    {
        return schedule;
    }
    /**
     * Retrieves the title of the*/
    public String getTitle() {
        return programTitle;
    }
    /**
     * Updates the program's title*/
    public void setProgramTitle(String programTitle)
    {
        this.programTitle = programTitle;
    }
    /**
     * Sets the duration of the program.
     *
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Sets the difficulty level for the program.
     */
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;

    }

    /**
     * Sets the goals for this object.
     *
     * @param goals the goals to be set; represented as a String
     */
    public void setGoals(String goals) {
        this.goals = goals;

    }

    /**
     * Sets*/
    public void setContent(Content content) {
        this.content = content;
    }

    /**
     * Sets*/
    public void setPrice(String price) {
        this.price = price;
    }
    public String getDuration() {
        return duration;
    }

    /**
     * Retrieves the difficulty level of the program.
     *
     * @return the difficulty level as a string.
     */
    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Retrieves the current goals.
     *
     * @return a string containing the goals.
     */
    public String getGoals() {
        return goals;
    }
    public Content getContent() {
        return content;
    }

    /**
     * Retrieves the price of the*/
    public String getPrice() {
        return price;
    }


    /**
     * Enrolls a*/
    public void enrollClient(Client client) {

        if (!clientsEnrolled.contains(client)) {
            clientsEnrolled.add(client);
            System.out.println(client.getName() + " has been enrolled in the program.");
        } else {
            System.out.println(client.getName() + " is already enrolled in the program.");
        }
    }

    /**
     * Adds a message to the forum with the given title and content.
     *
     */
    public void addForumMessage(String title, String content) {
        System.out.println("Forum message added: " + title + ", " + content);
    }

    /**
     **/
    public List<Client> getClientsEnrolled() {
        return clientsEnrolled;
    }
    /**
     * Sets the start*/
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    /**
     * Retrieves*/
    public Date getStartDate() {
        return startDate;
    }
    /**
     * Sets the end date for the*/
    public void setEndtDate(Date endtDate) {
        this.endDate = startDate;
    }
    /**
     * Retrieves the end date of*/
    public Date getEndtDate() {
        return endDate;
    }
    /**
     * Sets the*/
    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }
    /**
     * Retrieves the instructor responsible for the program.
     *
     * @return the instructor assigned to*/
    public Instructor getResposibleInstructor()
    {
        return instructor;
    }

    /**
     * Returns a string representation of the object, providing details about the program,
     * including its title, duration, difficulty level, goals, price, and additional
     * associated information such as schedule, content, start and end dates, and instructor details.
     *
     * @return A string that represents the state and attributes of the program.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Program Details:\n");
        sb.append("Title: ").append(programTitle).append("\n");
        sb.append("Duration: ").append(duration).append("\n");
        sb.append("Difficulty Level: ").append(difficultyLevel).append("\n");
        sb.append("Goals: ").append(goals).append("\n");
        sb.append("Price: ").append(price).append("\n");

        if (schedule != null) {
            sb.append("Schedule: ").append(schedule.toString()).append("\n");
        }

        if (content != null) {
            sb.append("Content:\n");
            sb.append("  Video URL: ").append(content.getVideoTutorials()).append("\n");
            sb.append("  Image URL: ").append(content.getImages()).append("\n");
            sb.append("  Documentation URL: ").append(content.getDocumentation()).append("\n");
        }

        if (startDate != null) {
            sb.append("Start Date: ").append(startDate).append("\n");
        }

        if (endDate != null) {
            sb.append("End Date: ").append(endDate).append("\n");
        }

        if (instructor != null) {
            sb.append("Instructor: ").append(instructor.getName()).append("\n");
        }

        return sb.toString();
    }

}