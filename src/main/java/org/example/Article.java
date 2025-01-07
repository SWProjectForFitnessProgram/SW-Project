package org.example;

/**
 * Represents an article with a name and status.
 * Author: gaidaa
 */
public class Article {

    private String name;
    private UserStatus status;

    /**
     * Constructs an Article with the specified name and status.
     *
     * @param name   the name of the article.
     * @param status the {@link UserStatus} of the article.
     */
    public Article(String name, UserStatus status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Retrieves the name of the article.
     *
     * @return the name of the article.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the status of the article.
     *
     * @return the {@link UserStatus} of the article.
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * Updates the status of the article.
     *
     * @param status the new {@link UserStatus} of the article.
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
