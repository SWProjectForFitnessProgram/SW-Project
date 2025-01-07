package org.example;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.ZoneId;
import java.util.*;
import java.time.LocalDate;
/**
 * Represents the admin of the system, responsible for managing instructors, clients, articles,
 * health tips, recipes, complaints, programs, and generating various reports. Implements the
 * AdminService interface for defining core functionalities.
 */
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
     * Retrieves the {@code InstructorRepository} instance associated with the admin.
     *
     * @return the {@code InstructorRepository} that manages instructor-related data and operations.
     */
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

//        if (Top5Programs.size() > 5) {
//            Top5Programs = Top5Programs.subList(0, 5); // Keep only the top 5
//        }

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
//
//    @Override
//    public List<Map<String, String>> generateRevenueReport(String timePeriod) {
//        List<Map<String, String>> revenueReport = new ArrayList<>();
//        if ("last quarter".equalsIgnoreCase(timePeriod)) {
//            for (Program program : Programs) {
//                double revenue = program.getClientsEnrolled().size() *Double.parseDouble( program.getPrice());
//                revenueReport.add(Map.of(
//                        "Program Name", program.getTitle(),
//                        "Revenue", String.valueOf(revenue)
//                ));
//            }
//        }
//        return revenueReport;
//    }
//
//    @Override
//       public List<Map<String, String>> getProgramStatuses() {
//        List<Map<String, String>> programStatuses = new ArrayList<>();
//        LocalDate currentDate = LocalDate.now(); // Get the current date
//
//        for (Program program : Programs) {
//            String status;
//            if (currentDate.isBefore(convertDateToLocalDate(program.getStartDate()))) {
//                status = "Upcoming";
//            } else if (!currentDate.isAfter(convertDateToLocalDate(program.getEndtDate()))) {
//                status = "Active";
//            } else {
//                status = "Completed";
//            }
//
//            programStatuses.add(Map.of(
//                    "Program Name", program.getTitle(),
//                    "Status", status
//            ));
//        }
//
//        return programStatuses;
//    }


//    public static LocalDate convertDateToLocalDate(Date date) {
//        return date.toInstant()                        // Convert Date to Instant
//                .atZone(ZoneId.systemDefault())   // Convert Instant to ZonedDateTime
//                .toLocalDate();                   // Convert ZonedDateTime to LocalDate
//    }

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
    public boolean signUp(Role role,String name, String email,Integer Age , String password){
        boolean signUpResult;

        if (!email.endsWith("@gmail.com") || Age < 18 || password.length() < 8) {
            signUpResult = false;
            System.out.println( "The operation is not allowed: Invalid email, age must be 18 or older or password must be at least 8 characters.");
        } else {

            if(isSignedIn(email)){
                System.out.println("You are already signed in.");
                return false;
            }
            if(role == Role.INSTRUCTOR) {
                Instructor instructor = new Instructor(email, password, name, Age, UserStatus.Pending);
                instructorRepository.addInstructor(instructor);
            }
            else if(role == Role.CLIENT) {
                Client client = new Client(name, email, Age, password, UserStatus.Pending);
                this.clientRepository.addClient(client);
            }
//            String subject = "Approval Notification";
//            String messageContent = "Your account has been approved!";
//            sendEmail(email, subject, messageContent);
            System.out.println("The Admin will approve your account as soon as possible.");
            signUpResult = true;
        }

        return signUpResult;

    }

    public boolean signIn(Role role,String email, String password) {
        Instructor instructor = instructorRepository.findInstructorByEmail(email);
        Client client = clientRepository.findClientByEmail(email);
        if (instructor == null && client == null && role!=Role.ADMIN) {
            System.out.println("Invalid email or password.");
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
                else{
                    System.out.println("Invalid email or password.");
                    return false;
                }
            case CLIENT:
                if(client.getPassword().equals(password)){
                    client.setLoggedIn(true);
                    System.out.println("Client-You have signed in successfully.");
                    return true;
                }
                else{
                    System.out.println("Client - Invalid email or password.");
                    return false;
                }
            case ADMIN:
                if(password.equals("123456") ){
                    this.loggedIn=true;
                    System.out.println("Admin - You have signed in successfully.");
                    return true;
                }
                else {
                    System.out.println("Admin - Invalid email or password.");
                    return false;
                }
            default:{
                System.out.println("Invalid role.");
                return false;
            }
        }


    }





//    /**
//     * Sends an email to the specified recipient with a given subject and message content.
//     *
//     * @param recipientEmail the email address of the recipient
//     * @param subject the subject of the email
//     * @param messageContent the content of the email message
//     */
//    public static void sendEmail(String recipientEmail, String subject, String messageContent) {
//
//        String senderEmail = "g.safw2018@gmail.com";
//        String senderPassword = "Gh1a2s3S45";
//
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com"); // Replace with your SMTP host
//        properties.put("mail.smtp.port", "587");
//
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(senderEmail, senderPassword);
//            }
//        });
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(senderEmail));
//            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
//            message.setSubject(subject);
//            message.setText(messageContent);
//
//            Transport.send(message);
//            System.out.println("Email sent successfully!");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            System.err.println("Error while sending email: " + e.getMessage());
//        }
//
//    }

}

