package org.example;
import java.time.ZoneId;
import java.util.*;
import java.time.LocalDate;
//@Service
/**
 * Represents an admin with the ability to manage instructors, clients, articles, tips, recipes, programs, and complaints.
 * Provides various functionalities like approving logins, fetching pending users, and generating reports.
 *
 * @author gaidaa
 */
public class Admin implements AdminService {
    private final int password = 123456;
    private final String email = "g.safw2018@gmail.com";

    private final String name = "Ghayda";
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

    /**
     * Constructs an Admin instance with the given repositories.
     *
     * @param instructorRepository the repository to manage instructors.
     * @param clientRepository the repository to manage clients.
     */

    public Admin(InstructorRepository instructorRepository, ClientRepository clientRepository) {
        this.instructorRepository = instructorRepository;
        this.clientRepository = clientRepository;
    }
    /**
     * Approves the admin login by setting the loggedIn status to true.
     */
    public void approveAdminLogin(){
        loggedIn=true;
    }
    /**
     * Checks if the admin is logged in.
     *
     * @return true if the admin is logged in, false otherwise.
     */
    public boolean isLoggedIn(){
        return loggedIn;
    }
    /**
     * Retrieves the list of pending instructors.
     *
     * @return a list of pending instructors.
     */
    //1
    @Override
    public List<Instructor> getPendingInstructors() {
        return instructorRepository.findPendingInstructors();
    }
    /**
     * Retrieves the list of pending clients.
     *
     * @return a list of pending clients.
     */
    //1
    @Override
    public List<Client> getPendingClients() {
        return clientRepository.findPendingClients();
    }
    //1
//    @Override
//    public void approveInstructor(Long id) {
//        Instructor instructor = instructorRepository.findById(id);
//        if (instructor != null) {
//            instructor.approve();
//            System.out.println("Instructor approved successfully.");
//        } else {
//            System.out.println("Instructor not found.");
//        }
//    }
    //1
//    public void approveClient(Long id) {
//        Client client = clientRepository.findById(id);
//        if (client != null) {
//            client.approve();
//            System.out.println("Client approved successfully.");
//        } else {
//            System.out.println("Client not found.");
//        }
//    }
//1
    /**
     * Retrieves all instructors from the repository.
     *
     * @return a collection of all instructors.
     */
    @Override
    public Collection<Instructor> getInstructors() {
        return instructorRepository.getAllInstructors();
    }
    /**
     * Retrieves the instructor repository.
     *
     * @return the instructor repository instance.
     */
    @Override
    public InstructorRepository getInstructorRepository() {
        return instructorRepository;
    }
    /**
     * Retrieves all clients from the repository.
     *
     * @return a collection of all clients.
     */
    @Override
    public Collection<Client> getClients() {
        return clientRepository.getAllClients();    }
    /**
     * Retrieves the client repository.
     *
     * @return the client repository instance.
     */
    @Override
    public ClientRepository getClientsRepository() {
        return clientRepository;
    }

//----------------------

//    @Override
//    public Object getUserActivityReport() {
//        return null;
//    }
    /**
     * Generates a table of program enrollment statistics.
     *
     * @return a list of maps, each representing a program's name and enrollment statistics.
     */

    public List<Map<String, String>> getProgramEnrollmentStatisticsAsTable() {
            Map<Program, Double> programEnrollmentStatistics = new HashMap<>();
            for (Program p : Programs) {
                programEnrollmentStatistics.put(p, Double.parseDouble(p.getPrice())*p.getClientsEnrolled().size());
            }

            Map<Program, Double> statistics = programEnrollmentStatistics;
            List<Map<String, String>> table = new ArrayList<>();
            for (Map.Entry<Program, Double> entry : statistics.entrySet()) {
                Map<String, String> row = new HashMap<>();
                row.put("Program Name", entry.getKey().getTitle());
                row.put("Enrollment Count", entry.getValue().toString());
                table.add(row);
            }

            return table;
    }

    /**
     * Generates a revenue report for the specified time period.
     *
     * @param timePeriod the time period for which to generate the report (e.g., "last quarter").
     * @return a list of maps, each containing the program name and revenue.
     */
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
    /**
     * Retrieves the statuses of all programs.
     *
     * @return a list of maps, each containing a program's name and status.
     */
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

//    public String getDisplayedMessage() {
//        return "No pending instructor accounts";
//    }

    /**
     * Converts a Date to a LocalDate.
     *
     * @param date the Date to convert.
     * @return the corresponding LocalDate.
     */
    public static LocalDate convertDateToLocalDate(Date date) {
        return date.toInstant()                        // Convert Date to Instant
                .atZone(ZoneId.systemDefault())   // Convert Instant to ZonedDateTime
                .toLocalDate();                   // Convert ZonedDateTime to LocalDate
    }
    /**
     * Adds an article to the admin's list of articles.
     *
     * @param article the article to add.
     */
    @Override
    public void addArticle(Article article) {
        articles.add(article);
    }
    /**
     * Adds a health tip to the list of tips.
     * @param tip the health tip to add
     */
    public void addTip(HealthTip tip) {
        tips.add(tip);
    }
    /**
     * Adds a recipe to the list of recipes.
     * @param recipe the recipe to add
     */
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    /**
     * Adds a complaint to the list of complaints.
     * @param complaint the complaint to add
     */
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }
    /**
     * Approves the specified article by setting its status to "Approved".
     * @param article the article to approve
     */
    public void approveArticle(Article article) {
        article.setStatus(UserStatus.valueOf("Approved"));
    }
    /**
     * Rejects the specified article by setting its status to "Rejected".
     * @param article the article to reject
     */
    public void rejectArticle(Article article) {
        article.setStatus(UserStatus.valueOf("Rejected"));
    }
    /**
     * Approves the specified health tip by setting its status to "Approved".
     * @param tip the health tip to approve
     */
    public void approveTip(HealthTip tip) {
        tip.setStatus("Approved");
    }
    /**
     * Rejects the specified recipe by setting its status to "Rejected".
     * @param recipe the recipe to reject
     */
    public void rejectRecipe(Recipe recipe) {
        recipe.setStatus("Rejected");
    }
    /**
     * Resolves the specified complaint by setting its status to "Resolved".
     * @param complaint the complaint to resolve
     */
    public void resolveComplaint(Complaint complaint) {
        complaint.setStatus("Resolved");
    }
    /**
     * Sets the selected option.
     * @param selectedOption the option to set
     */
    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }
    /**
     * Gets the currently selected option.
     * @return the selected option
     */
    public String getSelectedOption() {
        return selectedOption;
    }
    /**
     * Generates a report of user activity metrics and prints it to the console.
     */
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
    /**
     * Gets the admin's email address.
     * @return the email address
     */
    public String getEmail() {
        return email;
    }
    /**
     * Gets the admin's name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the admin's password.
     * @return the password
     */
    public int getPassword() {
        return password;
    }
    /**
     * Checks if the user with the specified email is signed in.
     * @param email the email to check
     * @return true if the user is signed in, false otherwise
     */
    public boolean isSignedIn(String email){
        if(instructorRepository.findInstructorByEmail(email)==null){
            if(clientRepository.findClientByEmail(email)==null){
                return false;
            }
            else return true;
        }
        return true;
    }
    /**
     * Registers a new instructor if the email is not already in use.
     * @param name the instructor's name
     * @param email the instructor's email
     * @param password the instructor's password
     * @return true if the instructor is registered successfully, false otherwise
     */
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

