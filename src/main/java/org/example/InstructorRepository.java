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
        return new ArrayList<>(instructors); //to avoid playing with the real Array so we send a copy
    }
    public Instructor findById(Long id) {
        return instructors.stream()
                .filter(instructor -> instructor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
