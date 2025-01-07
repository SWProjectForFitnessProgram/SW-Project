package org.example;

public class User {
    private String id;
    private String password;
    private boolean loggedIn = false;
    private Role role;
    SubscriptionPlan subscription;

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



    public void setPassword(String password) {
        this.password = password;
    }

    public String getSubscriptionPlan() {
        return subscription != null ? subscription.getPlanName() : "No subscription";
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


}

