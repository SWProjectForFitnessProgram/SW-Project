package org.example;

/**
 * Represents a user in the system with login functionality, subscription plan, and role.
 * A user can be either logged in or logged out and can have a subscription plan.
 *
 * <p>Author: Gaidaa</p>
 */
public class User {

    private String id;
    private String password;
    private boolean loggedIn = false;
    private Role role;
    private SubscriptionPlan subscription;

    /**
     * Constructs a user with the specified id and password.
     *
     * @param id The unique identifier of the user.
     * @param password The password of the user.
     */
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    /**
     * Constructs a user with default values (empty id and password).
     */
    public User() {
        this.id = "";
        this.password = "";
    }

    // Getters and setters

    /**
     * Gets the user's id.
     *
     * @return The id of the user.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the user's id.
     *
     * @param id The unique identifier to set for the user.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the user's password.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password The password to set for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the subscription plan name of the user.
     *
     * @return The name of the subscription plan, or "No subscription" if the user has no subscription.
     */
    public String getSubscriptionPlan() {
        return subscription != null ? subscription.getPlanName() : "No subscription";
    }

    /**
     * Sets the subscription plan for the user.
     *
     * @param subscription The subscription plan to set for the user.
     */
    public void setSubscription(SubscriptionPlan subscription) {
        this.subscription = subscription;
    }

    /**
     * Attempts to log the user in by verifying the provided id and password.
     *
     * @param id The id of the user.
     * @param password The password of the user.
     * @return {@code true} if the login is successful, {@code false} otherwise.
     */
    public boolean login(String id, String password) {
        if ("validId".equals(id) && "validPassword".equals(password)) {
            loggedIn = true;
            return true;
        }
        return false;
    }

    /**
     * Checks if the user is logged in.
     *
     * @return {@code true} if the user is logged in, {@code false} otherwise.
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Enum representing the subscription plans available for a user.
     */
    public enum SubscriptionPlan {

        /**
         * Basic subscription plan.
         */
        BASIC("Basic"),

        /**
         * Premium subscription plan.
         */
        PREMIUM("Premium");

        private final String planName;

        /**
         * Constructs a subscription plan with the specified plan name.
         *
         * @param planName The name of the subscription plan.
         */
        SubscriptionPlan(String planName) {
            this.planName = planName;
        }

        /**
         * Gets the name of the subscription plan.
         *
         * @return The name of the plan.
         */
        public String getPlanName() {
            return planName;
        }
    }
}
