package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides services for managing programs, including adding, updating, deleting,
 * and retrieving programs. This service can handle a list of programs and allows
 * operations such as displaying program details, searching for programs, and
 * managing their deletion status.
 *
 * @author Tala Ahendi
 */
public class ProgramService {
    private List<Client> clients = new ArrayList<>();
    private String deletionStatus;
    private String deletionMessage;
    private final List<Program> programList;

    /**
     * Constructs a ProgramService instance and initializes the list of programs.
     *
     * test
     */
    public ProgramService() {
        programList = new ArrayList<>();
    }

    /**
     * Adds a new program to the list of programs.
     *
     * @param program The program to be added.
     */
    public void addProgram(Program program) {
        programList.add(program);
    }

    /**
     * Retrieves a program by its title.
     *
     * @param programTitle The title of the program to retrieve.
     * @return The program with the specified title, or null if no such program exists.
     */
    public Program getProgramByTitle(String programTitle) {
        for (Program program : programList) {
            if (program.getTitle().equals(programTitle)) {
                return program;
            }
        }
        return null;
    }

    /**
     * Updates an existing program's details.
     *
     * @param programToUpdate The program with updated details.
     */
    public void updateProgram(Program programToUpdate) {
        Program existingProgram = getProgramByTitle(programToUpdate.getTitle());
        if (existingProgram != null) {
            existingProgram.setDuration(programToUpdate.getDuration());
            existingProgram.setDifficultyLevel(programToUpdate.getDifficultyLevel());
            existingProgram.setGoals(programToUpdate.getGoals());
            existingProgram.setContent(programToUpdate.getContent());
            existingProgram.setSchedule(programToUpdate.getSchedule());
            existingProgram.setPrice(programToUpdate.getPrice());

            System.out.println("Program updated successfully: " + existingProgram.getTitle());
        } else {
            System.out.println("Program with title '" + programToUpdate.getTitle() + "' not found.");
        }
    }

    /**
     * Deletes a program by its title.
     *
     * @param title The title of the program to delete.
     */
    public void deleteProgram(String title) {
        Program programToDelete = getProgramByTitle(title);
        if (programToDelete != null) {
            programList.remove(programToDelete);
            deletionStatus = "Success";
            deletionMessage = "Program deleted successfully";
            return;
        }
        deletionStatus = "Failure";
        deletionMessage = "Program with title \"" + title + "\" not found.";
    }

    /**
     * Displays the details of all programs in the list.
     */
    public void displayAllPrograms() {
        if (programList.isEmpty()) {
            System.out.println("No programs available.");
        } else {
            System.out.println("Available Programs:");
            for (Program program : programList) {
                System.out.println(programDetailsAsString(program));
            }
        }
    }

    /**
     * Displays the titles of all programs in the list.
     */
    public void displayAllProgramsNames() {
        if (programList.isEmpty()) {
            System.out.println("No programs available.");
        } else {
            System.out.println("Available Programs:");
            for (Program program : programList) {
                System.out.println("- " + program.getTitle());
            }
        }
    }

    /**
     * Converts the details of a program to a string format.
     *
     * @param program The program to convert to a string.
     * @return A string containing the details of the program.
     */
    public String programDetailsAsString(Program program) {
        return String.format(
                "Title: %s, Duration: %s, Difficulty Level: %s, Goals: %s, Schedule: %s, Content: %s, Price: %s",
                program.getTitle(),
                program.getDuration(),
                program.getDifficultyLevel(),
                program.getGoals(),
                program.getSchedule(),
                program.getContent(),
                program.getPrice()
        );
    }

    /**
     * Returns the deletion status of the last delete operation.
     *
     * @return The deletion status ("Success" or "Failure").
     */
    public String getDeletionStatus() {
        return deletionStatus;
    }

    /**
     * Returns the message corresponding to the last delete operation.
     *
     * @return The deletion message.
     */
    public String getDeletionMessage() {
        return deletionMessage;
    }

    /**
     * Finds a program by its title, ignoring case.
     *
     * @param programTitle The title of the program to find.
     * @return The program with the specified title, or null if no such program exists.
     */
    public Program findProgramByTitle(String programTitle) {
        for (Program program : programList) {
            if (program.getTitle().equalsIgnoreCase(programTitle)) {
                return program;
            }
        }
        return null;
    }
}
