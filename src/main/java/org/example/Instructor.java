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
    private Long id;
    String email;
    String password;

    private UserStatus status;

    public Instructor(String name, String mail,int Age)  {

        this.name = name;
        this.email = mail;
        this.Age = Age;
        program = new Program();
        this.status = UserStatus.Pending;
    }
    public Instructor(String mail, String password,String Name)  {

        this.name = name;
        this.password = password;
        this.email = mail;
//        program = new Program();
        this.status = UserStatus.Pending;
    }

    public Instructor(String email, String password,UserStatus status) {
        this.email = email;
        this.password = password;
        this.status =status;
    }


    public void setLoggedIn(boolean b) {
        LoggedIn = true;

    }

    public Instructor() {
        this.email = "";
        this.password = "";
//        approved = false;
    }
    public boolean isApproved() {
       if(status == UserStatus.Approved) {
           return true;
       }
       else return false;
    }
    public void approve() {
        this.status = UserStatus.Approved;
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
        program.addForumMessage(title, content);
    }

    public void provideFeedbackToClient(Client client, String feedback) {
        client.receiveFeedback(feedback);
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}