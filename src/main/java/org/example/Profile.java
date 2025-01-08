package org.example;
/**
 * Represents a user's profile with personal details and fitness preferences.
 *
 * @author  Taqwa Odeh
 */
public class Profile {
    private String name;
    private String age;
    private String fitnessGoal;
    private String dietaryPreferences;
    private String dietaryRestrictions;

    /**
     * Gets the user's name.
     *
     * @return The name of the user as a String.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the user's name.
     *
     * @param name The name to set for the user.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the user's age.
     *
     * @return The age of the user as a String.
     */

    public String getAge() {
        return age;
    }
    /**
     * Sets the user's age.
     *
     * @param age The age to set for the user.
     */
    public void setAge(String age) {
        this.age = age;
    }
    /**
     * Gets the user's fitness goal.
     *
     * @return The fitness goal of the user as a String.
     */
    public String getFitnessGoal() {
        return fitnessGoal;
    }
    /**
     * Sets the user's fitness goal.
     *
     * @param fitnessGoal The fitness goal to set for the user.
     */
    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }
    /**
     * Gets the user's dietary preferences.
     *
     * @return The dietary preferences of the user as a String.
     */
    public String getDietaryPreferences() {
        return dietaryPreferences;
    }

    /**
     * Sets the user's dietary preferences.
     *
     * @param dietaryPreferences The dietary preferences to set for the user.
     */
    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }
    /**
     * Gets the user's dietary restrictions.
     *
     * @return The dietary restrictions of the user as a String.
     */
    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }
    /**
     * Sets the user's dietary restrictions.
     *
     * @param dietaryRestrictions The dietary restrictions to set for the user.
     */
    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}
