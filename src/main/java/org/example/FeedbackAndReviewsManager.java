package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedbackAndReviewsManager {

    private Map<String, List<Integer>> programRatings = new HashMap<>();
    private Map<String, List<String>> programReviews = new HashMap<>();
    private Map<String, String> programSuggestions = new HashMap<>();

    // Add a rating to a program
    public void addRating(String programName, int rating) {
        programRatings.computeIfAbsent(programName, k -> new ArrayList<>()).add(rating);
    }

    // Calculate average rating for a program
    public double getAverageRating(String programName) {
        List<Integer> ratings = programRatings.getOrDefault(programName, new ArrayList<>());
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    // Add a review for a program
    public void addReview(String programName, String review) {
        programReviews.computeIfAbsent(programName, k -> new ArrayList<>()).add(review);
    }

    // Get reviews for a program
    public List<String> getReviews(String programName) {
        return programReviews.getOrDefault(programName, new ArrayList<>());
    }

    // Add a suggestion for a program
    public void addSuggestion(String programName, String suggestion) {
        programSuggestions.put(programName, suggestion);
    }

    // Get suggestion for a program
    public String getSuggestion(String programName) {
        return programSuggestions.get(programName);
    }
}
