package org.example;
/**
 * Represents the various roles that a user can have in the system.
 * This enum defines the roles: ADMIN, INSTRUCTOR, and CLIENT.
 *
 * <p>Author: Gaidaa</p>
 */
public enum Role{
    /**
     * Represents an administrator role with the highest level of access.
     */
    ADMIN,
    /**
     * Represents an instructor role who can teach or manage courses.
     */
    INSTRUCTOR,
    /**
     * Represents a client role, typically a user interacting with the system.
     */
    CLIENT
}
