package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SubscriptionService {

    public void assignSubscription(Client client, SubscriptionPlan plan) {
        client.setSubscriptionPlan(plan);
    }

    public void assignSubscription(Instructor instructor, SubscriptionPlan plan) {
        instructor.setSubscriptionPlan(plan);
    }

    public void changeSubscription(Client client, SubscriptionPlan newPlan) {
        client.setSubscriptionPlan(newPlan);
    }

    public void changeSubscription(Instructor instructor, SubscriptionPlan newPlan) {
        instructor.setSubscriptionPlan(newPlan);
    }

    public List<SubscriptionPlan> getAvailablePlans() {
        return Arrays.asList(SubscriptionPlan.BASIC, SubscriptionPlan.PREMIUM);
    }
}

