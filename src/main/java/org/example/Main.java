package org.example;
import java.util.Map;
import java.util.Scanner;


public class Main {
    private static User currentUser = new User();
    private static Profile currentProfile = new Profile();
    private static ProgramManager programManager = new ProgramManager();
    private static FeedbackAndReviewsManager feedbackManager = new FeedbackAndReviewsManager();
    private static ProgressManager progressManager = new ProgressManager();

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        Scanner scanner = new Scanner(System.in);


        login(scanner);


        menu(scanner);

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


    private static void menu(Scanner scanner) {
        while (true) {
            System.out.println("\nMain Menu:");
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

