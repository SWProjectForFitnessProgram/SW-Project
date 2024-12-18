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
}
