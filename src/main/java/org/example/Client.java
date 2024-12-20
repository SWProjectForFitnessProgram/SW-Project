package org.example;

import io.cucumber.java.bs.A;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private Long id;
    //    @Column(nullable = false, unique = true)
    String email;
    String clientName;
    //    @Column(nullable = false)
    String password;
    //    String meesage;
    int Age;
    private List<String> messages = new ArrayList<>();
    private List<String> feedbacks = new ArrayList<>();

    //    @Enumerated(EnumType.STRING)
    private UserStatus status;
//    private String feedback;

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Client(String name,String email,int Age) {
        this.clientName = name;
        this.email = email;
        this.Age = Age;


    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String  getName() {
        return clientName;
    }
    public void setClientName (String name)
    {
        clientName = name;
    }

    public void setMessage(String message) {
        messages.add(message);
    }


    public boolean hasReceivedfeedback(String feedback) {
        if (feedbacks.contains(feedback))
        {
            return true;
        }
        else
            return false;
    }
    public void receiveMessage(String message) {
        messages.add(message);
    }

    public void receiveFeedback(String feedback) {
        feedbacks.add(feedback);
    }

    public boolean hasReceivedMessage(String message) {
        return messages.contains(message);
    }

    public boolean hasReceivedFeedback(String feedback) {
        return feedbacks.contains(feedback);
    }

    public void setWorkoutsCompleted(int doneWorkouts, int allWorkouts) {
    }

    public void setSessionsAttended(int attended, int total) {
    }

    public double getCompletionRate() {
    }

    public double getAttendanceRate() {
    }

    public String getReceivedMessage() {
    }
}