package org.example;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    public boolean newInstructorReq=false;
    public boolean newClientReq=false;
    public boolean deactivate=false;
    public boolean monitorUserActivity=false;
    public boolean loggedIn=false;

    public ArrayList<Instructor> InstructorPinddingAcconnts;
    public boolean ApproveInstructorButton=false;


    List<Instructor> getPendingInstructors(){
        for(Instructor i:InstructorPinddingAcconnts){
            System.out.println(i.email +" , " +i.password);
        }
     return null;
    }
}
