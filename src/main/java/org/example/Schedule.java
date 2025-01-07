package org.example;

public class Schedule {
    private String[] days;
    private String time;
    private String scheduleType;

    // Constructor
    public Schedule(String[] days, String time, String scheduleType) {
        this.days = days;
        this.time = time;
        this.scheduleType = scheduleType;
    }

    public Schedule(Schedule schedule) {
        this.scheduleType = schedule.getScheduleType();
        this.time = schedule.getTime();
        this.days = schedule.getDays();
    }

    // Getters and Setters
    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "days=" + String.join(", ", days) +
                ", time='" + time + '\'' +
                ", scheduleType='" + scheduleType + '\'' +
                '}';
    }

}
