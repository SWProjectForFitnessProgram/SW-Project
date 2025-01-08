package org.example;

/**
 * Represents content with an image, documentation, and a video tutorial.
 * This class is used to store information about content, including a video tutorial,
 * an image, and related documentation.
 *
 * @author Tala Alhendi
 */
public class Content {
    private String image;
    private String documentation;
    private String tutorial;

    /**
     * Constructs a Content object with the specified video tutorial, image, and documentation.
     *
     * @param videoTutorial The video tutorial associated with the content.
     * @param image The image related to the content.
     * @param documentation The documentation associated with the content.
     */
    public Content(String videoTutorial, String image, String documentation) {
        tutorial = videoTutorial;
        this.documentation = documentation;
        this.image = image;
    }

    /**
     * Constructs a new Content object by copying the values from another Content object.
     *
     * @param content The Content object to copy values from.
     */
    public Content(Content content) {
        this.tutorial = content.getVideoTutorials();
        this.documentation = content.getDocumentation();
        this.image = content.getImages();
    }

    // Getters and Setters

    /**
     * Returns the image associated with the content.
     *
     * @return The image of the content.
     */
    public String getImages() {
        return image;
    }

    /**
     * Sets the image for the content.
     *
     * @param images The image to set for the content.
     */
    public void setImages(String images) {
        this.image = images;
    }

    /**
     * Returns the documentation associated with the content.
     *
     * @return The documentation of the content.
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * Sets the documentation for the content.
     *
     * @param documentation The documentation to set for the content.
     */
    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    /**
     * Returns the video tutorial associated with the content.
     *
     * @return The video tutorial of the content.
     */
    public String getVideoTutorials() {
        return tutorial;
    }

    /**
     * Sets the video tutorial for the content.
     *
     * @param videoTutorial The video tutorial to set for the content.
     */
    public void setVideoTutorial(String videoTutorial) {
        System.out.println(tutorial);
        tutorial = videoTutorial;
    }

    /**
     * Returns a string representation of the Content object.
     *
     * @return A string describing the content with its image, documentation, and video tutorial.
     */
    @Override
    public String toString() {
        return "Resources{" +
                "images='" + image + '\'' +
                ", documentation='" + documentation + '\'' +
                ", videoTutorials='" + tutorial + '\'' +
                '}';
    }
}
