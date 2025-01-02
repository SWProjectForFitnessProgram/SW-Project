package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InstructorRepository {
    private List<Instructor> instructors = new ArrayList<>();

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public List<Instructor> findPendingInstructors() {
        return instructors.stream()
                .filter(instructor -> !instructor.isApproved())
                .collect(Collectors.toList());
    }


    public Collection<Instructor> getAllInstructors() {
        return instructors;
    }

    public boolean updateInstructor(String email, String newPassword, String newName) {
        Instructor instructor = findInstructorByEmail(email);
        if (instructor != null) {
            instructor.setPassword(newPassword);
            instructor.setName(newName);
            return true;
        }
        return false;
    }
    public Instructor findInstructorByEmail(String email) {
        for (Instructor instructor : instructors) {
            if (instructor.getEmail().equals(email)) {
                return instructor;
            }
        }
        return null;
    }


    public Instructor findById(Long id) {
        return instructors.stream()
                .filter(instructor -> instructor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
