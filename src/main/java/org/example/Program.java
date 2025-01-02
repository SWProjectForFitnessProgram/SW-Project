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

    public Program()
    {
        //new Program("Get Fit & Moving Challenge", "30 days", "Beginners", "Weight Loss, Full Body", "https://youtu.be/f3zOrYCwquE", "29.99 $")
        programTitle = "Get Fit & Moving Challenge";
        duration = "30 days";
        difficultyLevel = "Beginners";
        goals = "Weight Loss, Full Body";
        content.setVideoTutorial("https://youtu.be/f3zOrYCwquE");
        content.setDocumentation("https://www.everydayhealth.com/fitness/guide/");
        content.setImages("https://unsplash.com/s/photos/gym");
        schedule.setDays(new String[] {"Sunday","Tuesday","Thursday"});
        schedule.setTime("5:00 Pm - 7:00 Pm");
        schedule.setScheduleType("Online");
        price = "29.99 $";
       clientsEnrolled = new ArrayList<>();
    }
    //'Program(String, String, String, String, Resources, Schedule, String)'
    public Program(String title, String duration, String difficultyLevel, String goals,
                   Content resources, Schedule schedule, String price)
    {
        this.programTitle = title;
        this.duration = duration;
        this.difficultyLevel  = difficultyLevel;
        this.goals = goals;
        this.content = resources;
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
        clientsEnrolled.add(client);
        System.out.println(client.getName());
    }

    public void addForumMessage(String title, String content) {
        System.out.println("Forum message added: " + title + ", " + content);
    }
    public void displayAllEnrolledClients()
    {

    }
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

}