package org.example;

public class User {
    private String id;
    private String password;
    private boolean loggedIn = false;

    // Getters and setters
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

