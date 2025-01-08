package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * Provides subscription-related services, including assigning and changing subscription plans for clients and instructors.
 * This service allows managing available subscription plans and assigning them to clients or instructors.
 *
 * @author Ghayda Saify
 */
public class SubscriptionService {

    /**
     * Assigns a subscription plan to a client.
     *
     * @param client The client to whom the subscription plan will be assigned.
     * @param plan The subscription plan to assign to the client.
     */
    public void assignSubscription(Client client, SubscriptionPlan plan) {
        client.setSubscriptionPlan(plan);
    }

    /**
     * Assigns a subscription plan to an instructor.
     *
     * @param instructor The instructor to whom the subscription plan will be assigned.
     * @param plan The subscription plan to assign to the instructor.
     */
    public void assignSubscription(Instructor instructor, SubscriptionPlan plan) {
        instructor.setSubscriptionPlan(plan);
    }

    /**
     * Changes the subscription plan of a client to a new plan.
     *
     * @param client The client whose subscription plan will be changed.
     * @param newPlan The new subscription plan to assign to the client.
     */
    public void changeSubscription(Client client, SubscriptionPlan newPlan) {
        client.setSubscriptionPlan(newPlan);
    }

    /**
     * Changes the subscription plan of an instructor to a new plan.
     *
     * @param instructor The instructor whose subscription plan will be changed.
     * @param newPlan The new subscription plan to assign to the instructor.
     */
    public void changeSubscription(Instructor instructor, SubscriptionPlan newPlan) {
        instructor.setSubscriptionPlan(newPlan);
    }

    /**
     * Returns a list of available subscription plans.
     *
     * @return A list containing the available subscription plans: BASIC and PREMIUM.
     */
    public List<SubscriptionPlan> getAvailablePlans() {
        return Arrays.asList(SubscriptionPlan.BASIC, SubscriptionPlan.PREMIUM);
    }
}
