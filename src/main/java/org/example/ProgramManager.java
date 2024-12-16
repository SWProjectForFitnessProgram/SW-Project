package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramManager {

    private List<Map<String, String>> programs = List.of(
            Map.of("Name", "Beginner Weight Loss Plan", "Difficulty", "Beginner", "Focus Area", "Weight Loss", "Duration", "8 Weeks", "Schedule", "Monday, Wednesday"),
            Map.of("Name", "Advanced Muscle Building Plan", "Difficulty", "Advanced", "Focus Area", "Muscle Building", "Duration", "12 Weeks", "Schedule", "Monday, Wednesday, Friday")
    );

    public List<Map<String, String>> filterByDifficulty(String difficulty) {
        return programs.stream()
                .filter(program -> program.get("Difficulty").equals(difficulty))
                .collect(Collectors.toList());
    }

    public List<Map<String, String>> filterByFocusArea(String focusArea) {
        return programs.stream()
                .filter(program -> program.get("Focus Area").equals(focusArea))
                .collect(Collectors.toList());
    }


    public Map<String, String> getProgramDetails(String programName) {
        return programs.stream()
                .filter(program -> program.get("Name").equals(programName))
                .findFirst()
                .orElse(null);
    }
}
