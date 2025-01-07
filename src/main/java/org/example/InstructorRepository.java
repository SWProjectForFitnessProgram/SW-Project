package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/**
 * A repository for managing a collection of instructors.
 * This class allows adding, updating, and searching for instructors
 * by email or ID. It also provides functionality to retrieve all instructors
 * and those that are pending approval.
 *
 * <p>Author: Gaidaa</p>
 */
public class InstructorRepository {
    private List<Instructor> instructors = new ArrayList<>();
    /**
     * Adds a new instructor to the repository.
     *
     * @param instructor The instructor to be added.
     */
    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }
    /**
     * Retrieves all instructors who are pending approval.
     *
     * @return A list of instructors who are not approved.
     */
    public List<Instructor> findPendingInstructors() {
        return instructors.stream()
                .filter(instructor -> !instructor.isApproved())
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all instructors in the repository.
     *
     * @return A collection of all instructors.
     */
    public Collection<Instructor> getAllInstructors() {
        return instructors;
    }
    /**
     * Updates an instructor's password and name based on their email.
     *
     * @param email The email of the instructor to be updated.
     * @param newPassword The new password for the instructor.
     * @param newName The new name of the instructor.
     * @return {@code true} if the instructor was found and updated;
     *         {@code false} if the instructor with the given email does not exist.
     */
    public boolean updateInstructor(String email, String newPassword, String newName) {
        Instructor instructor = findInstructorByEmail(email);
        if (instructor != null) {
            instructor.setPassword(newPassword);
            instructor.setName(newName);
            return true;
        }
        return false;
    }
    /**
     * Finds an instructor by their email.
     *
     * @param email The email of the instructor to find.
     * @return The instructor with the given email, or {@code null} if no such instructor exists.
     */
    public Instructor findInstructorByEmail(String email) {
        for (Instructor instructor : instructors) {
            if (instructor.getEmail().equals(email)) {
                return instructor;
            }
        }
        return null;
    }

    /**
     * Finds an instructor by their unique ID.
     *
     * @param id The ID of the instructor to find.
     * @return The instructor with the given ID, or {@code null} if no such instructor exists.
     */
    public Instructor findById(Long id) {
        return instructors.stream()
                .filter(instructor -> instructor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
