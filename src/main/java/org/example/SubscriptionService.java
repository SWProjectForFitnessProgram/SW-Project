package org.example;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void assignSubscription(User user, User.SubscriptionPlan plan) {
        user.setSubscription(plan);
    }

    public void changeSubscription(User user, User.SubscriptionPlan newPlan) {
        user.setSubscription(newPlan);
    }
}
