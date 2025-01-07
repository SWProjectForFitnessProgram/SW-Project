package org.example;


public enum SubscriptionPlan {
    BASIC("Basic"),
    PREMIUM("Premium");
    private final String planName;
    SubscriptionPlan(String planName) {
        this.planName = planName;
    }


    public String getPlanName() {
        return planName;
    }
}