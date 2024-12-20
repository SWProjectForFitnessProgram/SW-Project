package org.example;

public class Program {
    String programTitle;
    String duration;
    String difficultyLevel;
    String goals;
    String content;
    String price;
    public Program(String programTitle, String duration, String difficultyLevel, String goals, String content, String price) {
        this.programTitle = programTitle;
        this.duration = duration;
        this.difficultyLevel  = difficultyLevel;
        this.goals = goals;
        this.content = content;
        this.price = price;
    }

    public String getTitle() {
        return programTitle;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;

    }

    public void setGoals(String goals) {
        this.goals = goals;

    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getGoals() {
        return goals;
    }

    public String getContent() {
        return content;
    }

    public String getPrice() {
        return price;
    }
}
