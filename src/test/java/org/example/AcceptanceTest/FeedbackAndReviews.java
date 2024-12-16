package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.FeedbackAndReviewsManager;
import org.junit.Assert;

import java.util.List;

public class FeedbackAndReviews {
    private FeedbackAndReviewsManager manager = new FeedbackAndReviewsManager();
    private String completedProgram;
    private int rating;
    private String review;
    private String suggestion;

    @Given("I have completed a fitness program named {string}")
    public void iHaveCompletedAFitnessProgramNamed(String programName) {
        completedProgram = programName;
        System.out.println("Completed program: " + programName);
    }


    @When("I rate the program with a score of {int} out of {int}")
    public void iRateTheProgramWithAScoreOfOutOf(Integer  givenRating, Integer maxRating) {
        Assert.assertTrue("Rating must be between 1 and " + maxRating, givenRating > 0 && givenRating <= maxRating);
        rating = givenRating;

        manager.addRating(completedProgram, rating);

        System.out.println("Rating submitted: " + givenRating);
    }


    @Then("the program should display an updated average rating")
    public void theProgramShouldDisplayAnUpdatedAverageRating() {
        double averageRating = manager.getAverageRating(completedProgram);

        Assert.assertTrue("Average rating is incorrect", averageRating > 0);
        System.out.println("Updated average rating: " + averageRating);
    }

    @When("I submit a review saying {string}")
    public void iSubmitAReviewSaying(String givenReview) {
        Assert.assertNotNull("Review cannot be null", givenReview);
        review = givenReview;


        manager.addReview(completedProgram, review);

        System.out.println("Review submitted: " + givenReview);
    }


    @Then("the review should be visible under the program's details section")
    public void theReviewShouldBeVisibleUnderTheProgramSDetailsSection() {
        List<String> reviews = manager.getReviews(completedProgram);

        Assert.assertTrue("Review is not visible", reviews.contains(review));
        System.out.println("Review visible: " + reviews);
    }


    @When("I submit a suggestion saying {string}")
    public void iSubmitASuggestionSaying(String givenSuggestion) {
        Assert.assertNotNull("Suggestion cannot be null", givenSuggestion);
        suggestion = givenSuggestion;

        manager.addSuggestion(completedProgram, suggestion);

        System.out.println("Suggestion submitted: " + givenSuggestion);
    }

    @Then("Your suggestion has been sent to the instructor")
    public void yourSuggestionHasBeenSentToTheInstructor() {

        System.out.println("Your suggestion has been sent to the instructor");
    }

}
