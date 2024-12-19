package org.example;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public boolean newInstructorReq=false;
    public boolean newClientReq=false;
    public boolean deactivate=false;
    public boolean monitorUserActivity=false;
    private boolean loggedIn=true;

    public boolean isLoggedIn(){
        return loggedIn;
    }

    public ArrayList<Instructor> InstructorPinddingAcconnts;
    public boolean ApproveInstructorButton=false;


    List<Instructor> getPendingInstructors(){
        for(Instructor i:InstructorPinddingAcconnts){
            System.out.println(i.email +" , " +i.password);
        }
     return null;
    }

    public String getDisplayedMessage() {
        return "No pending instructor accounts";
    }
}
