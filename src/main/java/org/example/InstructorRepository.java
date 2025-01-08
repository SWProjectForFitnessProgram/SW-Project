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
        boolean found = false;
        Instructor instructor = findInstructorByEmail(email);
        if (instructor != null) {
            instructor.setPassword(newPassword);
            instructor.setName(newName);
            found= true;
        }
        return found;
    }
    public Instructor findInstructorByEmail(String email) {
        for (Instructor instructor : instructors) {
            if (instructor.getEmail().equals(email)) {
                return instructor;
            }
        }
        return null;
    }


}
