package org.example;

//import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@Service
public class Admin implements AdminService {
    public boolean newInstructorReq=false;
    public boolean newClientReq=false;
    public boolean deactivate=false;
    public boolean monitorUserActivity=false;
    private boolean loggedIn=true;
//    private Map<String, String> metrics = new HashMap<>();
    private ArrayList<Instructor> InstructorPinddingAcconnts;
    private ArrayList<Client> ClientPinddingAcconnts;
    private ArrayList<Instructor> Instructors;
    private ArrayList<Client> Clients;


    public boolean ApproveInstructorButton=false;


    public boolean isLoggedIn(){
        return loggedIn;
    }
    @Override
    public List<Instructor> getPendingInstructors(){
        for(Instructor i:InstructorPinddingAcconnts){
            System.out.println(i.email +" , " +i.password);
        }
     return InstructorPinddingAcconnts;
    }

    @Override
    public List<Client> getPendingClient() {
        return List.of();
    }

    @Override
    public Object getUserActivityReport() {
        return null;
    }

    @Override
    public Map<Program, Integer> getProgramEnrollmentStatistics() {
        // Map to hold program and enrollment count
        Map<Program, Integer> programEnrollmentStatistics = new HashMap<>();

        // Iterate through all clients
        for (Client c : Clients) {
            Program p = c.getProgram(); // Get the program of the client

            // Increment the enrollment count for the program
            programEnrollmentStatistics.put(p, programEnrollmentStatistics.getOrDefault(p, 0) + 1);
        }

        return programEnrollmentStatistics; // Return the statistics
    }

    public String getDisplayedMessage() {
        return "No pending instructor accounts";
    }
}
