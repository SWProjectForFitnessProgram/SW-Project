package org.example;

/**
 * Enum representing different subscription plans available in the system.
 * It includes the basic and premium subscription plans.
 * Each subscription plan has a name associated with it.
 *
 * @author Ghayda Saify
 */
public enum SubscriptionPlan {

    /** Basic subscription plan. */
    BASIC("Basic"),

    /** Premium subscription plan. */
    PREMIUM("Premium");

    private final String planName;

    /**
     * Constructor to initialize a SubscriptionPlan with a plan name.
     *
     * @param planName The name of the subscription plan.
     */
    SubscriptionPlan(String planName) {
        this.planName = planName;
    }

    /**
     * Returns the name of the subscription plan.
     *
     * @return The name of the subscription plan.
     */
    public String getPlanName() {
        return planName;
    }
}
