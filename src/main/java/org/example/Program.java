package org.example;

import java.util.ArrayList;
import java.util.List;

public class Program {
    List<Client> clientsEnrolled;
    String programTitle;
    String duration;
    String difficultyLevel;
    String goals;
    String content;
    String price;
    public Program()
    {
        //new Program("Get Fit & Moving Challenge", "30 days", "Beginners", "Weight Loss, Full Body", "https://youtu.be/f3zOrYCwquE", "29.99 $")
        programTitle = "Get Fit & Moving Challenge";
        duration = "30 days";
        difficultyLevel = "Beginners";
        goals = "Weight Loss, Full Body";
        content = "https://youtu.be/f3zOrYCwquE";
        price = "29.99 $";
    }
    public Program(String programTitle, String duration, String difficultyLevel, String goals, String content, String price) {
        this.programTitle = programTitle;
        this.duration = duration;
        this.difficultyLevel  = difficultyLevel;
        this.goals = goals;
        this.content = content;
        this.price = price;
        clientsEnrolled = new ArrayList<>();
    }

    public String getTitle() {
        return programTitle;
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

    public void setContent(String content) {
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

    public String getContent() {
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

}
