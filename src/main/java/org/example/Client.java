package org.example;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private boolean receivedNotification = false; //flag
    private String notification;
    private SubscriptionPlan subscriptionPlan;

    private List<Program> enrolledPrograms ;
    private int workoutsCompleted;
    private int totalWorkouts;
    private int sessionsAttended;
    private int totalSessions;
    private String receivedMessage;
    private Long id;
    String email;
    String clientName;
    String password;
    int Age;
    boolean approved =false ;
    boolean LoggedIn;
    private final List<String> messages = new ArrayList<>();
    private final List<String> feedbacks = new ArrayList<>();
    private UserStatus status;

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
        enrolledPrograms = new ArrayList<>();
    }
    public Client(String email, String password,String clientName) {
        this.clientName = clientName;
        this.email = email;
        this.password = password;
    }
    public Client(String email, String password,UserStatus status) {
        this.email = email;
        this.password = password;
        this.status = status;
    }
    public Client(String name,String email,int Age ) {
        this.clientName = name;
        this.email = email;
        this.Age = Age;
        enrolledPrograms = new ArrayList<>();
    }
    public Client(String name,Long id,String email,int Age) {
        this.clientName = name;
        this.email = email;
        this.Age = Age;
        this.id = id;
        enrolledPrograms = new ArrayList<>();

    }
    public Client(String name,String email,int Age ,String password,UserStatus status ) {
        this.clientName = name;
        this.email = email;
        this.Age = Age;
        enrolledPrograms = new ArrayList<>();
        this.password = password;
        this.status = status;

    }
    public Client(String name) {
        clientName = name;
        enrolledPrograms = new ArrayList<>();
    }
    public void enrollProgram(Program program)
    {
        if (!enrolledPrograms.contains(program)) {
            enrolledPrograms.add(program);
        } else {
            System.out.println( clientName + " is already enrolled in program: " + program.getTitle());
        }
    }
    public List<Program> getEnrolledPrograms() {
        return enrolledPrograms;
    }
    public void displayEnrolledPrograms() {
        System.out.println( clientName + "'s Enrolled Programs:");
        for (Program program : enrolledPrograms) {
            System.out.println("- " + program.getTitle());
        }
    }
    public int getWorkoutsCompleted() { return workoutsCompleted; }
    public int getTotalWorkouts() { return totalWorkouts; }
    public int getTotalSessions() { return totalSessions; }
    public int getSessionsAttended() { return sessionsAttended; }

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
        this.workoutsCompleted = doneWorkouts;
        this.totalWorkouts = allWorkouts;
    }

    public void setSessionsAttended(int sessionsAttended, int totalSessions) {
        this.sessionsAttended = sessionsAttended;
        this.totalSessions = totalSessions;
    }
    public double getCompletionRate() {
        if (totalWorkouts == 0) return 0;
        return (double) workoutsCompleted / totalWorkouts * 100;
    }
    public double getAttendanceRate() {
        if (totalSessions == 0) {
            return 0; // Avoid division by zero
        }
        return (double) sessionsAttended / totalSessions * 100;
    }

    public String getReceivedMessage() { return receivedMessage; }
    public void setReceivedMessage(String message) { this.receivedMessage = message; }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }

    public Object getEmail() {
        return email;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String newName) {
        this.clientName = newName;
    }
    public boolean hasRecievedNotification()
    {
        return receivedNotification;
    }
    public void setNotification(String notification)
    {
        this.notification = notification;
        receivedNotification = true;
    }
    public boolean isActive() {
        if(status==UserStatus.Approved){
            return true;
        }
        else return false;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
    public UserStatus getStatus() {
        return status;
    }
    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }
    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public void setLoggedIn(boolean b) {
        LoggedIn = true;
    }
}