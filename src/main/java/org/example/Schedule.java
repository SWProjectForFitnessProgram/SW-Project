package org.example;

/**
 * Represents a schedule with specified days, time, and type.
 */
public class Schedule {
    private String[] days; // Array of days for the schedule
    private String time; // Time of the schedule
    private String scheduleType; // Type of the schedule (e.g., class, meeting)

    /**
     * Constructor to initialize a schedule with days, time, and type.
     * @param days Array of days for the schedule.
     * @param time Time of the schedule.
     * @param scheduleType Type of the schedule.
     */
    public Schedule(String[] days, String time, String scheduleType) {
        this.days = days;
        this.time = time;
        this.scheduleType = scheduleType;
    }

    /**
     * Copy constructor to create a new schedule based on an existing schedule.
     * @param schedule Existing schedule to copy.
     */
    public Schedule(Schedule schedule) {
        this.scheduleType = schedule.getScheduleType();
        this.time = schedule.getTime();
        this.days = schedule.getDays();
    }

    /**
     * Retrieves the array of days for the schedule.
     * @return Array of days.
     */
    public String[] getDays() {
        return days;
    }

    /**
     * Sets the array of days for the schedule.
     * @param days New array of days.
     */
    public void setDays(String[] days) {
        this.days = days;
    }

    /**
     * Retrieves the time of the schedule.
     * @return Time of the schedule.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time of the schedule.
     * @param time New time for the schedule.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Retrieves the type of the schedule.
     * @return Type of the schedule.
     */
    public String getScheduleType() {
        return scheduleType;
    }

    /**
     * Sets the type of the schedule.
     * @param scheduleType New type for the schedule.
     */
    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    /**
     * Converts the schedule details to a string representation.
     * @return String representation of the schedule.
     */
    @Override
    public String toString() {
        return "Schedule{" +
                "days=" + String.join(", ", days) +
                ", time='" + time + '\'' +
                ", scheduleType='" + scheduleType + '\'' +
                '}';
    }
}
