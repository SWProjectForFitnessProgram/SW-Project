package org.example;

////import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Instructor in the system, who can manage programs, interact with clients,
 * and handle subscription plans and status within the platform.
 */
public class Instructor {
    String name;
    boolean LoggedIn;
    private List<Program> programs;
    int Age;
    private Long id;
    String email;
    String password;
    private SubscriptionPlan subscriptionPlan;
    private UserStatus status;

    public Instructor(String name, String mail,int Age)  {

        this.name = name;
        this.email = mail;
        this.Age = Age;
        programs = new ArrayList<>();



    }

    public Instructor(String email, String password,UserStatus status) {
        this.email = email;
        this.password = password;

    }
    public Instructor(String email, String password,String name) {
        this.email = email;
        this.password = password;
        programs = new ArrayList<>();
       this.name = name;

    }
    public Instructor(String email, String password,String name,Integer Age,UserStatus status) {
        this.email = email;
        this.password = password;
        programs = new ArrayList<>();
        this.name = name;
        this.Age = Age;
        this.status = status;

    }


    public List<Program> getPrograms() {
        return programs;
    }


    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public void addnewProgram(Program program) {
        if (!programs.contains(program)) {
            programs.add(program);
        }
        else
            System.out.println("The program ' " + program.getTitle() +" '"+"you want to add already exist :)");
    }

    public void setName(String instructorName)
    {
        this.name = instructorName;
    }
    public String getName()
    {
        return name;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
    public UserStatus getStatus() {
        return status;
    }
    public boolean isApproved() {
        return status == UserStatus.Approved;
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