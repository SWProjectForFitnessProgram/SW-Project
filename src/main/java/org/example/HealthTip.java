package org.example;

/**
 * Represents a health tip with its name and status.
 * Author: Gaidaa
 */
public class HealthTip {

    private String name;
    private UserStatus status;

    /**
     * Constructor to create a health tip.
     *
     * @param name   the name of the health tip.
     * @param status the status of the health tip.
     */
    public HealthTip(String name, UserStatus status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Gets the name of the health tip.
     *
     * @return the name of the health tip.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the status of the health tip as a string.
     *
     * @return the status of the health tip.
     */
    public String getStatus() {
        return String.valueOf(status);
    }

    /**
     * Sets the status of the health tip.
     *
     * @param status the new status of the health tip.
     * @throws IllegalArgumentException if the status value is invalid.
     */
    public void setStatus(String status) {
        this.status = UserStatus.valueOf(status);
    }
}
