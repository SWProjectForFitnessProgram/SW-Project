package org.example;

public class Instruct {
    String name;
    String email;
    boolean LoggedIn;
    Program program;

    public Instruct(String name, String mail) {

        this.name = name;
        this.email = mail;
        program = new Program();


    }

    public void setLoggedIn(boolean b) {
        LoggedIn = true;

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
}
