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
    private ArrayList<Program> Programs;

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
    public Map<Program, Double> getProgramEnrollmentStatistics() {
        // Map to hold program and enrollment count
        Map<Program, Double> programEnrollmentStatistics = new HashMap<>();

        // Iterate through all clients
        for (Program p : Programs) {
            programEnrollmentStatistics.put(p, Double.parseDouble(p.getPrice())*p.getClientsEnrolled().size());
        }

        return programEnrollmentStatistics; // Return the statistics
    }
    public List<Map<String, String>> getProgramEnrollmentStatisticsAsTable() {
            Map<Program, Double> statistics = getProgramEnrollmentStatistics();

            List<Map<String, String>> table = new ArrayList<>();
            for (Map.Entry<Program, Double> entry : statistics.entrySet()) {
                Map<String, String> row = new HashMap<>();
                row.put("Program Name", entry.getKey().getTitle());
                row.put("Enrollment Count", entry.getValue().toString());
                table.add(row);
            }

            return table;
    }


    public String getDisplayedMessage() {
        return "No pending instructor accounts";
    }
}
