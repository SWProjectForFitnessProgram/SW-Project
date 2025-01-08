package org.example;

/**
 * Represents an article with a name and user status.
 * This class is used to store information about an article, including its name
 * and the current status associated with the user.
 *
 * @author Ghayda Saify
 */
public class Article {

    private String name;
    private UserStatus status;

    /**
     * Constructs an Article object with the specified name and status.
     *
     * @param name The name of the article.
     * @param status The current status of the article.
     */
    public Article(String name, UserStatus status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Returns the current status of the article.
     *
     * @return The status of the article.
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the article.
     *
     * @param status The new status to set for the article.
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
