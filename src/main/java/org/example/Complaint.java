package org.example;

public class Complaint {
    private String programName;
    private UserStatus status;

    public Complaint(String programName, UserStatus status) {
        this.programName = programName;
        this.status =status;
    }

    public String getProgramName() {
        return programName;
    }

    public String getStatus() {
        return String.valueOf(status);
    }

    public void setStatus(String status) {
        this.status = UserStatus.valueOf(status);
    }
}
