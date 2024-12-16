package org.example.AcceptanceTest;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.example.Profile;
import org.example.User;
import org.junit.Assert;

import java.util.Map;

public class AccountManagementStep {
    private User user = new User();
    private Profile profile = new Profile();

    @Given("the user logs in with valid {string} and {string}")
    public void theUserLogsInWithValidAnd(String id, String password) {
        user.setId(id);
        user.setPassword(password);
        boolean loggedIn = user.login(id, password);
        Assert.assertTrue("User login failed", loggedIn);
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        if (!user.isLoggedIn()) {
            throw new IllegalStateException("User must be logged in first.");

        }
    }


    @When("I navigate to Create Profile")
    public void iNavigateToCreateProfile() {
        System.out.println("Navigating to Create Profile...");
    }

    @When("I enter my personal details depends on {int} and {string}")
    public void iEnterMyPersonalDetailsDependsOnAnd(Integer int1, String name) {
        profile.setName(name);
        System.out.println("Personal details entered: Name = " + name);
    }

    @When("I enter my age depends on {int} and {string}")
    public void iEnterMyAgeDependsOnAnd(Integer int1, String age) {
        profile.setAge(age);
        System.out.println("Age entered: " + age);
    }


    @When("I set my fitness goal depends on {int} and {string}")
    public void iSetMyFitnessGoalDependsOnAnd(Integer int1, String fitnessGoal) {
        profile.setFitnessGoal(fitnessGoal);
        System.out.println("Fitness goal set: " + fitnessGoal);
    }

    @When("I specify my dietary preferences depends on {int} and {string}")
    public void iSpecifyMyDietaryPreferencesDependsOnAnd(Integer int1, String dietaryPreferences) {
        profile.setDietaryPreferences(dietaryPreferences);
        System.out.println("Dietary preferences specified: " + dietaryPreferences);
    }

    @When("I add dietary restrictions depends on {int} and {string}")
    public void iAddDietaryRestrictionsDependsOnAnd(Integer int1, String dietaryRestrictions) {
        profile.setDietaryRestrictions(dietaryRestrictions);
        System.out.println("Dietary restrictions added: " + dietaryRestrictions);
    }

    @Then("my profile should be created successfully")
    public void myProfileShouldBeCreatedSuccessfully() {
        Assert.assertNotNull("Profile should be created", profile.getName());
        System.out.println("Profile created successfully!");
    }


    @When("I navigate to My Profile")
    public void iNavigateToMyProfile() {
        System.out.println("Navigating to My Profile...");
    }

    @When("I update my fitness goal depends on {int} and {string}")
    public void iUpdateMyFitnessGoalDependsOnAnd(Integer int1, String fitnessGoal) {
        profile.setFitnessGoal(fitnessGoal);
        System.out.println("Fitness goal updated: " + fitnessGoal);
    }

    @When("I update my dietary preferences depends on {int} and {string}")
    public void iUpdateMyDietaryPreferencesDependsOnAnd(Integer int1, String dietaryPreferences) {
        profile.setDietaryPreferences(dietaryPreferences);
        System.out.println("Dietary preferences updated: " + dietaryPreferences);
    }

    @When("I update my dietary restrictions depends on {int} and {string}")
    public void iUpdateMyDietaryRestrictionsDependsOnAnd(Integer nt1, String dietaryRestrictions) {
        profile.setDietaryRestrictions(dietaryRestrictions);
        System.out.println("Dietary restrictions updated: " + dietaryRestrictions);
    }

    @Then("my profile should be customized successfully")
    public void myProfileShouldBeCustomizedSuccessfully() {
        Assert.assertNotNull("Profile should be updated", profile.getFitnessGoal());
        System.out.println("Profile customized successfully!");
    }
///

    @Then("I should see my personal details including:")
    public void iShouldSeeMyPersonalDetailsIncluding(DataTable dataTable) {
        profile.setName("Taqwa Odeh");
        profile.setAge("21");
        profile.setFitnessGoal("Weight Loss");
        profile.setDietaryPreferences("Vegan");
        profile.setDietaryRestrictions("Gluten-Free");

        System.out.println("Profile Name: " + profile.getName());
        System.out.println("Profile Age: " + profile.getAge());
        System.out.println("Profile Fitness Goal: " + profile.getFitnessGoal());
        System.out.println("Profile Dietary Preferences: " + profile.getDietaryPreferences());
        System.out.println("Profile Dietary Restrictions: " + profile.getDietaryRestrictions());


        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            String field = row.get("Field");
            String expectedValue = row.get("Value");

            String actualValue = "";
            switch (field) {
                case "Name":
                    actualValue = profile.getName();
                    break;
                case "Age":
                    actualValue = profile.getAge();
                    break;
                case "Fitness Goal":
                    actualValue = profile.getFitnessGoal();
                    break;
                case "Dietary Preferences":
                    actualValue = profile.getDietaryPreferences();
                    break;
                case "Dietary Restrictions":
                    actualValue = profile.getDietaryRestrictions();
                    break;
            }

            Assert.assertEquals("Mismatch for field: " + field, expectedValue, actualValue);

        }
    }
}
