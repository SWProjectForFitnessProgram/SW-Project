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
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Instructor {
    String name;
    boolean LoggedIn;
    private List<Program> programs;
    int Age;
    //    boolean approved;
    private Long id;
    String email;
    String password;

    private UserStatus status;

    public Instructor(String name, String mail,int Age)  {

        this.name = name;
        this.email = mail;
        this.Age = Age;
        programs = new ArrayList<>();
//        approved = false;


    }

    public Instructor(String email, String password,UserStatus status) {
        this.email = email;
        this.password = password;
        programs = new ArrayList<>();
//        approved = false;
    }
    public Instructor(String email, String password,String name) {
        this.email = email;
        this.password = password;
        programs = new ArrayList<>();
       this.name = name;
    }
    public void setLoggedIn(boolean b) {
        LoggedIn = true;

    }

    public Instructor() {
        this.email = "";
        this.password = "";
        programs = new ArrayList<>();
//        approved = false;
    }
    // Getter for programs list
    public List<Program> getPrograms() {
        return programs;
    }

    // Setter for programs list
    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    // Method to add a program to the instructor's list
    public void addnewProgram(Program program) {
        if (!programs.contains(program)) {
            programs.add(program);
        }
    }
    public void addProgram(String programName, List<String> clientNames)
    {
        for (Program existingProgram : programs) {
            if (existingProgram.getTitle().equals(programName))
            {
                // Add new clients to the existing program
                for (String clientName : clientNames) {
                    existingProgram.enrollClient(new Client(clientName, programName));
                }
                System.out.println("Clients added to existing program: " + programName);
                return;  // Exit once the program is found and clients are added
            }
        }
    }

    public void setName(String instructorName)
    {
        this.name = instructorName;
    }
    public String getName()
    {
        return name;
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
        this.password=newPassword;
    }

    public String getPassword() {
        return password;
    }
}