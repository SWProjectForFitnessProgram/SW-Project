package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Manages fitness programs including filtering and retrieving details.
 *
 * Author: Taqwa Odeh
 */
public class ProgramManager {
    /**
     * List of available fitness programs.
     */
    private List<Map<String, String>> programs = List.of(
            Map.of("Name", "Beginner Weight Loss Plan", "Difficulty", "Beginner", "Focus Area", "Weight Loss", "Duration", "8 Weeks", "Schedule", "Monday, Wednesday"),
            Map.of("Name", "Advanced Muscle Building Plan", "Difficulty", "Advanced", "Focus Area", "Muscle Building", "Duration", "12 Weeks", "Schedule", "Monday, Wednesday, Friday")
    );
    /**
     * Filters programs based on difficulty level.
     *
     * @param difficulty The difficulty level to filter by (e.g., "Beginner", "Advanced").
     * @return A list of programs matching the specified difficulty level.
     */
    public List<Map<String, String>> filterByDifficulty(String difficulty) {
        return programs.stream()
                .filter(program -> program.get("Difficulty").equals(difficulty))
                .collect(Collectors.toList());
    }
    /**
     * Filters programs based on focus area.
     *
     * @param focusArea The focus area to filter by (e.g., "Weight Loss", "Muscle Building").
     * @return A list of programs matching the specified focus area.
     */
    public List<Map<String, String>> filterByFocusArea(String focusArea) {
        return programs.stream()
                .filter(program -> program.get("Focus Area").equals(focusArea))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the details of a specific program by its name.
     *
     * @param programName The name of the program to retrieve details for.
     * @return A map containing the program's details, or null if no program with the specified name exists.
     */
    public Map<String, String> getProgramDetails(String programName) {
        return programs.stream()
                .filter(program -> program.get("Name").equals(programName))
                .findFirst()
                .orElse(null);
    }
}
