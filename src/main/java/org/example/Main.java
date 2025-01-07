package org.example;
import java.util.*;


public class Main {
    private static List<Client> clients = new ArrayList<>();
    private static List<Program> programs = new ArrayList<>();
    private static List<Instructor> instructors = new ArrayList<>();
    private static ProgramService programService = new ProgramService();
    private static User currentUser = new User();
    private static Profile currentProfile = new Profile();
    private static ProgramManager programManager = new ProgramManager();
    private static FeedbackAndReviewsManager feedbackManager = new FeedbackAndReviewsManager();
    private static ProgressManager progressManager = new ProgressManager();


    public static void main(String[] args) {
        initializeMockData();
        Scanner scanner = new Scanner(System.in);
       while(true)
       {
           String mainChoice;
           System.out.println("==== Fitness Management System ====");
           System.out.println("1. Admin");
           System.out.println("2. Instructor");
           System.out.println("3. Client");
           System.out.println("4. Exit");
           System.out.print("Select an option : ");
           mainChoice = scanner.next();
           switch (mainChoice) {
               case "1" :
                   adminMenu(scanner);
                   break;
               case "2" :
                   instructorMenu(scanner);
                   break;
               case "3" :
                   clientMenu(scanner);
                   break;
               case "4" :
                   System.out.println("Thank you for using our Fitness program :)");
                   return;
               default :
                   System.err.println("Invalid input!\nPlease try again.");
           }

       }
    }
    private static void initializeMockData() {
        Content mockResources = new Content(
                "https://youtu.be/f3zOrYCwquE",
                "https://unsplash.com/s/photos/gym",
                "https://www.everydayhealth.com/fitness/guide/"
        );

        Schedule mockSchedule1 = new Schedule(
                new String[]{"Sunday", "Tuesday", "Thursday"},
                "8:00 AM - 10:00 AM",
                "Online"
        );
        Schedule mockSchedule2 = new Schedule(
                new String[]{"Sunday", "Tuesday", "Thursday"},
                "5:00 PM - 7:00 PM",
                "Online"
        );

        Program mockProgram1 = new Program(
                "Get Fit & Moving Challenge",
                "30 days",
                "Beginners",
                "Weight Loss, Full Body",
                mockResources,
                mockSchedule1,
                "29.99 $"
        );

        Program mockProgram2 = new Program(
                "Strength & Endurance Training",
                "6 weeks",
                "Intermediate",
                "Strength, Endurance",
                mockResources,
                mockSchedule2,
                "39.99 $"
        );

        Client client1 = new Client("Alice", "alice@example.com", 25);
        client1.setId(Long.parseLong("12215614"));
        Client client2 = new Client("Bob", "bob@example.com", 30);
        client2.setId(Long.parseLong("12213611"));
        Client client3 = new Client("Charlie", "charlie@example.com", 35);
        client3.setId(Long.parseLong("12112569"));

        Instructor instructor1 = new Instructor("John Doe", "johndoe@example.com", 30);
        Instructor instructor2 = new Instructor("Jane Smith", "janesmith@example.com", 28);

        mockProgram1.enrollClient(client1);
        mockProgram1.enrollClient(client2);
        mockProgram2.enrollClient(client3);

        instructor1.addnewProgram(mockProgram1);
        instructor2.addnewProgram(mockProgram2);

        client1.enrollProgram(mockProgram1);
        client2.enrollProgram(mockProgram1);
        client3.enrollProgram(mockProgram2);

        programService.addProgram(mockProgram1);
        programService.addProgram(mockProgram2);

        programs.add(mockProgram1);
        programs.add(mockProgram2);
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        instructors.add(instructor1);
        instructors.add(instructor2);
    }

