package org.example;

import io.cucumber.java.bs.A;

public class Client {

    private Long id;

    //    @Column(nullable = false, unique = true)
    String email;
    String clientName;
    //    @Column(nullable = false)
    String password;
    String meesage;
    int Age;

    //    @Enumerated(EnumType.STRING)
    private InstructorStatus status;
    private String feedback;

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
        this.meesage = message;
    }

    public void receiveFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean hasReceivedMessage(String message) {
        if(this.meesage.equals(message))
        {
            return true;
        }
        else
            return false;
    }
}