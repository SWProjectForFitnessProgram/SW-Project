package org.example;

//import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;
import java.time.LocalDate;
//@Service
public class Admin implements AdminService {

//    public boolean newInstructorReq=false;
//    public boolean newClientReq=false;

//    public boolean monitorUserActivity=false;
    public boolean deactivate=false;
    private boolean loggedIn=true;
    private String selectedOption;
    private final InstructorRepository instructorRepository;
    private final ClientRepository clientRepository;
    private List<Article> articles = new ArrayList<>();
    private List<HealthTip> tips = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();
    private List<Complaint> complaints = new ArrayList<>();
    private ArrayList<Program> Programs;

//    public boolean ApproveInstructorButton=false;

//    private ArrayList<Instructor> InstructorPinddingAcconnts;
//    private ArrayList<Client> ClientPinddingAcconnts;
//    private ArrayList<Instructor> Instructors;
//    private ArrayList<Client> Clients;

//    private static Admin instance;
//
//
//
//    // Allow replacing the instance for testing
//    public static void setInstance(Admin adminMock) {
//        instance = adminMock;
//    }
//    //Ghayda need to edit the default constructor
//    public Admin getInstance(InstructorRepository instructorRepository, ClientRepository clientRepository){ //singleton class
//        if(instance == null){
//            instance = new Admin(instructorRepository,clientRepository);
//            return instance;
//        }
//        else {
//            System.out.println("Instance already created!");
//            return null;
//        }
//    }
    public Admin(InstructorRepository instructorRepository, ClientRepository clientRepository) {
        this.instructorRepository = instructorRepository;
        this.clientRepository = clientRepository;
    }

    public void approveAdminLogin(){
        loggedIn=true;
    }

    public boolean isLoggedIn(){
        return loggedIn;
    }
    //1
    @Override
    public List<Instructor> getPendingInstructors() {
        return instructorRepository.findPendingInstructors();
    }
    //1
    @Override
    public List<Client> getPendingClients() {
        return clientRepository.findPendingClients();
    }
    //1
    @Override
    public void approveInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id);
        if (instructor != null) {
            instructor.approve();
            System.out.println("Instructor approved successfully.");
        } else {
            System.out.println("Instructor not found.");
        }
    }
    //1
    public void approveClient(Long id) {
        Client client = clientRepository.findById(id);
        if (client != null) {
            client.approve();
            System.out.println("Client approved successfully.");
        } else {
            System.out.println("Client not found.");
        }
    }
//1
    @Override
    public Collection<Instructor> getInstructors() {
        return instructorRepository.getAllInstructors();
    }
    @Override
    public InstructorRepository getInstructorRepository() {
        return instructorRepository;
    }
    @Override
    public Collection<Client> getClients() {
        return clientRepository.getAllClients();    }
    @Override
    public ClientRepository getClientsRepository() {
        return clientRepository;
    }

