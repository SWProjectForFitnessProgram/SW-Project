package org.example;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Represents the admin of the system, responsible for managing instructors, clients, articles,
 * health tips, recipes, complaints, programs, and generating various reports. Implements the
 * AdminService interface for defining core functionalities.
 */

public class Admin implements AdminService {
    private static final int PASSWORD = 123456;
    private static final String EMAIL = "g.safw2018@gmail.com";
    private static final String NAME = "Ghayda";
    private boolean loggedIn=true;

    private String selectedOption;
    private final InstructorRepository instructorRepository;
    private final ClientRepository clientRepository;
    private final List<Article> articles = new ArrayList<>();
    private final List<HealthTip> tips = new ArrayList<>();
    private final List<Recipe> recipes = new ArrayList<>();
    private final List<Complaint> complaints = new ArrayList<>();
    private final ArrayList<Program> programs = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Main.class.getName());


    /**
     * Constructor for the Admin class.
     *
     * @param instructorRepository The repository instance for managing instructors.
     * @param clientRepository The repository instance for managing clients.
     */
    public Admin(InstructorRepository instructorRepository, ClientRepository clientRepository) {
        this.instructorRepository = instructorRepository;
        this.clientRepository = clientRepository;
    }

    /**
     * Approves the admin login by setting the loggedIn status to true.
     * This method enables the admin to perform actions restricted to logged-in users.
     */
    public void approveAdminLogin(){
        loggedIn=true;
    }

    /**
     * Checks if the current admin is logged in.
     *
     * @return true if the admin is logged in, false otherwise.
     */
    public boolean isLoggedIn(){
        return loggedIn;
    }
    /**
     * Retrieves a list of instructors who have not yet been approved.
     *
     * @return a list of {@code Instructor} objects that are pending approval.
     */
    //1
    @Override
    public List<Instructor> getPendingInstructors() {
        return instructorRepository.findPendingInstructors();
    }
    /**
     * Retrieves a list of clients who are currently pending approval.
     *
     * @return a list of {@code Client} objects that have not yet been approved.
     */
    //1
    @Override
    public List<Client> getPendingClients() {
        return clientRepository.findPendingClients();
    }

    /**
     * Retrieves a collection of all instructors available in the system.
     *
     * @return a {@code Collection} of {@code Instructor} objects representing all the instructors.
     */
    @Override
    public Collection<Instructor> getInstructors() {
        return instructorRepository.getAllInstructors();
    }
    /**
     * Retrieves the instance of the InstructorRepository for managing instructor-related data.
     *
     * @return the {@code InstructorRepository} instance associated with the admin.
     */
    @Override
    public InstructorRepository getInstructorRepository() {
        return instructorRepository;
    }
    /**
     * Retrieves a collection of all clients available in the system.
     *
     * @return a {@code Collection} of {@code Client} objects representing all the clients.
     */
    @Override
    public Collection<Client> getClients() {
        return clientRepository.getAllClients();    }

    /**
     * Retrieves the instance of the ClientRepository for managing client-related data.
     *
     * @return the {@code ClientRepository} instance associated with the admin.
     */
    @Override
    public ClientRepository getClientsRepository() {
        return clientRepository;
    }

    /**
     * Adds a program to the admin's list of programs.
     *
     * @param program The program to be added.
     */
    public void addProgram(Program program) {
        programs.add(program);
    }
    /**
     * Retrieves the top five programs based on the number of clients enrolled,
     * along with their respective enrollment statistics. The programs are sorted
     * in descending order based on enrollment count.
     *
     * @return a list of maps, where each map contains the program title as the key
     *         and the number of clients enrolled in that program as the value.
     */
    public List<Map<String, Integer>> getProgramEnrollmentStatisticsAsTable() {
        List<Map<String,Integer>> top5programs = new ArrayList<>();
        for(Program p : programs){
            Map<String, Integer> temp = new HashMap<>();
            temp.put(p.getTitle(),p.getClientsEnrolled().size());
            top5programs.add(temp);
        }

        top5programs.sort((map1, map2) -> {

            Integer value1 = map1.values().iterator().next();
            Integer value2 = map2.values().iterator().next();

            return value2.compareTo(value1);
        });


        logger.log(Level.INFO, "Top 5 programs:");
        for (int i = 0; i < Math.min(5, top5programs.size()); i++) {
            Map<String, Integer> program = top5programs.get(i);

            String programNAME = program.keySet().iterator().next();
            Integer revenue = program.values().iterator().next();

            System.out.printf("%d. Program Name: %s - Enrollment: %d%n", (i + 1), programNAME, revenue);
        }
        return top5programs;
    }
    /**
     * Generates a revenue report for all programs managed by the admin.
     * The report includes the program name and the total revenue generated
     * based on the number of clients enrolled and the price of the program.
     *
     * @return a list of maps where each map contains:
     *         "Program NAME" - the title of the program
     *         "Revenue" - the total revenue generated by the program
     */
    public List<Map<String, String>> getRevenueReport() {

        List<Map<String, String>> revenueReport = new ArrayList<>();
        for (Program program : programs) {
            double revenue = program.getClientsEnrolled().size() *Double.parseDouble( program.getPrice());
            revenueReport.add(Map.of(
                    "Program Name", program.getTitle(),
                    "Revenue", String.valueOf(revenue)
            ));
        }
        return revenueReport;
    }
    /**
     * Retrieves the statuses of all programs as a table, represented as a list of maps.
     * Each map contains the following keys:
     * - "Program NAME" - the name of the program.
     * - "Status" - the status of the program ("Upcoming", "Active", or "Completed").
     *
     * The program status is determined based on its start and end dates relative to the current date:
     * - "Upcoming": The program starts in the future.
     * - "Active": The program is currently active.
     * - "Completed": The program has already finished.
     *
     * @return a list of maps where each map represents a program and its corresponding status.
     */
    public List<Map<String, String>> getProgramStatusesAsTable() {
        List<Map<String,String>> resutl = new ArrayList<>();
        for(Program p : programs){
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

    /**
     * Adds an article to the admin's collection of articles.
     *
     * @param article The {@code Article} object to be added.
     */
    @Override
    public void addArticle(Article article) {
        articles.add(article);
    }
    /**
     * Adds a health tip to the admin's*/
    public void addTip(HealthTip tip) {
        tips.add(tip);
    }

    /**
     * Adds a recipe to the admin's collection of recipes.
     *
     * @param recipe The {@code Recipe} object to be added to the collection.
     */
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    /**
     * Adds a complaint to the admin's collection of complaints.
     *
     * @param complaint The complaint object to be added.
     */
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }
    /**
     * Approves the specified article by updating its status to "Approved".
     *
     * @param article The {@code Article} object whose status is to be set to approved.
     */
    public void approveArticle(Article article) {
        article.setStatus(UserStatus.valueOf("Approved"));
    }
    /**
     * Updates the status of the provided article to "Rejected".
     *
     * @param article The {@code Article} object whose status is to be updated to rejected.
     */
    public void rejectArticle(Article article) {
        article.setStatus(UserStatus.valueOf("Rejected"));
    }
    /**
     * Approves the specified health tip by updating its status to "Approved".
     *
     * @param tip The {@code HealthTip} object whose status is to be set to approved.
     */
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

    public String getEMAIL() {
        return EMAIL;
    }
    public String getNAME() {
        return NAME;
    }
//    public int getPASSWORD() {
//        return PASSWORD;
//    }

    public boolean isSignedIn(String EMAIL){
        boolean isLoggedIn = false;
        if(instructorRepository.findInstructorByEmail(EMAIL)==null){
            if(clientRepository.findClientByEmail(EMAIL)==null){
                isLoggedIn= false;
            }
            else isLoggedIn= true;
        }
        return isLoggedIn;
    }
    public boolean signUp(Role role,String NAME, String EMAIL,Integer Age , String PASSWORD){
        boolean signUpResult;

        if (!EMAIL.endsWith("@gmail.com") || Age < 18 || PASSWORD.length() < 8) {
            signUpResult = false;
            System.out.println( "The operation is not allowed: Invalid EMAIL, age must be 18 or older or PASSWORD must be at least 8 characters.");
        } else {

            if(isSignedIn(EMAIL)){
                System.out.println("You are already signed in.");
                return false;
            }
            if(role == Role.INSTRUCTOR) {
                Instructor instructor = new Instructor(EMAIL, PASSWORD, NAME, Age, UserStatus.Pending);
                instructorRepository.addInstructor(instructor);
            }
            else if(role == Role.CLIENT) {
                Client client = new Client(NAME, EMAIL, Age, PASSWORD, UserStatus.Pending);
                this.clientRepository.addClient(client);
            }

            System.out.println("The Admin will approve your account as soon as possible.");
            signUpResult = true;
        }

        return signUpResult;

    }

    public boolean signIn(Role role,String EMAIL, String password) {
        Instructor instructor = instructorRepository.findInstructorByEmail(EMAIL);
        Client client = clientRepository.findClientByEmail(EMAIL);
        if (instructor == null && client == null && role!=Role.ADMIN) {
            System.out.println("Invalid EMAIL or PASSWORD.");
            return false;
        }
        switch (role){
            case INSTRUCTOR:
                assert instructor != null;
                if(instructor.getPassword().equals(password)){
                    instructor.setLoggedIn(true);
                    System.out.println("You have signed in successfully.");
                    return true;
                }
                return false;

            case CLIENT:
                assert client != null;
                if(client.getPassword().equals(password)){
                    client.setLoggedIn(true);
                    System.out.println("You have signed in successfully.");
                    return true;
                }
                return false;

            case ADMIN:

                if(password.equals(String.valueOf(PASSWORD) ) ){
                    this.loggedIn=true;
                    System.out.println("You have signed in successfully.");
                    return true;
                }
                else {
                    System.out.println("Invalid EMAIL or PASSWORD.");
                    return false;
                }

            default: return false;

        }


    }





}

