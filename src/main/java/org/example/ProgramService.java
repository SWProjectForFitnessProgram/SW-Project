package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProgramService {
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

    public Boolean updateProgram(String title, Program updatedProgram) {
        Program existingProgram = getProgramByTitle(title);
        if (existingProgram != null) {
            existingProgram.setDuration(updatedProgram.getDuration());
            existingProgram.setDifficultyLevel(updatedProgram.getDifficultyLevel());
            existingProgram.setGoals(updatedProgram.getGoals());
            existingProgram.setContent(updatedProgram.getContent());
            existingProgram.setPrice(updatedProgram.getPrice());
            return true;
        }
        return false;
    }
    // Delete a program
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
        return ;
    }

    // Get all programs
    public List<Program> getAllPrograms() {
        return programList;
    }
    // This method checks if a program with the specified title exists
    public boolean searchIfExists(List<Program> programList, String programTitle) {
        for (Program p : programList) {
            if (p.getTitle().equals(programTitle)) {
                return true; // Program exists
            }
        }
        return false; // Program does not exist
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

    private String programDetailsAsString(Program program) {
        return String.format(
                "Title: %s, Duration: %s, Difficulty Level: %s, Goals: %s, Content: %s, Price: %s",
                program.getTitle(),
                program.getDuration(),
                program.getDifficultyLevel(),
                program.getGoals(),
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
}
