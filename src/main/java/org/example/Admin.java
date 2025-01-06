package org.example;
import java.time.ZoneId;
import java.util.*;
import java.time.LocalDate;
//@Service
public class Admin implements AdminService {
    private static final int password = 123456;
    private static final String email = "g.safw2018@gmail.com";

    private static final String name = "Ghayda";
    public boolean deactivate=false;
    private boolean loggedIn=true;
    private String selectedOption;
    private final InstructorRepository instructorRepository;
    private final ClientRepository clientRepository;
    private List<Article> articles = new ArrayList<>();
    private List<HealthTip> tips = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();
    private List<Complaint> complaints = new ArrayList<>();
    private ArrayList<Program> Programs = new ArrayList<>();



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

    public void addProgram(Program program) {
        Programs.add(program);
    }
    public List<Map<String, Integer>> getProgramEnrollmentStatisticsAsTable() {
        List<Map<String,Integer>> Top5Programs = new ArrayList<>();
        for(Program p : Programs){
            Map<String, Integer> temp = new HashMap<>();
            temp.put(p.getTitle(),p.getClientsEnrolled().size());
            Top5Programs.add(temp);
        }
        Top5Programs.sort((map1, map2) -> {

            Integer value1 = map1.values().iterator().next();
            Integer value2 = map2.values().iterator().next();

            return value2.compareTo(value1);
        });

        if (Top5Programs.size() > 5) {
            Top5Programs = Top5Programs.subList(0, 5); // Keep only the top 5
        }

        System.out.println("Top 5 Programs:");
        for (int i = 0; i < Math.min(5, Top5Programs.size()); i++) {
            Map<String, Integer> program = Top5Programs.get(i);

            String programName = program.keySet().iterator().next();
            Integer revenue = program.values().iterator().next();

            System.out.printf("%d. Program Name: %s - Enrollment: %d%n", (i + 1), programName, revenue);
        }
        return Top5Programs;
    }
    public List<Map<String, String>> getRevenueReport() {

        List<Map<String, String>> revenueReport = new ArrayList<>();
        for (Program program : Programs) {
            double revenue = program.getClientsEnrolled().size() *Double.parseDouble( program.getPrice());
            revenueReport.add(Map.of(
                    "Program Name", program.getTitle(),
                    "Revenue", String.valueOf(revenue)
            ));
        }
        return revenueReport;
    }
    public List<Map<String, String>> getProgramStatusesAsTable() {
        List<Map<String,String>> resutl = new ArrayList<>();
        for(Program p : Programs){
            if(p.getStartDate().after(new Date())){
                resutl.add(Map.of(
                        "Program Name", p.getTitle(),
                        "Status", "Upcoming"
                ));
            }
            else if(p.getEndtDate().after(new Date())){
                resutl.add(Map.of(
                        "Program Name", p.getTitle(),
                        "Status", "Active"
                ));
            }
            else if(p.getEndtDate().before(new Date())){
                resutl.add(Map.of(
                        "Program Name", p.getTitle(),
                        "Status", "Completed"
                ));
            }
        }
        return resutl;
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
        Double percentage = 0.0;
        for(Instructor instructor : instructorList){
            if(!instructor.isApproved()){
                totalInactiveUsers++;
            }
        }
        for(Client client : clientList){
            if(!client.isActive()){
                totalInactiveUsers++;
            }
            else{
                percentage += Double.parseDouble(String.valueOf((client.getWorkoutsCompleted()+client.getSessionsAttended())/(client.getTotalSessions()+client.getTotalWorkouts())));
            }

        }
        percentage = percentage/clientList.size();
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
                "Description", percentage.toString() + "%"
        ));

       // System.out.printf("| %-22s | %-34s |\n", Metric, description);

        System.out.println("+------------------------+------------------------------------+");
    }

    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public int getPassword() {
        return password;
    }

    public boolean isSignedIn(String email){
        if(instructorRepository.findInstructorByEmail(email)==null){
            if(clientRepository.findClientByEmail(email)==null){
                return false;
            }
            else return true;
        }
        return true;
    }
    public boolean signUpInstructor(String name, String email, String password) {
        if (!this.isSignedIn(email)) {
            Instructor instructor = new Instructor(name, email, password);
            instructor.setStatus(UserStatus.Pending);
            instructorRepository.addInstructor(instructor);
            return true;
        }
        else return false;
    }
    public boolean signUpClient(String name, String email, String password) {
        if (!this.isSignedIn(email)) {
            Client client = new Client(name, email, password);
            client.setStatus(UserStatus.Pending);
            clientRepository.addClient(client);
            return true;
        }
        else return false;
    }
}

