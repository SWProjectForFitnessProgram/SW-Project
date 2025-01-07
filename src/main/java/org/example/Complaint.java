package org.example;

/**
 * Represents a complaint related to a specific program.
 * Author:  Gaidaa
 */
public class Complaint {

    private String programName;
    private UserStatus status;

    /**
     * Constructor to create a new complaint.
     *
     * @param programName the name of the program related to the complaint.
     * @param status      the current status of the complaint.
     */
    public Complaint(String programName, UserStatus status) {
        this.programName = programName;
        this.status = status;
    }

    /**
     * Gets the name of the program associated with the complaint.
     *
     * @return the program name.
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * Gets the status of the complaint as a string.
     *
     * @return the status of the complaint.
     */
    public String getStatus() {
        return String.valueOf(status);
    }

    /**
     * Sets the status of the complaint.
     *
     * @param status the new status of the complaint.
     * @throws IllegalArgumentException if the status value is invalid.
     */
    public void setStatus(String status) {
        this.status = UserStatus.valueOf(status);
    }
}
