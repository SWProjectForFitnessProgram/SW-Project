package org.example;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Column;
//
//
////import org.springframework.data.annotation.Id;
//import org.springframework.stereotype.Service;
import java.util.List;

//@Entity
public class Instructor {
    String name;
    boolean LoggedIn;
    Program program;
    int Age;

//    @jakarta.persistence.Id

    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @Column(nullable = false, unique = true)
    String email;


    //    @Column(nullable = false)
    String password;

    //    @Enumerated(EnumType.STRING)
    private InstructorStatus status;
    public Instructor(String name, String mail,int Age) {

        this.name = name;
        this.email = mail;
        this.Age = Age;
        program = new Program();


    }
    public Instructor(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public void setLoggedIn(boolean b) {
        LoggedIn = true;

    }



    public Instructor() {


    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setProgram(Program program) {
        this.program = program;
    }
    public String getProgramTitle()
    {
        return program.getTitle();
    }

    public void sendMessageToClient(Client client, String message) {
        client.setMessage(message);
    }

    public void postForumMessage(Program program, String title, String content) {
        program.addForumMessage(title,content);
    }

    public void provideFeedbackToClient(Client client,String feedback)
    {
        client.receiveFeedback(feedback);
    }

    // Getters and Setters
}