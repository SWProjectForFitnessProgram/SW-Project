package org.example;

public class User {
    private String id;
    private String password;
    private boolean loggedIn = false;
    private Role role;
    SubscriptionPlan subscription;
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }
    public User() {
        this.id = "";
        this.password = "";
    }
//     Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubscriptionPlan() {
        return subscription != null ? subscription.getPlanName() : "No subscription";
    }

    public void setSubscription(SubscriptionPlan subscription) {
        this.subscription = subscription;
    }


    public boolean login(String id, String password) {
        if ("validId".equals(id) && "validPassword".equals(password)) {
            loggedIn = true;
            return true;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

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
}

