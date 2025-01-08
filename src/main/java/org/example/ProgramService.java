package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProgramService {
    private List<Client> clients = new ArrayList<>();
    private String deletionStatus;
    private String deletionMessage;
    private final List<Program> programList;
    public ProgramService() {
        programList = new ArrayList<>();
    }
    public void addProgram(Program program) {

        programList.add(program);
    }

    public Program getProgramByTitle(String programTitle) {
        for (Program program : programList) {
            if (program.getTitle().equals(programTitle)) {
                return program;
            }
        }
        return null;
    }

    public void updateProgram( Program programToUpdate) {
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

    public void deleteProgram(String title) {
        Program programToDelete = getProgramByTitle(title);
        if (programToDelete != null) {
            programList.remove(programToDelete);
            deletionStatus = "Success";
            deletionMessage="Program deleted successfully";
            return ;
        }
        deletionStatus = "Failure";
        deletionMessage = "Program with title \"<program_title>\" not found.";

    }
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
    public void displayAllProgramsNames()
    {
        if (programList.isEmpty()) {
            System.out.println("No programs available.");
        } else {
            System.out.println("Available Programs:");
            for (Program program : programList) {
                System.out.println("- " + program.getTitle());
            }
        }
    }
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


    public String getDeletionStatus() {
        return deletionStatus;
    }

    public String getDeletionMessage() {
        return deletionMessage;
    }

    public Program findProgramByTitle(String programTitle) {
        for (Program program : programList) {
            if (program.getTitle().equalsIgnoreCase(programTitle)) {
                return program;
            }
        }
        // If no program found with the given title, return null
        return null;
    }
}