    private static void instructorMenu(Scanner scanner) {
        while (true)
        {
            System.out.println("\n\t\"Instructor Menu\"");
            System.out.println("1. View Your Programs");
            System.out.println("2. Add new Program");
            System.out.println("3. Update A Program");
            System.out.println("4. Delete A Program");
            System.out.println("5. View Enrolled Clients");
            System.out.println("6. Enroll a new Client");
            System.out.println("7. delete a client");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.next();
            scanner.nextLine();
            switch (choice)
            {
                case "1":
                    viewAllPrograms();
                    break;
                case "2":
                    addNewProgram();
                    break;
                case "3":
                    updateProgram();
                    break;
                case "4":
                    deleteProgram();
                    break;
                case "5":
                    viewClientsEnrolled();
                    break;
                case "6":
                    enrollNewClient();
                    break;
                case "7":
                    deleteClientByName();
                    break;
                case "8":
                    return;
                default:
                    System.err.println("Invalid input!\nPlease try again.");

            }

        }
    }

    private static void deleteClientByName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a program to delete a client from:");
        programService.displayAllProgramsNames();

        System.out.println("Enter the program name (make sure to write it correctly):");
        String programName = scanner.nextLine();

        Program chosenProgram = programService.findProgramByTitle(programName);
        if (chosenProgram != null) {

            if (chosenProgram.getClientsEnrolled().isEmpty()) {
                System.out.println("No clients are enrolled in this program.");
                return;
            }

            System.out.println("List of enrolled clients:");
            for (Client client : chosenProgram.getClientsEnrolled()) {
                System.out.println("- " + client.getName() + " (ID: " + client.getId() + ")");
            }

            System.out.println("Enter the client's name to delete:");
            String clientName = scanner.nextLine();

            // Step 6: Search for the client by name and remove them.
            boolean clientFound = false;
            Iterator<Client> iterator = chosenProgram.getClientsEnrolled().iterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                if (client.getName().equalsIgnoreCase(clientName)) {
                    iterator.remove();
                    clientFound = true;
                    System.out.println("Client " + clientName + " has been successfully removed.");
                    break;
                }
            }

