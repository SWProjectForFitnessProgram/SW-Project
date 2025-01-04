package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Manages feedback and reviews for fitness programs, including ratings, reviews, and suggestions.
 *
 * Author: Taqwa Odeh
 */
public class FeedbackAndReviewsManager {
    /**
     * Stores the ratings for each program.
     * The key is the program name, and the value is a list of ratings.
     */
    private Map<String, List<Integer>> programRatings = new HashMap<>();
    /**
     * Stores the reviews for each program.
     * The key is the program name, and the value is a list of reviews.
     */
    private Map<String, List<String>> programReviews = new HashMap<>();
    /**
     * Stores suggestions for each program.
     * The key is the program name, and the value is the suggestion.
     */
    private Map<String, String> programSuggestions = new HashMap<>();

    /**
     * Adds a rating to a specific program.
     *
     * @param programName The name of the program to rate.
     * @param rating      The rating to add (e.g., 1 to 5).
     */
    public void addRating(String programName, int rating) {
        programRatings.computeIfAbsent(programName, k -> new ArrayList<>()).add(rating);
    }

    /**
     * Calculates the average rating for a specific program.
     *
     * @param programName The name of the program to calculate the average rating for.
     * @return The average rating as a double. Returns 0.0 if no ratings are available.
     */
    public double getAverageRating(String programName) {
        List<Integer> ratings = programRatings.getOrDefault(programName, new ArrayList<>());
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }


    /**
     * Adds a review for a specific program.
     *
     * @param programName The name of the program to review.
     * @param review      The review text to add.
     */
    public void addReview(String programName, String review) {
        programReviews.computeIfAbsent(programName, k -> new ArrayList<>()).add(review);
    }


    /**
     * Retrieves the reviews for a specific program.
     *
     * @param programName The name of the program to get reviews for.
     * @return A list of reviews for the program. Returns an empty list if no reviews are available.
     */
    public List<String> getReviews(String programName) {
        return programReviews.getOrDefault(programName, new ArrayList<>());
    }

    /**
     * Adds a suggestion for a specific program.
     *
     * @param programName The name of the program to suggest an improvement for.
     * @param suggestion  The suggestion text to add.
     */
    public void addSuggestion(String programName, String suggestion) {
        programSuggestions.put(programName, suggestion);
    }

}
