package org.example;

public class Content {
    private String image;
    private String documentation;
    private String tutorial;

    public Content(String videoTutorial, String image, String documentation)
    {
        tutorial = videoTutorial;
        this.documentation = documentation;
        this.image = image;

    }

    public Content(Content content) {
        this.tutorial = content.getVideoTutorials();
        this.documentation = content.getDocumentation();
        this.image = content.getImages();
    }

    // Getters and Setters
    public String getImages() {
        return image;
    }

    public void setImages(String images) {
        this.image = images;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getVideoTutorials() {
        return tutorial;
    }

    public void setVideoTutorial(String videoTutorial) {
        System.out.println(tutorial);
        tutorial = videoTutorial;

    }

    @Override
    public String toString() {
        return "Resources{" +
                "images='" + image + '\'' +
                ", documentation='" + documentation + '\'' +
                ", videoTutorials='" + tutorial + '\'' +
                '}';
    }
}
