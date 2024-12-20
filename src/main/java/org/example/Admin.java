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


    private Map<String, String> metrics = new HashMap<>();






    public void addMetric(String name, String description) {
        metrics.put(name, description);
    }

    public String getMetricDescription(String name) {
        return metrics.get(name);
    }

    public boolean isLoggedIn(){
        return loggedIn;
    }

    public ArrayList<Instructor> InstructorPinddingAcconnts;
    public boolean ApproveInstructorButton=false;

    @Override
    public List<Instructor> getPendingInstructors(){
        for(Instructor i:InstructorPinddingAcconnts){
            System.out.println(i.email +" , " +i.password);
        }
     return null;
    }

    @Override
    public List<Client> getPendingClient() {
        return List.of();
    }

    @Override
    public Object getUserActivityReport() {
        return null;
    }

    public String getDisplayedMessage() {
        return "No pending instructor accounts";
    }
}
