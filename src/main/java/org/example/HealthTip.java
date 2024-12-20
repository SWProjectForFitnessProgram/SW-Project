package org.example;

public class HealthTip {
    private String name;
    private UserStatus status;

    public HealthTip(String name, UserStatus status) {
        this.name = name;
        this.status =status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(String status) {
        this.status = UserStatus.valueOf(status);
    }
}