            if (!clientFound) {
                System.err.println("No client with the name " + clientName + " found in this program.");
            }
        } else {
            System.err.println("There is no such program in your programs list.");
        }
    }


    private static void enrollNewClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a program to enroll a new client into:");
        programService.displayAllProgramsNames();

        System.out.println("Enter the program name: 'Make sure to write the name correctly'");
        String programName = scanner.nextLine();

        Program chosenProgram = programService.findProgramByTitle(programName);
        if (chosenProgram != null) {

            // Step 3: Gather client information.
            System.out.print("Enter the Client's Name: ");
            String clientName = scanner.nextLine();

            System.out.print("Enter the Client's ID: ");
            String clientId = scanner.nextLine();

            System.out.print("Enter the Client's Email: ");
            String clientEmail = scanner.nextLine();

            System.out.print("Enter the Client's Age: ");
            String clientAge = scanner.nextLine();

            // Step 4: Create a new Client object and add to the program.
            Client newClient = new Client(clientName,Long.parseLong(clientId),clientEmail,Integer.parseInt(clientAge));
            chosenProgram.clientsEnrolled.add(newClient);
            clients.add(newClient);
            System.out.println("Client " + clientName + " has been successfully enrolled in the program: " + programName);
        } else {
                System.err.println("There is no such program in your programs list");
            }

    }

    private static void viewClientsEnrolled() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the program you want to view the enrolled clients for: ");
        programService.displayAllProgramsNames();

        System.out.println("Write the program name that you want to view the enrolled clients: 'Make sure to write the name correctly' ");
        String programName = scanner.nextLine();

        Program chosenProgram = programService.findProgramByTitle(programName);
        if(chosenProgram != null)
        {
            List<Client> clientsEnrolledFotChosenProgram = chosenProgram.clientsEnrolled;
            if (clientsEnrolledFotChosenProgram.isEmpty()) {
                System.out.println("No clients enrolled.");
            } else {
                System.out.println("Enrolled Clients:");
                for (Client client : clientsEnrolledFotChosenProgram) {
                    System.out.println(client.getName());
                }
            }
        }
        else {
            System.err.println("There is no such program in your programs list");
        }
    }

    private static void deleteProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the program you want to delete to: ");
        programService.displayAllProgramsNames();

        System.out.println("Write the program name that you want Delete: 'Make sure to write the name correctly' ");
        String programName = scanner.nextLine();

        Program chosenProgram = programService.findProgramByTitle(programName);
        if(chosenProgram != null)
        {
            programService.deleteProgram(chosenProgram.getTitle());
            System.out.println("The Program has been deleted Successfully :)");
        }
        else
        {
            System.err.println("There is no such program in your programs list");
        }


    }

    private static void updateProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the program you want to make changes to: ");
        programService.displayAllProgramsNames();

        System.out.println("Write the program name that you want to make edits to: 'Make sure to write the name correctly' ");
        String programName = scanner.nextLine();

        Program chosenProgram = programService.findProgramByTitle(programName);
        if(chosenProgram != null)
        {
            System.out.println(programService.programDetailsAsString(chosenProgram));
            System.out.println("Please choose what do you want to edit : ");
            System.out.println("1. Edit Program Name");
            System.out.println("2. Edit Program Description");
            System.out.println("3. Edit Program Content");
            System.out.println("4. Edit Program Schedule");
            System.out.println("5. Edit Program Cost");
            System.out.println("6. Cancel");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();
            switch (choice)
            {
                case "1":
                    System.out.print(chosenProgram.getTitle() + "\nThe new Title is ");
                    programName = scanner.nextLine();
                    chosenProgram.setProgramTitle(programName);
                    System.out.println("The Program Name Updated Successfully :)");
                    break;
                case "2":
                    System.out.print(chosenProgram.getDuration() + "\nThe new Duration: ");
                    chosenProgram.setDuration(scanner.nextLine());

                    System.out.print(chosenProgram.getDifficultyLevel() + "\nThe new Difficulty Level: ");
                    chosenProgram.setDifficultyLevel(scanner.nextLine());

                    System.out.print(chosenProgram.getGoals() + "\nThe new Goal: ");
                    chosenProgram.setGoals(scanner.nextLine());

                    System.out.println("The Program's Description Updated Successfully :)");

                    break;
                case "3":
                    System.out.println(chosenProgram.getContent());
                    Content content = new Content(chosenProgram.getContent());

                    System.out.print(content.getVideoTutorials() + "\nThe new video's tutorial URL: ");
                    content.setVideoTutorial(scanner.nextLine());

                    System.out.print(content.getImages() + "\nThe new Image's URL: ");
                    content.setImages(scanner.nextLine());

                    System.out.print(content.getDocumentation() + "\nThe new Documentation's URL: ");
                    content.setDocumentation(scanner.nextLine());

                    chosenProgram.setContent(content);

                    System.out.println("The Program's Content Updated Successfully :)");
                    break;
                case "4":
                    System.out.println(chosenProgram.getSchedule());
                    Schedule chosenProgramSchedule = new Schedule(chosenProgram.getSchedule());


                    System.out.println(Arrays.toString(chosenProgramSchedule.getDays()) + "\nThe new Days: ");
                    String input = scanner.nextLine();
                    String[] days = input.split(",");
                    /////To trim spaces :)
                    for (int i = 0; i < days.length; i++) {
                        days[i] = days[i].trim();
                    }
                    chosenProgramSchedule.setDays(days);

                    System.out.println(chosenProgramSchedule.getTime());
                    System.out.println("Select a new time slot:");
                    System.out.println("1.  6:00 AM -  8:00 AM");
                    System.out.println("2. 10:00 AM - 12:00 PM");
                    System.out.println("3.  7:00 PM -  9:00 PM");
                    System.out.println("4.  5:00 PM -  7:00 PM");
                    input =  scanner.nextLine();
                    String time ;
                    switch (input)
                    {
                        case "1":
                            chosenProgramSchedule.setTime("6:00 AM -  8:00 AM");
                            break;
                        case "2":
                            chosenProgramSchedule.setTime("10:00 AM - 12:00 PM");
                            break;
                        case "3":
                            chosenProgramSchedule.setTime("5:00 PM -  7:00 PM");
                            break;
                        case "4":
                            chosenProgramSchedule.setTime("8:00 PM -  10:00 PM");
                            break;
                        default:
                            break;
                    }

                    System.out.println(chosenProgramSchedule.getScheduleType() + "\nThe new Schedule Type (online or in-person): ");
                    chosenProgramSchedule.setScheduleType(scanner.nextLine());

                    chosenProgram.setSchedule(chosenProgramSchedule);

                    System.out.println("The Schedule Have been updated Successfully :)");

                    break;
                case "5":
                    System.out.println(chosenProgram.getPrice() + "\nEnter The new program price");
                    chosenProgram.setPrice(scanner.nextLine());

                    System.out.println("The Program's Price Have been updated Successfully :)");

                    break;
                case "6":
                    return;
                default:
                    System.err.println("Invalid input!\nPlease try again.");
            }

        }
        else
        {
            System.err.println("There is no such program in your programs list");
        }

    }

    private static void addNewProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLet's Enter Our New Program Details :)");

        System.out.print("Enter the Program Title :\t");
        String programName = scanner.nextLine();

        System.out.print("\nEnter The Duration (e.g. 5 weeks) :\t");
        String duration = scanner.nextLine();

        System.out.print("\nEnter The Target Audience (e.g. Beginners):\t");
        String difficultyLevel = scanner.nextLine();

        System.out.print("\nEnter The Program Type (e.g. Weight Loss):\t");
        String goal = scanner.nextLine();

        System.out.print("\nEnter The Suitable Price for it (e.g. 30.33 $):\t");
        String price = scanner.nextLine();


        System.out.print("\nEnter The Training Days: (e.g. Tuesday, monday )\t");
        String input = scanner.nextLine();
        String[] days = input.split(",");
        /////To trim spaces :)
        for (int i = 0; i < days.length; i++) {
            days[i] = days[i].trim();
        }

        System.out.println("\nSelect a time slot:");
        System.out.println("1.  6:00 AM -  8:00 AM");
        System.out.println("2. 10:00 AM - 12:00 PM");
        System.out.println("3.  7:00 PM -  9:00 PM");
        System.out.println("4.  5:00 PM -  7:00 PM");
        input =  scanner.nextLine();
        String time = new String();
        switch (input)
        {
            case "1":
                time = "6:00 AM -  8:00 AM";
                break;
            case "2":
                time = "10:00 AM - 12:00 PM";
                break;
            case "3":
                time = "5:00 PM -  7:00 PM";
                break;
            case "4":
                time = "8:00 PM -  10:00 PM";
                break;
            default:
                break;

        }
        System.out.println("\nEnter if you want it Online or In-person :\t");
        String scheduleType = scanner.nextLine();

        Schedule schedule = new Schedule(days,time,scheduleType);

        System.out.println("\nPress 1 if you want to add the Content URLs\nPress 2 or any button to keep the default\n");
        String choice = scanner.nextLine();
        String url1,url2,url3;
        Content content;
        if(choice.equals("1"))
        {
            System.out.print("\nEnter The Video's URL on Youtube:\t");
            url1 = scanner.nextLine();

            System.out.print("\nEnter The Document's URL:\t");
            url2 = scanner.nextLine();

            System.out.print("\nEnter The Image's URL:\t");
            url3 = scanner.nextLine();

            content = new Content(url1,url2,url3);
        }
        else
        {
            content = new Content("https://youtu.be/f3zOrYCwquE", "https://unsplash.com/s/photos/gym", "https://www.everydayhealth.com/fitness/guide/");
        }
        Program newProgram = new Program(programName,duration,difficultyLevel,goal,content,schedule,price);
        programService.addProgram(newProgram);
        programs.add(newProgram);
        System.out.println("\nNew program added successfully!");
    }

    private static void viewAllPrograms() {
        programService.displayAllProgramsNames();
        System.out.println("\nPress 1 if you want to display all programs details \nPress any other button to return to the Instructor menu");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        scanner.nextLine();
        if (choice.equals("1"))
        {
            programService.displayAllPrograms();
        }
    }

    private static void adminMenu(Scanner scanner) {
    }

    public static void login(Scanner scanner) {
        System.out.print("Enter your User ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();


        if (currentUser.login(id, password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid login credentials.");
            return;
        }
    }


    private static void clientMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nClient Menu:");
            System.out.println("1. View Profile");
            System.out.println("2. Customize Profile");
            System.out.println("3. View Program Details");
            System.out.println("4. Rate Program");
            System.out.println("5. Track Progress");
            System.out.println("6. View Progress Summary");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    customizeProfile(scanner);
                    break;
                case 3:
                    viewProgramDetails(scanner);
                    break;
                case 4:
                    rateProgram(scanner);
                    break;
                case 5:
                    trackProgress(scanner);
                    break;
                case 6:
                    viewProgressSummary();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewProfile() {
        System.out.println("Displaying Profile Information...");
        System.out.println("Name: " + currentProfile.getName());
        System.out.println("Age: " + currentProfile.getAge());
        System.out.println("Fitness Goal: " + currentProfile.getFitnessGoal());
        System.out.println("Dietary Preferences: " + currentProfile.getDietaryPreferences());
        System.out.println("Dietary Restrictions: " + currentProfile.getDietaryRestrictions());
    }

    private static void customizeProfile(Scanner scanner) {
        System.out.println("Customizing Profile...");
        System.out.print("Enter new fitness goal: ");
        String fitnessGoal = scanner.nextLine();
        currentProfile.setFitnessGoal(fitnessGoal);

        System.out.print("Enter new dietary preferences: ");
        String dietaryPreferences = scanner.nextLine();
        currentProfile.setDietaryPreferences(dietaryPreferences);

        System.out.print("Enter new dietary restrictions: ");
        String dietaryRestrictions = scanner.nextLine();
        currentProfile.setDietaryRestrictions(dietaryRestrictions);

        System.out.println("Profile customized successfully!");
    }

    private static void viewProgramDetails(Scanner scanner) {
        System.out.print("Enter Program Name: ");
        String programName = scanner.nextLine();

        Map<String, String> programDetails = programManager.getProgramDetails(programName);
        if (programDetails != null) {
            System.out.println("Program Details:");
            programDetails.forEach((key, value) -> System.out.println(key + ": " + value));
        } else {
            System.out.println("Program not found.");
        }
    }

    private static void rateProgram(Scanner scanner) {
        System.out.print("Enter Program Name: ");
        String programName = scanner.nextLine();
        System.out.print("Enter Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();


        feedbackManager.addRating(programName, rating);
        double averageRating = feedbackManager.getAverageRating(programName);

        System.out.println("Program '" + programName + "' rated with a score of " + rating + " stars.");
        System.out.println("The updated average rating is: " + averageRating);
    }

    private static void trackProgress(Scanner scanner) {
        System.out.print("Enter your current weight: ");
        String weight = scanner.nextLine();

        System.out.print("Enter your current BMI: ");
        String bmi = scanner.nextLine();

        System.out.print("Enter your attendance percentage: ");
        String attendance = scanner.nextLine();

        progressManager.inputProgressData(weight, bmi, attendance);
        progressManager.recordProgressHistory("2025-01-02", weight, bmi, attendance);

        System.out.println("Progress recorded successfully!");
    }

    private static void viewProgressSummary() {
        Map<String, String> summary = progressManager.generateSummary(3, 5, "3kg", "0.6");
        System.out.println("Progress Summary: ");
        summary.forEach((key, value) -> System.out.println(key + ": " + value));
    }

}

