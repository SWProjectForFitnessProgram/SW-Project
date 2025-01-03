package org.example;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public Program()
    {
        //new Program("Get Fit & Moving Challenge", "30 days", "Beginners", "Weight Loss, Full Body", "https://youtu.be/f3zOrYCwquE", "29.99 $")
        programTitle = "Get Fit & Moving Challenge";
        duration = "30 days";
        difficultyLevel = "Beginners";
        goals = "Weight Loss, Full Body";
        content = new Content("https://youtu.be/f3zOrYCwquE","https://unsplash.com/s/photos/gym","https://www.everydayhealth.com/fitness/guide/");
        schedule = new Schedule(new String[] {"Sunday","Tuesday","Thursday"},"5:00 Pm - 7:00 Pm","Online");
        price = "29.99 $";
        clientsEnrolled = new ArrayList<>();
    }
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
    public void setSchedule(Schedule schedule)
    {
        this.schedule = schedule;
    }
    public Schedule getSchedule()
    {
        return schedule;
    }
    public String getTitle() {
        return programTitle;
    }
    public void setProgramTitle(String programTitle)
    {
        this.programTitle = programTitle;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;

    }

    public void setGoals(String goals) {
        this.goals = goals;

    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getGoals() {
        return goals;
    }

    public Content getContent() {
        return content;
    }

    public String getPrice() {
        return price;
    }


    public void enrollClient(Client client) {
//        clientsEnrolled.add(client);
//        System.out.println(client.getName());
        if (!clientsEnrolled.contains(client)) {
            clientsEnrolled.add(client);
            System.out.println(client.getName() + " has been enrolled in the program.");
        } else {
            System.out.println(client.getName() + " is already enrolled in the program.");
        }
    }

    public void addForumMessage(String title, String content) {
        System.out.println("Forum message added: " + title + ", " + content);
    }
//    public void displayAllEnrolledClients()
//    {
//        System.out.println("Enrolled Clients:");
//        for (Client client : clientsEnrolled) {
//            System.out.println(client.getName());
//        }
//    }
    public List<Client> getClientsEnrolled() {
        return clientsEnrolled;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setEndtDate(Date endtDate) {
        this.endDate = startDate;
    }
    public Date getEndtDate() {
        return endDate;
    }
    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }
    public Instructor getResposibleInstructor()
    {
        return instructor;
    }
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