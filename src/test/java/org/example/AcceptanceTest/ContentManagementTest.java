package org.example.AcceptanceTest;

import io.cucumber.java.Before;
import org.example.*;
import org.junit.BeforeClass;
import org.mockito.Mock;
import org.mockito.Mockito;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.example.UserStatus.Pending;
import static org.junit.Assert.assertEquals;

public class ContentManagementTest {


    private static Admin admin ;
    private static Main app;
    private List<Map<String, String>> actualData;
    private static Article article;
    private static HealthTip tip;
    private static Recipe recipe;
    private static Complaint complaint;
    private static InstructorRepository instructorRepository;
    private static ClientRepository clientRepository;

    private static AdminService contentService;

    @Before
    public static void setup() {
        admin = new Admin(instructorRepository, clientRepository);
        app = new Main();
        article = new Article("jahdfk",UserStatus.Approved);
        tip = new HealthTip("jahfdkj", Pending);
        recipe = new Recipe("jahksfd", Pending);
        complaint = new Complaint("jaskjdf", Pending);
        contentService = admin;
    }




//    public ContentManagementTest() {
//        admin = new Admin();
//        app = new Main();
//        this.contentService = new Admin();
//        recipe = new Recipe("jhsakjf","Pending");
//    }


    @Given("the wellness article {string} is pending approval")
    public void theWellnessArticleIsPendingApproval(String articleName) {

        article = new Article(articleName, Pending);
        contentService.addArticle(article);
    }
    @When("I approve the article")
    public void iApproveTheArticle() {
        contentService.approveArticle(article);
    }
    @When("I reject the article")
    public void iRejectTheArticle() {
        contentService.rejectArticle(article);

    }
    @Then("the article status should be {string}")
    public void theArticleStatusShouldBe(String expectedStatus) {
        assertEquals(expectedStatus, String.valueOf(article.getStatus()));

    }




    @Given("the user has submitted a complaint about {string}")
    public void theUserHasSubmittedAComplaintAbout(String programName) {
        complaint = new Complaint(programName, Pending);
        contentService.addComplaint(complaint);
    }
    @When("I review the complaint")
    public void iReviewTheComplaint() {
        contentService.resolveComplaint(complaint);

    }
    @Then("I should be able to mark the complaint as {string}")
    public void iShouldBeAbleToMarkTheComplaintAs(String expectedStatus) {
        assertEquals(expectedStatus, complaint.getStatus());

    }

    @Given("the health tip {string} is pending approval")
    public void theHealthTipIsPendingApproval(String tipName) {
        tip = new HealthTip(tipName, Pending);
        contentService.addTip(tip);
    }
    @When("I approve the tip")
    public void iApproveTheTip() {
        contentService.approveTip(tip);

    }
    @Then("the tip status should be {string}")
    public void theTipStatusShouldBe(String expectedStatus) {
        assertEquals(expectedStatus, tip.getStatus());

    }


    @Given("the recipe {string} is pending approval")
    public void theRecipeIsPendingApproval(String recipeName) {
        recipe = new Recipe(recipeName, Pending);
        contentService.addRecipe(recipe);
    }
    @When("I reject the recipe")
    public void iRejectTheRecipe() {
        contentService.rejectRecipe(recipe);
    }
    @Then("the recipe status should be {string}")
    public void theRecipeStatusShouldBe(String expectedStatus) {
        assertEquals(expectedStatus, recipe.getStatus());

    }







}
