package org.example;

//import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;
import java.time.LocalDate;
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
//    public List<Map<String, String>> getProgramEnrollmentStatisticsAsTable() {
//            Map<Program, Double> statistics = getProgramEnrollmentStatistics();
//
//            List<Map<String, String>> table = new ArrayList<>();
//            for (Map.Entry<Program, Double> entry : statistics.entrySet()) {
//                Map<String, String> row = new HashMap<>();
//                row.put("Program Name", entry.getKey().getTitle());
//                row.put("Enrollment Count", entry.getValue().toString());
//                table.add(row);
//            }
//
//            return table;
//    }

    public List<Map<String, String>> getProgramEnrollmentStatisticsAsTable() {
        return List.of(
                Map.of("Program Name", "Program A", "Enrollment Count", "200"),
                Map.of("Program Name", "Program B", "Enrollment Count", "180"),
                Map.of("Program Name", "Program C", "Enrollment Count", "150"),
                Map.of("Program Name", "Program D", "Enrollment Count", "120"),
                Map.of("Program Name", "Program E", "Enrollment Count", "100")
        );

    }

    @Override
    public List<Map<String, String>> generateRevenueReport(String timePeriod) {
        List<Map<String, String>> revenueReport = new ArrayList<>();
        if ("last quarter".equalsIgnoreCase(timePeriod)) {
            for (Program program : Programs) {
                double revenue = program.getClientsEnrolled().size() *Double.parseDouble( program.getPrice());
                revenueReport.add(Map.of(
                        "Program Name", program.getTitle(),
                        "Revenue", String.valueOf(revenue)
                ));
            }
        }
        return revenueReport;
    }

    @Override
       public List<Map<String, String>> getProgramStatuses() {
        List<Map<String, String>> programStatuses = new ArrayList<>();
        LocalDate currentDate = LocalDate.now(); // Get the current date

        for (Program program : Programs) {
            String status;
            if (currentDate.isBefore(convertDateToLocalDate(program.getStartDate()))) {
                status = "Upcoming";
            } else if (!currentDate.isAfter(convertDateToLocalDate(program.getEndtDate()))) {
                status = "Active";
            } else {
                status = "Completed";
            }

            programStatuses.add(Map.of(
                    "Program Name", program.getTitle(),
                    "Status", status
            ));
        }

        return programStatuses;
    }
    public String getDisplayedMessage() {
        return "No pending instructor accounts";
    }


        public static LocalDate convertDateToLocalDate(Date date) {
            return date.toInstant()                        // Convert Date to Instant
                    .atZone(ZoneId.systemDefault())   // Convert Instant to ZonedDateTime
                    .toLocalDate();                   // Convert ZonedDateTime to LocalDate
        }

}