//----------------------

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

    @Override
    public void addArticle(Article article) {
        articles.add(article);
    }
    public void addTip(HealthTip tip) {
        tips.add(tip);
    }
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }
    public void approveArticle(Article article) {
        article.setStatus(UserStatus.valueOf("Approved"));
    }
    public void rejectArticle(Article article) {
        article.setStatus(UserStatus.valueOf("Rejected"));
    }
    public void approveTip(HealthTip tip) {
        tip.setStatus("Approved");
    }
    public void rejectRecipe(Recipe recipe) {
        recipe.setStatus("Rejected");
    }
    public void resolveComplaint(Complaint complaint) {
        complaint.setStatus("Resolved");
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
    public String getSelectedOption() {
        return selectedOption;
    }

    public void generateUserActivityReport() {
        System.out.println("+------------------------+------------------------------------+");
        System.out.println("| Metric                 | Description                        |");
        System.out.println("+------------------------+------------------------------------+");
        List<Map<String, String>> statistics = new ArrayList<>();

        Integer totalActiveUsers = instructorRepository.getAllInstructors().size()+clientRepository.getAllClients().size();
        Integer totalInactiveUsers =0;
        ArrayList<Instructor> instructorList = new ArrayList<>(instructorRepository.getAllInstructors());

        ArrayList<Client> clientList = new ArrayList<>(clientRepository.getAllClients());

        for(Instructor instructor : instructorList){
            if(!instructor.isApproved()){
                totalInactiveUsers++;
            }
        }
        for(Client client : clientList){
            if(!client.isActive()){
                totalInactiveUsers++;
            }
        }
        statistics.add(Map.of(
                "Metric", "Total Active Users",
                "Description", totalActiveUsers.toString()
        ));
        statistics.add(Map.of(
                "Metric", "Total Inactive Users",
                "Description", totalInactiveUsers.toString()
        ));
        statistics.add(Map.of(
                "Metric", "User Engagement Rate",
                "Description", "50%"
        ));

       // System.out.printf("| %-22s | %-34s |\n", Metric, description);

        System.out.println("+------------------------+------------------------------------+");
    }
//    public void generateInstructorActivityReport() {
//        System.out.println("+------------------------+------------------------------------+");
//        System.out.println("| Metric                 | Description                        |");
//        System.out.println("+------------------------+------------------------------------+");
//        List<Map<String, String>> statistics = new ArrayList<>();
//
//        Integer totalActiveUsers = instructorRepository.getAllInstructors().size()+clientRepository.getAllClients().size();
//        Integer totalInactiveUsers =0;
//        ArrayList<Instructor> instructorList = new ArrayList<>(instructorRepository.getAllInstructors());
//
//        ArrayList<Client> clientList = new ArrayList<>(clientRepository.getAllClients());
//
//        for(Instructor instructor : instructorList){
//            if(!instructor.isApproved()){
//                totalInactiveUsers++;
//            }
//        }
//        for(Client client : clientList){
//            if(!client.isActive()){
//                totalInactiveUsers++;
//            }
//        }
//        statistics.add(Map.of(
//                "Metric", "Total Active Users",
//                "Description", totalActiveUsers.toString()
//        ));
//        statistics.add(Map.of(
//                "Metric", "Total Inactive Users",
//                "Description", totalInactiveUsers.toString()
//        ));
//        statistics.add(Map.of(
//                "Metric", "User Engagement Rate",
//                "Description", "50%"
//        ));
//
//        // System.out.printf("| %-22s | %-34s |\n", Metric, description);
//
//
//        // Print table footer
//        System.out.println("+------------------------+------------------------------------+");
//    }
//
//    public void generateClientActivityReport() {
//        System.out.println("+------------------------+------------------------------------+");
//        System.out.println("| Metric                 | Description                        |");
//        System.out.println("+------------------------+------------------------------------+");
//        List<Map<String, String>> statistics = new ArrayList<>();
//
//        Integer totalActiveUsers = instructorRepository.getAllInstructors().size()+clientRepository.getAllClients().size();
//        Integer totalInactiveUsers =0;
//        ArrayList<Instructor> instructorList = new ArrayList<>(instructorRepository.getAllInstructors());
//
//        ArrayList<Client> clientList = new ArrayList<>(clientRepository.getAllClients());
//
//        for(Instructor instructor : instructorList){
//            if(!instructor.isApproved()){
//                totalInactiveUsers++;
//            }
//        }
//        for(Client client : clientList){
//            if(!client.isActive()){
//                totalInactiveUsers++;
//            }
//        }
//        statistics.add(Map.of(
//                "Metric", "Total Active Users",
//                "Description", totalActiveUsers.toString()
//        ));
//        statistics.add(Map.of(
//                "Metric", "Total Inactive Users",
//                "Description", totalInactiveUsers.toString()
//        ));
//        statistics.add(Map.of(
//                "Metric", "User Engagement Rate",
//                "Description", "50%"
//        ));
//
//        // System.out.printf("| %-22s | %-34s |\n", Metric, description);
//
//
//        // Print table footer
//        System.out.println("+------------------------+------------------------------------+");
//    }

}

